import {EventEmitter} from "events";
import * as SerialPort from "serialport";
import {env} from "process"
import Readline = SerialPort.parsers.Readline;

export declare interface Serial {
    on(event: "serial-input", listener: (obj: any) => void): this

    emit(event: "serial-input", data: any)

    write(data: string);

    write(data: object);

}

export const delimeter = "\r\n"
const microbitMaxLength = 64;

export class Serial extends EventEmitter {
    private serial: SerialPort;

    constructor(port: string = env.SERIAL_PORT) {
        super();
        this.serial = new SerialPort(port, {baudRate: 115200})

        const lineStream = this.serial.pipe(new Readline({delimiter: delimeter}))

        lineStream.on("data", (data: Buffer) => {
            try {
                let ret: any
                ret = data.toString("utf8");
                if (ret.length > 0) {
                    try {
                        ret = JSON.parse(ret)
                    } catch (e) {

                    }


                    this.emit("serial-input", ret);
                }


                //                this.emit("serial-input", Convert.csvToJs(data.toString("utf8")))
            } catch (e) {
                console.error(e);
            }
        })

    }

    public write(data: string | object) {
        if (typeof data !== "string") {
            data = JSON.stringify(data);
        }
        const splited = data.match(new RegExp(".{1," + (microbitMaxLength - 1) + "}", "g"))

        console.log(splited);

        splited.forEach((v, i) => {
            setTimeout(() => {
                const toWrite = (i < splited.length - 1 ? String.fromCharCode(14) : String.fromCharCode(15)) + v;
                console.log("writing", toWrite);
                this.serial.write(pad(toWrite + delimeter, microbitMaxLength, String.fromCharCode(0), "right"));
                this.serial.flush(console.log);
            }, i * 500)

        });

    }
}


function pad(str: string, len: number, elem: string, direction: "left" | "right") {
    while (str.length < len) {
        if (direction === "left") str = elem + str;
        if (direction === "right") str += elem;
    }
    return str;
}
