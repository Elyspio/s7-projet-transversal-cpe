import {AbstractRepository, EntityRepository} from "typeorm";
import {TruckEntity} from "../entities/TruckEntity";

@EntityRepository()
export class TruckRepository extends AbstractRepository<TruckEntity> {

}