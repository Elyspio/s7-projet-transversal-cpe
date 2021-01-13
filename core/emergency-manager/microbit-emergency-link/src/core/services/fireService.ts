import {Services} from "./index";
import {Apis} from "../apis";
import {FireTopicResponse} from "../../../../../mqtt/app/src/config/mqtt";


export function init() {
    Services.serial.on("serial-input", async obj => {
        console.log("data from serial", obj);
        let body = {
            fireTypeId: obj.fireTypeId,
            intensity: obj.intensity,
            sensorId: obj.sensorId
        };
        const {data: fireId} = await Apis.emergencyManager.fire.newFire(body)

        const mqttData: FireTopicResponse["data"] = {
            ...body,
            fireId
        }
        await Services.mqtt.emit<"fire">("fire", {action: "add", data: mqttData})
    })



}

