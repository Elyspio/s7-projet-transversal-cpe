import {getEnv} from "./web";

export const mqttHost = getEnv("MQTT_HOST", "mqtt://localhost:1883")
