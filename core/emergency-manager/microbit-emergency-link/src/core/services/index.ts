import {Serial} from "../../shared/uart/Serial";
import {init} from "./fireService";

export const Services = {
    serial: new Serial(),
    fire: init
}
