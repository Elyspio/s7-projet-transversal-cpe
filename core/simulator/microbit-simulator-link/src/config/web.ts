import * as path from "path";
import {Configuration} from "@tsed/di";

export const getEnv = (env: string, fallback) => {
    return process.env[env] ?? fallback;
}

const rootDir = path.resolve(__dirname, "..")

export const webConfig: Partial<Configuration> = {
    rootDir,
    httpPort: getEnv("SERVER_HTTP_PORT", 8086),
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
