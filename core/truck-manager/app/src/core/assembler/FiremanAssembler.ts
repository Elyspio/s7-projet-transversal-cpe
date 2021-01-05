import {BaseAssembler} from "./json";
import {FiremanModel} from "../../controllers/resources/models";
import {FiremanEntity} from "../../database/entities/FiremanEntity";
import {Repositories} from "../../database/repositories";

export class FiremanAssembler extends BaseAssembler<FiremanModel, FiremanEntity> {
    toEntity(obj: FiremanModel): FiremanEntity {
        return {
            id_fireman: obj.id,
            id: undefined,
            truck: undefined,
            id_resource: obj.resourceId
        }
    }


    toModel(entity: FiremanEntity): FiremanModel {
        return {
            resourceId: entity.id_resource,
            id: entity.id_fireman,
            fireTruckId: entity.truck.id_truck
        };
    }

}
