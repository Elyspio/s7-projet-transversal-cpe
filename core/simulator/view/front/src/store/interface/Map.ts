import {LatLngLiteral} from "leaflet";
import {FireElement} from "../../../../back/src/interfaces/FireElement";

export interface Marker {
    pos: LatLngLiteral,
    type: MarkerType
    data?: FireElement
}

export enum MarkerType {

    fire
}

export  type BoundingBox = {
    _southWest: LatLngLiteral, _northEast: LatLngLiteral
};

export interface State {
    zoom: number,
    fires: FireElement[]
}


