import {MovementModel} from "../../controllers/resources/models";
import {Repositories} from "../../database/repositories";
import {FiremanEntity} from "../../database/entities/FiremanEntity";
import {Assemblers} from "../assembler";
import {TravelState} from "../../database/entities/TruckEntity";
import {TruckLocationEntity} from "../../database/entities/TruckLocationEntity";
import {LocationService} from "./LocationService";


export class MovingService {

    public static async moveTrucks() {
        const fireTrucks: TruckLocationEntity[] = await Repositories.truckLocation.getActives()
        fireTrucks.filter(f => f.truck.travelState === TravelState.MOVING).forEach(f => {
            LocationService.move(f);
        })

    }

    async getMovement(idResource: number): Promise<MovementModel> {
        const trucks = await Repositories.truck.find({where: {id_resource: idResource}});
        const firemen: FiremanEntity[] = trucks.reduce((acc, current) => [...acc, ...current.firemen], [])

        return {
            resourceId: idResource,
            firemen: Assemblers.fireman.collectionToModel(firemen.map(f => ({model: f}))),
            trucks: Assemblers.truck.collectionToModel(trucks.map(t => ({model: t}))),
            dest: {
                longitude: trucks[0].dest_longitude,
                latitude: trucks[0].dest_latitude,
            },
        }
    }

    async createMovement(movement: MovementModel) {
        await Repositories.truck.insert(Assemblers.truck.collectionToEntity(movement.trucks.map(t => ({model: t, args: [movement.resourceId, t.start, movement.dest]}))))

        const firemen: FiremanEntity[] = await Promise.all(movement.firemen.map(async f => ({
            ...Assemblers.fireman.toEntity(f),
            id_resource: movement.resourceId,
            truck: await Repositories.truck.getByBusiness(f.fireTruckId, movement.resourceId)
        })))

        await Promise.all([
            ...movement.trucks.map(async value => Repositories.truckLocation.insert({
                truck: await Repositories.truck.getByBusiness(value.id, movement.resourceId),
                current_longitude: value.start.longitude,
                current_latitude: value.start.latitude,
                speed: 0
            })),
            await Repositories.fireman.insert(firemen)
        ])
    }

    async stopMovement(movement: MovementModel) {
        await Repositories.truck.updateAllByResource(movement.resourceId, {travelState: TravelState.DONE})
    }

    async back(resourceId: number) {
        let movement = await this.getMovement(resourceId);
        await this.stopMovement(movement)

        await this.createMovement({
            ...movement,
            dest: movement.dest,
        })

    }
}
