import {EntityRepository, getConnection, Repository} from "typeorm";
import {FiremanEntity} from "../entities/FiremanEntity";
import {TruckEntity} from "../entities/TruckEntity";
import {QueryDeepPartialEntity} from "typeorm/query-builder/QueryPartialEntity";

@EntityRepository(FiremanEntity)
export class FiremanRepository extends Repository<FiremanEntity> {
    public getAll(): Promise<FiremanEntity[]> {
        return super.find()
    }

    // @ts-ignore
    public async update(fireman: FiremanEntity) {
        return await getConnection()
            .createQueryBuilder()
            .update(FiremanEntity)
            .set(fireman)
            .where("id = :id", {id: fireman.id})
            .execute();
    }


    public async updateAllByResource(resourceId: FiremanEntity["id"], truck: QueryDeepPartialEntity<FiremanEntity>) {
        return await getConnection()
            .createQueryBuilder()
            .update(FiremanEntity)
            .set(truck)
            .where("id_resource = :id", {id: truck.id_resource})
            .execute();
    }

}
