import {BaseAssembler} from "./json";
import {LocationsModel, TruckModel} from "../../controllers/resources/models";
import {TruckEntity} from "../../database/entities/TruckEntity";

export class TruckAssembler extends BaseAssembler<TruckModel, TruckEntity> {
    toEntity(obj: TruckModel, [resourceId, locations]: [number, LocationsModel]): TruckEntity {
        const entity = new TruckEntity();
        entity.travelState = obj.travelState;
        entity.id_truck = obj.id;
        entity.id_resource = resourceId;
        entity.start_longitude = locations.start.longitude
        entity.start_latitude = locations.start.latitude
        entity.dest_longitude = locations.dest.longitude
        entity.dest_latitude = locations.dest.latitude
        entity.speed = obj.speed;
        return entity;
    }




    toModel(entity: TruckEntity): TruckModel {
        const a = new TruckModel();
        a.id = entity.id_truck
        a.speed = entity.speed
        a.travelState = entity.travelState
        return a;

    }

}
