import {LocationModel} from "../../controllers/resources/models";
import {Repositories} from "../../database/repositories";
import {Assemblers} from "../assembler";
import {TruckLocationEntity} from "../../database/entities/TruckLocationEntity";
import {TravelDirection, TravelState} from "../../database/entities/TruckEntity";
import {Apis} from "../apis";
import {$log} from "@tsed/common";

function deltaBetweenLocations(a: LocationModel, b: LocationModel) {
    const R = 6371; // km
    const dLat = toRad(b.latitude - a.latitude);
    const dLon = toRad(b.longitude - a.longitude);

    const x = Math.sin(dLat / 2)
        * Math.sin(dLat / 2)
        + Math.sin(dLon / 2)
        * Math.sin(dLon / 2)
        * Math.cos(toRad(a.latitude))
        * Math.cos(toRad(b.longitude));

    const c = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));


    $log.info("distance", R * c)

    return R * c;
}

function toRad(Value) {
    return Value * Math.PI / 180;
}


export class LocationService {

    public static async move(f: TruckLocationEntity) {
        //todo Améliorer le déplacement
        f.current_latitude = f.truck.dest_latitude
        f.current_longitude = f.truck.dest_longitude
        f.date = new Date();
        await Repositories.truckLocation.insert(f)

        if (f.current_longitude === f.truck.dest_longitude && f.current_latitude === f.truck.dest_latitude) {

            if (f.truck.travelDirection === TravelDirection.BARRACK) {
                try {
                    await Apis.emergency.resource.resourceBack(f.truck.id_resource)

                } catch (e) {
                    console.error(e);
                }
            }

            await Repositories.truck.update({travelState: TravelState.DONE, id: f.truck.id});
        }
    }

    /**
     * Get Trucks near a location
     * @param location
     * @param padding maximum distance between locations (in m)
     */
    public async getNear(location: LocationModel, padding = 1000) {
        let dones = await Repositories.truckLocation.getDones();
        const actives = dones.filter(tl => tl.truck.travelDirection === TravelDirection.FIRE
            && dones.find(tl2 => tl2.truck.id_resource === tl.truck.id_resource && tl2.truck.travelDirection === TravelDirection.BARRACK) === undefined
        )
        console.log("actives.length", actives.length)
        const ids = actives
            .filter(tl => deltaBetweenLocations({latitude: tl.current_latitude, longitude: tl.current_longitude}, location) < padding)
            .map(tl => tl.truck.id_resource)

        return [...new Set(ids)];
    }

    public async getLocations() {
        return (await Repositories.truckLocation.getMoving());
    }



}
