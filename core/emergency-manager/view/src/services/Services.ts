import {FireServices} from "./FireServices";
import {TruckServices} from "./TruckServices";

export const Services = {
    fire: new FireServices(),
    truck: new TruckServices()
}
