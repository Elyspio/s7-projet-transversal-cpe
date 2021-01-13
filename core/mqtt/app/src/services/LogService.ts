import {Repositories} from "../database/repositories";
import {FireTopicResponse, SensorTopicResponse} from "../config/mqtt";

export class LogService {

    async addFireEntry(data: FireTopicResponse["data"]) {
        const sensor = await Repositories.sensor.getBySensorId(data.sensorId);
        const type = await Repositories.fireType.getByTypeId(data.fireTypeId);
        await Repositories.fire.add({intensity: data.intensity, fireId: data.fireId}, sensor, type)
    }


    async addSensor(sensor: SensorTopicResponse["data"]) {
        await Repositories.sensor.add(sensor);
    }

}
