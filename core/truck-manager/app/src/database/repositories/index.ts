import {TruckRepository} from "./TruckRepository";
import {FiremanRepository} from "./FiremanRepository";
import {TruckLocationRepository} from "./TruckLocationRepository";

type Repositories = {
    truck: TruckRepository,
    fireman: FiremanRepository,
    truckLocation: TruckLocationRepository,
}

export const Repositories: Repositories = {
    fireman: undefined, truck: undefined, truckLocation: undefined
}
