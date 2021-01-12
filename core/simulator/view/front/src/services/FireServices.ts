import {Apis} from "../apis/Apis";
import {setFires} from "../store/action/Map";
import {store} from "../store/store";

export class FireServices {
    async watch() {
        console.log("I'm searching for fires on simulator at " + new Date());
        const fires = (await Apis.backend.fires()).data
        // @ts-ignore
        await store.dispatch(setFires(fires));


        setTimeout(this.watch, 1000)
    }
}
