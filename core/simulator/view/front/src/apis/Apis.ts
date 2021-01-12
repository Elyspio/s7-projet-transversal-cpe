import {HelloApi} from "./backend";

const getEnv = (name: string, fallback: string) => {
    return process.env[name] ?? fallback;
}


export const Apis = {
    backend: new HelloApi({basePath: getEnv("SIMULATOR_HOST", "http://localhost:8083")})
}
