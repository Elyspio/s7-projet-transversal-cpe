import {MovementModel} from "../../controllers/resources/models";
import {Repositories} from "../../database/repositories";
import {FiremanEntity} from "../../database/entities/FiremanEntity";
import {Assemblers} from "../assembler";
import {TravelState} from "../../database/entities/TruckEntity";


export class MovingService {

    async getMovement(idResource: number): Promise<MovementModel> {
        const trucks = await Repositories.truck.find({where: {id_resource: idResource}});
        const firemen: FiremanEntity[] = trucks.reduce((acc, current) => [...acc, ...current.firemen], [])

        return {
            firemen: Assemblers.fireman.collectionToModel(firemen),
            trucks: Assemblers.truck.collectionToModel(trucks),
            locations: {
                start: {
                    longitude: trucks[0].start_longitude,
                    latitude: trucks[0].start_latitude,
                },
                dest: {
                    longitude: trucks[0].dest_longitude,
                    latitude: trucks[0].dest_latitude,
                },
            }
        }
    }

    async createMovement(movement: MovementModel) {
        await Repositories.truck.insert(Assemblers.truck.collectionToEntity(movement.trucks))

        const firemen: FiremanEntity[] = await Promise.all(movement.firemen.map(async f => ({
            ...Assemblers.fireman.toEntity(f),
            truck: await Repositories.truck.getByBusiness(f.fireTruckId, f.resourceId)
        })))

        await Promise.all([
            ...movement.trucks.map(async value => Repositories.truckLocation.insert({
                truck: await Repositories.truck.getByBusiness(value.id, value.resourceId),
                current_longitude:
                value.start.longitude,
                current_latitude:
                value.start.longitude, speed: 0
            })),
            await Repositories.fireman.insert(firemen)
        ])
    }


    async stopMovement(movement: MovementModel) {
        await Repositories.truck.update({id_resource: movement.trucks[0].resourceId}, {travelState: TravelState.DONE})
    }

    async back(resourceId: number) {
        let movement = await this.getMovement(resourceId);
        await this.stopMovement(movement)

        await this.createMovement({
            ...movement,
            locations: {
                dest: movement.locations.start,
                start: movement.locations.dest,
            }
        })

    }
}
