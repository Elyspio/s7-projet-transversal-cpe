import {BodyParams, Controller, Post,} from "@tsed/common";
import {Description, Name, Returns} from "@tsed/schema";
import {PostFireModel} from "./models";
import {constants} from "http2";
import {sendData} from "../../core/services/fireService";

@Controller("/fires")
@Description("Fire controller for the emergency")
@Name("Fire")
export class FireController {

    @Post("/")
    @Returns(constants.HTTP_STATUS_NO_CONTENT)
    @Description("Send a new or updated fire to the gateway")
    async newFire(@BodyParams(PostFireModel) body) {
        await sendData(body)
    }

}

