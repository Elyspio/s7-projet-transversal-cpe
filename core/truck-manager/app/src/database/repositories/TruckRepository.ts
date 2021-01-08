import {EntityRepository, Repository} from "typeorm";
import {TravelState, TruckEntity} from "../entities/TruckEntity";

@EntityRepository(TruckEntity)
export class TruckRepository extends Repository<TruckEntity> {

    public getAll(): Promise<TruckEntity[]> {
        return super.find()
    }

    public async getByBusiness(id: number, resourceId: number): Promise<TruckEntity> {
        return (await this.find({where: {id_truck: id, id_resource: resourceId}}))[0];
    }



}
