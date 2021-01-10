import {ResourcesApi} from "./emergency";
import {emergencyHost} from "../../config/emergency";

export const Apis = {
    emergency: {
        resource: new ResourcesApi({basePath: emergencyHost})
    }
}
