import {Apis} from "../apis/Apis";
import {setFires, setTrucks} from "../store/action/Map";
import {store} from "../store/store";
import {TruckLocationEntity} from "../apis/truck/models";

export class TruckServices {
    async watch() {
        console.log("I'm searching for trucks on simulator at " + new Date());
        const trucks = (await Apis.truck.resourceLocation()).data
        store.dispatch(setTrucks(trucks.map((t: TruckLocationEntity) => ({
            intensity: t.id,
            latitude: t.current_latitude,
            longitude: t.current_longitude
        }))));
        setTimeout(this.watch, 1000)
    }
}
