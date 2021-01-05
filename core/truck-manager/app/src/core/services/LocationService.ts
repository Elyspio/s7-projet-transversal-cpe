import {LocationModel} from "../../controllers/resources/models";
import {Repositories} from "../../database/repositories";
import {Assemblers} from "../assembler";

function deltaBetweenLocations(a: LocationModel, b: LocationModel) {
    const R = 6371; // km
    const dLat = toRad(b.latitude - a.latitude);
    const dLon = toRad(b.longitude - a.latitude);

    const x = Math.sin(dLat / 2)
        * Math.sin(dLat / 2)
        + Math.sin(dLon / 2)
        * Math.sin(dLon / 2)
        * Math.cos(toRad(a.latitude))
        * Math.cos(toRad(b.longitude));

    const c = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
    return R * c;
}

function toRad(Value) {
    return Value * Math.PI / 180;
}


export class LocationService {

    /**
     * Get Trucks near a location
     * @param location
     * @param padding maximum distance between locations (in km)
     */
    public async getNear(location: LocationModel, padding = 1) {
        const actives = await Repositories.truckLocation.getActives()
        const ids = actives
            .filter(tl => deltaBetweenLocations({latitude: tl.current_latitude, longitude: tl.current_longitude}, location) < padding)
            .map(tl => tl.truck.id_resource)

        return [...new Set(ids)];
    }

    public async getLocations() {
        return (await Repositories.truckLocation.getActives()).map(tl => Assemblers.truck.toModel(tl.truck));
    }

}
