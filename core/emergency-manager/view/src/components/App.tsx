import React from 'react';
import './App.scss'
import CustomMap from "./map/Map";
import {Paper} from "@material-ui/core";


export default function App() {
    return (
        <Paper className="App">
            <CustomMap/>
        </Paper>
    );
}

