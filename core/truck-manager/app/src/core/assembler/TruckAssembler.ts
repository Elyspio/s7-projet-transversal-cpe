import {BaseAssembler} from "./json";
import {TruckModel} from "../../controllers/resources/models";
import {TruckEntity} from "../../database/entities/TruckEntity";

export class TruckAssembler extends BaseAssembler<TruckModel, TruckEntity> {
    toEntity(obj: TruckModel): TruckEntity {
        const entity = new TruckEntity();
        entity.travelState = obj.travelState;
        entity.id_truck = obj.id;
        entity.id_resource = obj.resourceId;
        entity.start_longitude = obj.start.longitude
        entity.start_latitude = obj.start.latitude
        entity.dest_longitude = obj.dest.longitude
        entity.dest_latitude = obj.dest.latitude
        entity.speed = obj.speed;
        entity.current_longitude = obj.current.longitude
        entity.current_latitude = obj.current.latitude
        // entity.firemen = [];
        // entity.locations = []

        return entity;
    }


    toModel(entity: TruckEntity): TruckModel {
        const a = new TruckModel();
        a.resourceId = entity.id_resource;
        a.current = {
            latitude: entity.current_latitude,
            longitude: entity.current_longitude,
        }
        a.start = {
            latitude: entity.start_latitude,
            longitude: entity.start_longitude,
        }

        a.dest = {
            latitude: entity.dest_latitude,
            longitude: entity.dest_longitude,
        }
        a.id = entity.id_truck
        a.speed = entity.speed
        a.travelState = entity.travelState
        return a;

    }

}
