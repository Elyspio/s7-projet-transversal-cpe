import {getEnv} from "./web";

export const apiEndpoints = {
    emergencyManager: getEnv("EMERGENCY_MANAGER_HOST", "http://localhost:8084")
}
