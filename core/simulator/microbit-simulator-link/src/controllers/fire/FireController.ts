import {BodyParams, Controller, Get, Post, UseBefore} from "@tsed/common";
import {Description, Name, Returns, Status} from "@tsed/schema";
import {RequireDevelopment} from "../../middleware/common/util";
import {PostFireModel} from "./models";
import {Services} from "../../core/services";

@Controller("/fires")
@Description("Fire controller for the microbit-simulator")
@Name("Fire")
export class FireController {

    @Post("/")
    @Returns(201, String)
    @Description("Send a new or updated fire to the gateway")
    async newFire(@BodyParams(PostFireModel) body) {
        Services.serial.write(body);
    }

}

