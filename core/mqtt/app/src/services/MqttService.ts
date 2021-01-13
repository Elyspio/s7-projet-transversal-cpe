import {connect, MqttClient} from "mqtt";
import {mqttHost, topics, TopicsTypes} from "../config/mqtt";

export class MqttService {

    private client: MqttClient

    async init() {
        this.client = connect(mqttHost)
        return new Promise<void>(resolve => {
            this.client.on('connect', function () {
                console.log("connect")
                resolve()
            })
        })

    }


    on<T extends keyof typeof topics>(topic: T, func: (val: TopicsTypes[T]) => void) {
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
