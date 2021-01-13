import {EntityRepository,  Repository} from "typeorm";
import {SensorEntity} from "../entities/SensorEntity";
import {FireEntity} from "../entities/FireEntity";
import {FireTypeEntity} from "../entities/FireTypeEntity";



@EntityRepository(FireEntity)
export class FireRepository extends Repository<FireEntity> {

    async add(data: {fireId: number, intensity: number}, sensor: SensorEntity, type: FireTypeEntity) {
        const entity = this.create({
            ...data,
            date: new Date(),
            sensor,
            type
        });
        return await super.save(entity)
    }
}
