import {Services} from "./index";
import {Apis} from "../apis";
import {FireTopicResponse} from "../../../../../mqtt/app/src/config/mqtt";
import {$log} from "@tsed/common";
import {PostFireModel} from "../../controllers/fire/models";


export function init() {
    Services.serial.on("serial-input", async obj => {
        await sendData(obj)
    })


}


export async  function sendData(obj: PostFireModel) {
    try {
        $log.info("New data from serial", obj);

        const {data: fireId} = await Apis.emergencyManager.fire.newFire(obj)
        const mqttData: FireTopicResponse["data"] = {
            ...obj,
            fireId
        }

        const mqtt = await Services.mqtt.init();
        await mqtt.emit<"fire">("fire", {action: "add", data: mqttData})
    } catch (e) {
       // $log.error("Error with axios", e)
    }
}

