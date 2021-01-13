import {MqttService} from "./MqttService";
import {LogService} from "./LogService";

export const Services = {
    mqtt: new MqttService(),
    log: new LogService()
}
