import {LocationService} from "./LocationService";
import {MovingService} from "./MovingService";

export const Services = {
    location: new LocationService(),
    moving: new MovingService()
}
