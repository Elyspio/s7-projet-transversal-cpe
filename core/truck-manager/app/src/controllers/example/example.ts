import {Controller, Get, Use, UseAuth, UseBefore} from "@tsed/common";
import {Returns} from "@tsed/schema";
import {RequireDevelopment} from "../../middleware/common/util";

@Controller("/example")
export class Example {

    @Get("/")
    @Returns(200, String).ContentType("text/plain")
    async get() {
        return "Content that does not require authentication"
    }


    @Get("/test")
    @UseBefore(RequireDevelopment)
    @Returns(403)
    @Returns(200, String).ContentType("text/plain")
    async getAdmin() {
        return "Test only content"
    }
}
