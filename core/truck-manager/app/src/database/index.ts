import {$log} from "@tsed/common";
import {Connection, createConnection} from "typeorm";
import {Repositories} from "./repositories";
import {TruckRepository} from "./repositories/TruckRepository";
import {FiremanRepository} from "./repositories/FiremanRepository";
import {TruckLocationRepository} from "./repositories/TruckLocationRepository";
import {databaseOptions} from "../config/database";

export class Database {

    private static instance: Connection;

    public static async get() {
        if (!Database.instance) {
            $log.debug("Start database connection");
            Database.instance = await createConnection(databaseOptions)
            $log.debug("Database connection done");
        }
        return Database.instance
    }

    public static async init() {
        const con = await Database.get();
        Repositories.truck = con.getCustomRepository(TruckRepository)
        Repositories.truckLocation = con.getCustomRepository(TruckLocationRepository)
        Repositories.fireman = con.getCustomRepository(FiremanRepository)
    }


}



