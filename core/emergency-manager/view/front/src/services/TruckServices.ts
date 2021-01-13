import {Apis} from "../apis/Apis";
import {setFires} from "../store/action/Map";
import {store} from "../store/store";

export class TruckServices {
    async watch() {
        console.log("I'm searching for trucks on simulator at " + new Date());
        const trucks = (await Apis.truckBackend.fireTruckLocations()).data
        // @ts-ignore
        await store.dispatch(setFires(trucks));


        setTimeout(this.watch, 1000)
    }
}
