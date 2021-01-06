import {CollectionOf, Enum, Property} from "@tsed/schema";
import {TravelState} from "../../database/entities/TruckEntity";

export class LocationModel {
    @Property(Number)
    longitude: number
    @Property(Number)
    latitude: number
}


export class TruckModel {
    @Property(Number)
    id: number;

    @Property(Number)
    speed: number

    @Enum(TravelState)
    travelState: TravelState
}

export class FiremanModel {
    @Property(Number)
    id: number;

    @Property(Number)
    fireTruckId: number;
}

export class LocationsModel {
    @Property(LocationModel)
    start: LocationModel
    @Property(LocationModel)
    dest: LocationModel
}

export class MovementModel {
    @Property(LocationsModel)
    locations: LocationsModel

    @CollectionOf(TruckModel)
    trucks: TruckModel[]

    @CollectionOf(FiremanModel)
    firemen: FiremanModel[]

    @Property(Number)
    resourceId: number
}







