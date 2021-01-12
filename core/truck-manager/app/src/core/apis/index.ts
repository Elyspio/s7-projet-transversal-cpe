import {ResourcesApi} from "./emergency";
import {emergencyHost} from "../../config/emergency";
import * as FormData from "form-data"; // a nodejs module.

(global as any).FormData = FormData; // hack for nodejs;

export const Apis = {
    emergency: {
        resource: new ResourcesApi({basePath: emergencyHost})
    }
}
