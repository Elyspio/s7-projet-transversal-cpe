# CPE S7 - Project



## Microbit

### Installation 

Run `npm install` in folders [microbit-emergency-link](./iot/microbit-emergency-link), [microbit-simulator-link](./iot/microbit-simulator-link), [microbit-shared-link](./iot/microbit-shared-link)


We use library [serialport](https://link) (You need VS 2019 C++ development tools to compile this module) to access to read/write to usb devices


### Development

We reuse code between the modules [microbit-emergency-link](./iot/microbit-emergency-link) and [microbit-emergency-link](./microbit-simulator-link) the code is stored in [microbit-shared-link](microbit-shared-link)

To deploy shared code to module, run `npm run start` in [microbit-shared-link](microbit-shared-link) folder

-----

## Docker 

Access to uart from container:  `docker run -t -i --device=/dev/ttyUSB0 ubuntu bash`

https://docs.microsoft.com/en-us/virtualization/windowscontainers/deploy-containers/hardware-devices-in-containers

[Compile C++ module](https://stackoverflow.com/questions/44371864/using-docker-with-nodejs-with-node-gyp-dependencies)

----

## Config Prod

###Apps

| Entity             | Database port | Web server port | Swagger port |
| ------------------ | ------------- | --------------- | ------------ |
| Simulator          | 5433          | 8083            | 8093         |
| Emergency Manager  | 5434          | 8084            | 8094         |
| Truck Simulator    | 5435          | 8085            | 8095         |
| Microbit Simulator | -             | 8086            | 8086         |
| Microbit Emergency | -             | 8087            | 8087         |
| MQTT               | 5438          | 8088 - 1883     |              |
| Simulator View     | -             | 6003            | -            |
| Emergency View     | -             | 6004            | -            |