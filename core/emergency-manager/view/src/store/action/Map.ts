import {createAction as _createAction} from '@reduxjs/toolkit'
import {LatLngLiteral} from "leaflet";
import {FireElement} from "../../interfaces/FireElement";
import {BoundingBox, Marker} from "../interface/Map";
import {TruckElement} from "../../interfaces/TruckElement";


const createAction = <P>(name: string) => _createAction<P>(`map/${name}`);

export const setFires = createAction<FireElement[]>("setFires")
export const setTrucks = createAction<TruckElement[]>("setTrucks")
export const setBoundingBox = createAction<BoundingBox>("setBoundingBox")
//

export const addCustomMarker = createAction<Marker[]>("addCustomMarker")
export const removeCustomMarker = createAction<Marker>("removeCustomMarker")
export const setStartMarker = createAction<LatLngLiteral>("setStartMarker");
export const setDestMarker = createAction<LatLngLiteral>("setDestMarker");
export const changeMarkerPos = createAction<ChangeMarkerPosFn>("changeMarkerPos");


export type ChangeMarkerPosFn = { newPos: LatLngLiteral, oldPos: LatLngLiteral };


