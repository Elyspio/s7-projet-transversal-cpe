import {$log} from "@tsed/common";
import {Connection, createConnection} from "typeorm";
import {Repositories} from "./repositories";
import {TruckRepository} from "./repositories/TruckRepository";
import {FiremanRepository} from "./repositories/FiremanRepository";
import {TruckLocationRepository} from "./repositories/TruckLocationRepository";
import {databaseOptions} from "../config/database";

export class Database {

    private static instance: Connection;

    public static async init() {
        const con = await Database.get();
        Repositories.truck = con.getCustomRepository(TruckRepository)
        Repositories.truckLocation = con.getCustomRepository(TruckLocationRepository)
        Repositories.fireman = con.getCustomRepository(FiremanRepository)
    }

    private static async connect() {

        try {
            $log.debug("Trying to connect to database");
            Database.instance = await createConnection(databaseOptions)
        } catch (e) {
            $log.debug("Could not connect to database, try again in 5 seconds");
            $log.debug(e);
            return new Promise((resolve) => {
                setTimeout(() => resolve(this.connect()), 5000)
            })
        }
    }

    private static async get() {
        if (!Database.instance) {
            $log.debug("Start database connection");
            await this.connect();
            $log.debug("Database connection done");
        }
        return Database.instance
    }


}



