import {SensorRepository} from "./SensorRepository";
import {FireRepository} from "./FireRepository";
import {FireTypeRepository} from "./FireTypeRepository";

type Repositories = {
    sensor: SensorRepository,
    fire: FireRepository,
    fireType: FireTypeRepository
}

export const Repositories: Repositories = {
    sensor: undefined,
    fire: undefined,
    fireType: undefined
}
