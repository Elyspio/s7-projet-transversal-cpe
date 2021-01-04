import {Property} from "@tsed/schema";

export class PostFireModel {

    @Property(Number)
    sensorId: number

    @Property(Number)
    intensity: number

    @Property(Number)
    fireTypeId: number


}