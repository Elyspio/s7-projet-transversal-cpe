import {LatLngLiteral} from "leaflet";
import {FireElement} from "../../../../back/src/interfaces/FireElement";
import {TruckElement} from "../../../../back/src/interfaces/TruckElement";

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


