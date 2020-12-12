import {EventEmitter} from "events";
import * as SerialPort from "serialport";
import {env}  from "process"
import {Convert} from "./Convert";
import Readline = SerialPort.parsers.Readline;

export declare interface Uart {
    on(event: "serial-input", listener: (obj: object) => void): this
    emit(event: "serial-input", data: object)
}

export class Uart extends EventEmitter {
    private serial: SerialPort;
    constructor() {
        super();
        this.serial = new SerialPort(env.SERIAL_PORT ?? "COM3")

        const lineStream = this.serial.pipe(new Readline({delimiter: "\r\n"}))

        lineStream.on("data", (data: Buffer) => {
            console.log("lineStream data", data.toString());

            try {
                this.emit("serial-input", Convert.csvToJs(data.toString("utf8")))
            }
            catch (e) {
                console.error(e);
            }
        })

        this.serial.on("data", (data: Buffer) => {
            console.log("data", data.toString());

        })
    }

}

