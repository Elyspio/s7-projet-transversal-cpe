import {BaseAssembler} from "./json";
import {LocationModel, TruckModel} from "../../controllers/resources/models";
import {TravelDirection, TravelState, TruckEntity} from "../../database/entities/TruckEntity";

export class TruckAssembler extends BaseAssembler<TruckModel, TruckEntity> {
    toEntity(obj: TruckModel, [resourceId, start, dest, travelDirection]: [number, LocationModel, LocationModel, TravelDirection]): TruckEntity {
        const entity = new TruckEntity();
        entity.travelState = TravelState.MOVING;
        entity.id_truck = obj.id;
        entity.id_resource = resourceId;
        entity.start_longitude = start.longitude
        entity.start_latitude = start.latitude
        entity.dest_longitude = dest.longitude
        entity.dest_latitude = dest.latitude
        entity.speed = obj.speed;
        entity.travelDirection = travelDirection;
        return entity;
    }

    toModel(entity: TruckEntity): TruckModel {
        const a = new TruckModel();
        a.id = entity.id_truck
        a.speed = entity.speed
        return a;
    }

}
