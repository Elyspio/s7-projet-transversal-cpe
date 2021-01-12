import L, {LatLngExpression} from "leaflet";
import {MarkerType} from "../../store/interface/Map";

export function  createMarker(latLng: LatLngExpression, markerType: MarkerType) {
    let icon;
    switch (markerType) {
        case MarkerType.fire:
            icon = createFire()
            break;
    }
    return L.marker(latLng, {
        icon,
        keyboard: markerType !== MarkerType.fire
    })
}

function createFire() {
    return L.icon({
        iconUrl: 'https://img.icons8.com/emoji/48/000000/fire.png',
        shadowUrl: 'https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-shadow.png',
        iconSize: [25, 41],
        iconAnchor: [12, 41],
        popupAnchor: [1, -34],
        shadowSize: [41, 41]
    })
}
