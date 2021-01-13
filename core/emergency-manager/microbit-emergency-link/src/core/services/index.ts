import {Serial} from "../../shared/uart/Serial";
import {init} from "./fireService";
import {MqttService} from "./mqttService";

export const Services = {
    serial: new Serial(),
    fire: init,
    mqtt: new MqttService()
}
