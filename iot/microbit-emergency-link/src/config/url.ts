import {env} from "process"
export const emergencyUrl = env.EMERGENCY_URL ?? "192.168.0.40:8084"
