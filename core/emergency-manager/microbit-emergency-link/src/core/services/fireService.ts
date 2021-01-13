import {Services} from "./index";
import {Apis} from "../apis";
import {FireTopicResponse} from "../../../../../mqtt/app/src/config/mqtt";
import {$log} from "@tsed/common";


export function init() {
    Services.serial.on("serial-input", async obj => {

        $log.info("New data from serial", obj);
        let body = {
            fireTypeId: obj.fireTypeId,
            intensity: obj.intensity,
            sensorId: obj.sensorId
        };

        try {
            const {data: fireId} = await Apis.emergencyManager.fire.newFire(body)
            const mqttData: FireTopicResponse["data"] = {
                ...body,
                fireId
            }

            const mqtt = await Services.mqtt.init();
            await mqtt.emit<"fire">("fire", {action: "add", data: mqttData})
        } catch (e) {
            $log.error("Error with axios", e)
        }


    })


}

