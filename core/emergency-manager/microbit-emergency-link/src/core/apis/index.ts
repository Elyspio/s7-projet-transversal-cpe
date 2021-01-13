import * as FormData from "form-data"; // a nodejs module.
import {FiresApi, FireTypesApi, SensorsApi} from "./emergency-manager";
import {apiEndpoints} from "../../config/api";

(global as any).FormData = FormData; // hack for nodejs;


export const Apis = {
    emergencyManager: {
        fire: new FiresApi({basePath: apiEndpoints.emergencyManager}),
        sensor: new SensorsApi({basePath: apiEndpoints.emergencyManager}),
        fireTypes: new FireTypesApi({basePath: apiEndpoints.emergencyManager})
    }
}
