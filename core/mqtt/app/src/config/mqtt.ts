import {getEnv} from "./database";
import {FireResourceNewFire, FireType} from "../../../../emergency-manager/microbit-emergency-link/src/core/apis/emergency-manager/models";

export const mqttHost = getEnv("MQTT_HOST", "mqtt://localhost:1883")

export const topics = {
    fire: "fire",
    sensor: "sensor",
    fireType: "firetype"
} as const

export type FireTopicResponse = MqttArgument & {
    data: FireResourceNewFire & { fireId: number },
}

export type FireTypeTopicResponse = MqttArgument & {
    data: FireType,
}


export type SensorTopicResponse = MqttArgument & {
    data: {
        id: number,
        city: string,
        state: string,
        postalCode: string,
        country: string,
        street: string,
    },
}
export  type MqttArgument = {
    action: "add"
}


export type TopicsTypes = {
    fire: FireTopicResponse
    sensor: SensorTopicResponse
    fireType: FireTypeTopicResponse
}
