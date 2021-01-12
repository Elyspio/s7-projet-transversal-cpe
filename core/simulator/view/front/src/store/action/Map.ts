import {createAction as _createAction} from '@reduxjs/toolkit'
import {LatLngLiteral} from "leaflet";
import {FireElement} from "../../../../back/src/interfaces/FireElement";
import {BoundingBox, Marker} from "../interface/Map";


const createAction = <P>(name: string) => _createAction<P>(`map/${name}`);

export const setFires = createAction<FireElement[]>("setPois")
export const setBoundingBox = createAction<BoundingBox>("setBoundingBox")
//

export const addCustomMarker = createAction<Marker[]>("addCustomMarker")
export const removeCustomMarker = createAction<Marker>("removeCustomMarker")
export const setStartMarker = createAction<LatLngLiteral>("setStartMarker");
export const setDestMarker = createAction<LatLngLiteral>("setDestMarker");
export const changeMarkerPos = createAction<ChangeMarkerPosFn>("changeMarkerPos");


export type ChangeMarkerPosFn = { newPos: LatLngLiteral, oldPos: LatLngLiteral };


