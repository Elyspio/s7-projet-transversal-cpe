import {EntityRepository, Repository} from "typeorm";
import {FireTypeEntity} from "../entities/FireTypeEntity";
import {FireType} from "../../../../../truck-manager/app/src/core/apis/emergency/models";
import {SensorEntity} from "../entities/SensorEntity";
import {SensorTopicResponse} from "../../config/mqtt";


@EntityRepository(FireTypeEntity)
export class FireTypeRepository extends Repository<FireTypeEntity> {


    async add(data: SensorTopicResponse["data"]): Promise<FireTypeEntity>  {
        const entity = super.create({
            ...data,
            fireTypeId: data.id,
            id: undefined,
            date: new Date(),
            fires: []
        });
        return await this.getByTypeId(data.id) ?? await super.save(entity)
    }

    async getByTypeId(id: number): Promise<FireTypeEntity> {
        return (await super.find({where: {sensorId: id}}))[0];
    }

}
