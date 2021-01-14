import {EntityRepository, getConnection, Repository} from "typeorm";
import {TravelState, TruckEntity} from "../entities/TruckEntity";
import {$log} from "@tsed/common";
import {QueryDeepPartialEntity} from "typeorm/query-builder/QueryPartialEntity";
import {QueryDeepPartialEntityWithId} from "../../controllers/resources/models";

@EntityRepository(TruckEntity)
export class TruckRepository extends Repository<TruckEntity> {

    public getAll(): Promise<TruckEntity[]> {
        return super.find()
    }

    public async getByBusiness(id: number, resourceId: number): Promise<TruckEntity> {
        let truckEntities = await this.find({where: {id_truck: id, id_resource: resourceId}});
        $log.info({truckEntities})
        return truckEntities[0];
    }


    // @ts-ignore
    public async update(truck: QueryDeepPartialEntityWithId<TruckEntity>) {
        return await getConnection()
            .createQueryBuilder()
            .update(TruckEntity)
            .set(truck)
            .where("id = :id", {id: truck.id})
            .execute();
    }

    public async updateAllByResource(resourceId: TruckEntity["id"], truck: QueryDeepPartialEntity<TruckEntity>) {
        return await getConnection()
            .createQueryBuilder()
            .update(TruckEntity)
            .set(truck)
            .where("id_resource = :id", {id: truck.id_resource})
            .execute();
    }

    async getMoving(): Promise<TruckEntity[]> {
        return super.find({where: {travelState: TravelState.MOVING}});
    }
}
