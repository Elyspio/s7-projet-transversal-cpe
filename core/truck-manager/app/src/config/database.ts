import {ConnectionOptions} from "typeorm";
import * as path from "path";


const getEnv = (env: string, fallback) => {
    return process.env[env] ?? fallback;
}


export const databaseOptions: ConnectionOptions =  {
    "type":  "postgres",
    "host": getEnv("DATABASE_HOST", "localhost"),
    "port": getEnv("DATABASE_PORT", 5435),
    "username": getEnv("DATABASE_USER", "postgres"),
    "password": getEnv("DATABASE_PASSWORD", "example"),
    "database": getEnv("DATABASE_BASE", "postgres"),
    "synchronize": true,
    "logging": true,
    entities: [path.resolve(__dirname, "..", "database", "entities", "*")]

}
