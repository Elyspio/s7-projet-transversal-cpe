import {Controller} from "@tsed/common";
import {Description, Name} from "@tsed/schema";
import {Services} from "../../core/services";
import {Apis} from "../../core/apis";

@Controller("/fires")
@Description("Fire controller for the microbit-emergency")
@Name("Fire")
export class FireController {

}


Services.serial.on("serial-input", async obj => {
    console.log("data from serial", obj);
    await Apis.emergencyManager.fire.newFire({
        fireTypeId: obj.fireTypeId,
        intensity: obj.intensity,
        sensorId: obj.sensorId
    })
})
