import {BodyParams, Controller, Post,} from "@tsed/common";
import {ContentType, Description, Name, Returns} from "@tsed/schema";
import {PostFireModel} from "./models";
import {Services} from "../../core/services";
import {constants} from "http2";

@Controller("/fires")
@Description("Fire controller for the microbit-simulator")
@Name("Fire")
export class FireController {

    @Post("/")
    @Returns(constants.HTTP_STATUS_NO_CONTENT)
    @Description("Send a new or updated fire to the gateway")
    async newFire(@BodyParams(PostFireModel) body) {
        Services.serial.write(body);
    }

}

