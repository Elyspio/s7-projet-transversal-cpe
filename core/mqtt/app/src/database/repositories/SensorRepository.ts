import {EntityRepository,  Repository} from "typeorm";
import {SensorEntity} from "../entities/SensorEntity";
import {SensorTopicResponse} from "../../config/mqtt";



@EntityRepository(SensorEntity)
export class SensorRepository extends Repository<SensorEntity> {
    public getAll(): Promise<SensorEntity[]> {
        return super.find()
    }

    async add(data: SensorTopicResponse["data"]): Promise<SensorEntity>  {
        const entity = super.create({
            ...data,
            sensorId: data.id,
            id: undefined,
            date: new Date(),
            fires: []
        });
        return await this.getBySensorId(data.id) ?? await super.save(entity)
    }

    async getBySensorId(id: number): Promise<SensorEntity> {
        return (await super.find({where: {sensorId: id}}))[0];
    }


}
