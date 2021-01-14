import {Apis} from "../apis/Apis";
import {setFires} from "../store/action/Map";
import {store} from "../store/store";


export class FireServices {

    private timer?: NodeJS.Timeout

    watch() {
        let action = async () => {
            console.log("I'm searching for fires on simulator at " + new Date());
            const fires = (await Apis.backend.fires()).data
            // @ts-ignore
            await store.dispatch(setFires(fires));
        };
        action()
        this.timer = setInterval(action, 15000)
    }


    stop() {
        if(this.timer) {
            clearInterval(this.timer)
        }
    }
}
