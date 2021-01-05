import * as path from "path";
import {Configuration} from "@tsed/di";
import {getEnv} from "./database";


const rootDir = path.resolve(__dirname, "..")

export const webConfig: Partial<Configuration> = {
    rootDir,
    httpPort: getEnv("SERVER_HTTP_PORT", 8085),
    httpsPort: false, // CHANGE
    mount: {
        "/": [
            `${rootDir}/controllers/**/*`
        ]
    },
    exclude: [
        "**/*.spec.ts"
    ],
    swagger: [{
        path: "/swagger",
    }]

}
