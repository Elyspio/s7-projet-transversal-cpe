import {EntityRepository, Repository} from "typeorm";
import {TruckLocationEntity} from "../entities/TruckLocationEntity";

@EntityRepository(TruckLocationEntity)
export class TruckLocationRepository extends Repository<TruckLocationEntity> {

    /**
     * @returns a list of trucks that are moving or operating
     */
    async getActives(): Promise<TruckLocationEntity[]> {
        const actives = (await super.find({relations: ["truck", "truck.firemen", "truck.locations"]})).filter(tl => tl.truck.isActive);
        const tmp: TruckLocationEntity[] = [];
        console.log(actives)
        actives.sort((a, b) => (b.date.getTime() - a.date.getTime()))

        actives.forEach(value => {
            if (!tmp.find(tl => tl.truck.id_resource === value.truck.id_resource)) {
                tmp.push(value)
            }
        })

        return tmp
    }



}
