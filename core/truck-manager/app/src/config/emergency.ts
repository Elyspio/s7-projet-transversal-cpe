import {getEnv} from "./database";

export const emergencyHost = getEnv("EMERGENCY_MANAGER_HOST", "http://localhost:8084")
