import {createReducer} from "@reduxjs/toolkit";

import {init as initMap} from "../../constants/map"

import {setFires} from "../action/Map";
import {State} from "../interface/Map";


const initialState: State = {
    zoom: initMap.zoom,
    fires: [],
    trucks:[]
};

export const reducer = createReducer<State>(initialState, builder => {

    builder.addCase(setFires, (state, action) => {
        state.fires = action.payload;

    })


});





