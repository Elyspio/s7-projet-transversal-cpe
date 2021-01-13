


export const getEnv = (env: string, fallback: string) => {
    return process.env[env] ?? fallback;
}


export const endpoints = {
    emergency: getEnv("EMERGENCY_HOST", "http://localhost:8084"),
    truck: getEnv("TRUCK_HOST", "http://localhost:8085"),
}
