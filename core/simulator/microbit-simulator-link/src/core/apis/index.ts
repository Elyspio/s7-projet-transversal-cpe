import {FireApi} from "./cheat";
import {getEnv} from "../../config/web";

export const Apis = {
    cheat: new FireApi({basePath: getEnv("EMERGENCY_HOST", "http://localhost:8087")})
}
