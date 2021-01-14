import {reducer as mapReducer,} from "./Map";
import {State as MapState} from "../interface/Map";

export interface StoreState {
    map: MapState
}

export default {
    map: mapReducer
}
