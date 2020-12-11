import { $log } from "@tsed/common";
import {Connection, createConnection} from "typeorm";

export class Database {

    private static instance: Connection;

    public static async get() {
        if(!Database.instance) {
            $log.debug("Start database connection");
            Database.instance =  await createConnection()
            $log.debug("Database connection done");
        }
        return Database.instance
    }

    public static async init() {
        await Database.get();
    }



}