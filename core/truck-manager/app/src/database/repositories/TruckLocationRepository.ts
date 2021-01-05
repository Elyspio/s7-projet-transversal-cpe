import {EntityRepository, Repository} from "typeorm";
import {TruckLocationEntity} from "../entities/TruckLocationEntity";

@EntityRepository(TruckLocationEntity)
export class TruckLocationRepository extends Repository<TruckLocationEntity> {

    /**
     * @returns a list of trucks that are moving or operating
     */
    async getActives(): Promise<TruckLocationEntity[]> {
        const actives = (await super.find()).filter(tl => tl.truck.isActive);
        const tmp: TruckLocationEntity[] = [];
        actives.sort((a, b) => (b.date.getMilliseconds() - a.date.getMilliseconds()))

        actives.forEach(value => {
            if (!tmp.find(tl => tl.truck.id_resource === value.truck.id_resource)) {
                tmp.push(value)
            }
        })

        return actives
    }

}
