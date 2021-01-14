import {FiresApi, FireTruckApi} from "./backend";
import {ResourceApi} from "./truck";
import {endpoints} from "../config/web";

const getEnv = (name: string, fallback: string) => {
    return process.env[name] ?? fallback;
}


export const Apis = {
    backend: new FiresApi({basePath: endpoints.emergency}),
    truck: new ResourceApi({basePath: endpoints.truck})
}
