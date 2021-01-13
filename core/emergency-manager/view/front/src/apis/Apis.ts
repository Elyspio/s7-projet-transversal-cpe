import {FiresApi,FireTruckApi} from "./backend";

const getEnv = (name: string, fallback: string) => {
    return process.env[name] ?? fallback;
}


export const Apis = {
    backend: new FiresApi({basePath: getEnv("EMERGENCY_HOST", "http://localhost:8084")}),
    truckBackend: new FireTruckApi({basePath:getEnv("EMERGENCY_HOST","http://localhost:8084")})
}
