import {CollectionOf, Property} from "@tsed/schema";
import {QueryDeepPartialEntity} from "typeorm/query-builder/QueryPartialEntity";

export class LocationModel {
    @Property(Number)
    longitude: number
    @Property(Number)
    latitude: number
}


export class TruckModel {

    @Property(LocationModel)
    start: LocationModel

    @Property(Number)
    id: number;

    @Property(Number)
    speed: number
}

export class FiremanModel {
    @Property(Number)
    id: number;

    @Property(Number)
    fireTruckId: number;
}


export class MovementModel {
    @CollectionOf(TruckModel)
    trucks: TruckModel[]

    @CollectionOf(FiremanModel)
    firemen: FiremanModel[]

    @Property(LocationModel)
    dest: LocationModel

    @Property(Number)
    resourceId: number
}







export type  QueryDeepPartialEntityWithId<T> = QueryDeepPartialEntity<T> & {id: number}
