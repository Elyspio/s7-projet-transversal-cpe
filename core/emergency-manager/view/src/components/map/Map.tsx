import React, {Component} from 'react';
import * as L from 'leaflet'
import {LatLngExpression} from 'leaflet'
import 'leaflet.markercluster';
import 'leaflet.markercluster/dist/MarkerCluster.css';
import 'leaflet.markercluster/dist/MarkerCluster.Default.css';
import {StoreState} from "../../store/reducer";
import {connect, ConnectedProps} from "react-redux";
import './Map.scss'
import {Marker, MarkerType} from "../../store/interface/Map";
import {init as defaultPosition} from "../../constants/map"
import {createMarker} from "./MarkerFactory"
import {Services} from "../../services/Services";
import {FireElement} from "../../interfaces/FireElement";

export type ContextMenuData = {
    screenPos: {
        x: number,
        y: number
    };
    geoPos: {
        lat: number,
        lng: number
    };
}


const mapStateToProps = (store: StoreState) => {
    return {
        fires: store.map.fires,
        trucks: store.map.trucks
    }
}

const mapDispatchToProps = (dispatch: Function) => {
    return {}
}

const connector = connect(mapStateToProps, mapDispatchToProps);

type Props = ConnectedProps<typeof connector> & {}


type State = {
    markers: Marker[],
    refresh: {
        fires: boolean,
        trucks: boolean
    },

}

class CustomMap extends Component<Props, State> {
    public state: State = {
        markers: [],
        refresh: {
            fires: true,
            trucks: true
        },
    }
    private map?: L.Map;
    // @ts-ignore
    private cluster?: L.MarkerClusterGroup;

    static getDerivedStateFromProps = (props: Props, state: State): State | null => {

        if (props.fires.length + props.trucks.length !== state.markers.length) {
            return {
                ...state,
                markers: [
                    ...props.fires.map(f => ({data: f, pos: {lat: f.latitude, lng: f.longitude}, type: MarkerType.fire})),
                    ...props.trucks.map(t => ({data: t, pos: {lat: t.latitude, lng: t.longitude}, type: MarkerType.truck})),
                ],
                refresh: {
                    ...state.refresh,
                    fires: true
                }
            }
        }

        return null;

    }

    public async componentDidUpdate(props: Props) {
        await this.refresh()
    }

    public async componentDidMount() {
        this.map = this.mapEvents(this.createMap(defaultPosition));
        await Services.fire.watch()
        await Services.truck.watch()
        await this.refresh();
    }

    public render() {
        return <div id="leaflet">
        </div>
    }


    private async refresh() {
        if (this.state.refresh.fires || this.state.refresh.trucks) {
            await this.refreshPoiMarkers(this.state.markers);
        }
    }


    private async refreshPoiMarkers(fires: Marker[]) {
        if (this.map) {
            if (this.cluster) {
                this.map.removeLayer(this.cluster);
            }

            if (this.state.markers) {
                // @ts-ignore
                this.cluster = L.markerClusterGroup();
                this.cluster.addLayers(fires.map(poi => {

                    const intensity = poi.type === MarkerType.fire ? (poi.data as FireElement).intensity  : undefined

                    return createMarker(poi.pos, poi.type, intensity)
                    //     .on("click", (event: LeafletMouseEvent) => {
                    //     const marker = fires.find(poi => poi.pos as LatLng === event.latlng);
                    //     if (marker === undefined) {
                    //         throw new Error(`Can not find poi marker with coords=${JSON.stringify(poi.pos)}`)
                    //     }
                    // })
                }))

                this.map.addLayer(this.cluster);
            }
        }

    }


    private mapEvents = (map: L.Map) => {
        // map.on("contextmenu", this.handleContextMenu)
        // map.on("movestart", this.closeContextMenu)
        // map.on("click", this.closeContextMenu)
        return map;
    }

    private createMap(pos: LatLngExpression) {
        let map = L.map('leaflet', {
            center: pos,
            zoom: 3,
            minZoom: 3,
            zoomControl: false,
            layers: [
                L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {}),
            ],
        });


        return map;
    }

}

export default connect(mapStateToProps, mapDispatchToProps)(CustomMap) as any;
