import {BodyParams, Controller, Get, Post, UseBefore} from "@tsed/common";
import {Description, Name, Returns} from "@tsed/schema";
import {RequireDevelopment} from "../../middleware/common/util";
import {PostFireModel} from "./models";
import {Services} from "../../core/services";

@Controller("/fires")
@Description("Fire controller for the microbit-simulator")
@Name("Fire")
export class FireController {

    @Post("/")
    @Returns(201, PostFireModel)
    @Description("Envoie d'un 'nouveau' feu vers la passerelle")
    async newFire(@BodyParams(PostFireModel) body) {
        Services.serial.write(body);
        return body;
    }


    @Get("/test")
    @UseBefore(RequireDevelopment)
    @Returns(403)
    @Returns(200, String).ContentType("text/plain")
    async getAdmin() {
        return "Test only content"
    }
}