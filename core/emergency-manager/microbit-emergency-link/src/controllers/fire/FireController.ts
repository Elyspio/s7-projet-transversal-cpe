import {Controller} from "@tsed/common";
import {Description, Name} from "@tsed/schema";
import {Services} from "../../core/services";

@Controller("/fires")
@Description("Fire controller for the microbit-emergency")
@Name("Fire")
export class FireController {

}


Services.serial.on("serial-input", obj => {
    console.log("data from serial", obj);
})