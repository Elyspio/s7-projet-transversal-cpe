import {BodyParams, Controller, Get, PathParams, Post, QueryParams} from "@tsed/common";
import {Description, Name, Returns} from "@tsed/schema";
import {LocationModel, MovementModel, TruckModel} from "./models";
import {Services} from "../../core/services";

@Name("Resource")
@Controller("/resources")
export class ResourceController {

    @Post("/send")
    @Returns(204)
    async send(@BodyParams(MovementModel) params: MovementModel) {

        await Services.moving.createMovement(params)

        return params.firemen;
    }

    @Post("/:id/back")
    @Returns(204, null)
    async back(@PathParams("id") resourceId: number) {
        await Services.moving.back(resourceId)
    }


    @Get("/")
    @Description("Returns a list of resource ids near a location")
    @Returns(200, Array).Of(Number)
    async near(@QueryParams() loc: LocationModel): Promise<number[]> {
        return Services.location.getNear(loc)
    }

    @Get("/location")
    @Description("Returns a list of trucks that are in operation")
    @Returns(200, Array).Of(TruckModel)
    async location(): Promise<TruckModel[]> {
        return Services.location.getLocations()
    }


}
