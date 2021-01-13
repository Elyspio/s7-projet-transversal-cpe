import {connect, MqttClient} from "mqtt";
import {mqttHost} from "../../config/mqtt";
import {topics, TopicsTypes} from "../../../../../mqtt/app/src/config/mqtt";
import {Apis} from "../apis";
import {FireType, SensorFromEmergency} from "../apis/types";

export class MqttService {

    private client: MqttClient

    async init() {

        const that = this;

        that.client = connect(mqttHost)

        const sensors = (await Apis.emergencyManager.sensor.getAll()).data as unknown as SensorFromEmergency[]

        const fireTypes = (await Apis.emergencyManager.fireTypes.getAll()).data as unknown as FireType[]

        return new Promise<void>(resolve => {
            that.client.on('connect', () => {
                Promise.all([
                    ...sensors.map(s => that.emit<"sensor">("sensor", {data: s, action: "add"})),
                    ...fireTypes.map(ft => that.emit<"fireType">("fireType", {data: ft, action: "add"}))
                ]).then(() => resolve())
            })
        })
    }

    on(topic: keyof typeof topics, func: (val: TopicsTypes[typeof topic]) => void) {
        const that = this;
        that.client.subscribe(topic, function (err) {
            console.log(topic, err)
            that.client.on("message", (t: any, message: string) => {
                if (t === topic) {
                    func(JSON.parse(message.toString()));
                }
            })
        })
    }

    async emit<T extends keyof typeof topics>(topic: T, value: TopicsTypes[T]) {
        const that = this;
        return new Promise<void>((resolve, reject) => {
            that.client.subscribe(topic, function (err) {
                if (!err) {
                    that.client.publish(topic, JSON.stringify(value), () => resolve())
                } else {
                    reject(err);
                }
            })
        })
    }
}
