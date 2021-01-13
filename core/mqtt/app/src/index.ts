import "reflect-metadata";
import {Database} from "./database";
import {Services} from "./services";
import {FireTopicResponse, SensorTopicResponse, topics} from "./config/mqtt";


async function main() {
    await Database.init()
    await Services.mqtt.init();

    Services.mqtt.on(topics.fire, async ({action, data}) => {

        if (action === "add") {
            await Services.log.addFireEntry(data)
        }
    })

    Services.mqtt.on(topics.sensor, async ({data, action}) => {

        if (action === "add") {
            await Services.log.addSensor(data)
        }
    })
}

main();
