import {LatLngLiteral} from "leaflet";
import {FireElement} from "../../interfaces/FireElement";
import {TruckElement} from "../../interfaces/TruckElement";

export interface Marker {
    pos: LatLngLiteral,
    type: MarkerType
    data: FireElement | TruckElement
}

export enum MarkerType {

    fire,
    truck
}

export  type BoundingBox = {
    _southWest: LatLngLiteral, _northEast: LatLngLiteral
};

export interface State {
    zoom: number,
    fires: FireElement[],
    trucks:TruckElement[]
}


