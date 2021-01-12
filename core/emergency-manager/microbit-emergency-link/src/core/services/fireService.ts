import {Services} from "./index";
import {Apis} from "../apis";



export function init() {
    Services.serial.on("serial-input", async obj => {
        console.log("data from serial", obj);
        await Apis.emergencyManager.fire.newFire({
            fireTypeId: obj.fireTypeId,
            intensity: obj.intensity,
            sensorId: obj.sensorId
        })
    })

}

