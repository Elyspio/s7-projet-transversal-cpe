import {EntityRepository, Repository} from "typeorm";
import {FiremanEntity} from "../entities/FiremanEntity";

@EntityRepository(FiremanEntity)
export class FiremanRepository extends Repository<FiremanEntity> {
    public getAll(): Promise<FiremanEntity[]> {
        return super.find()
    }


}
