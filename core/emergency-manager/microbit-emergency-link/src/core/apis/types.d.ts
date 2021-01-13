export interface SensorFromEmergency {
    id:         number;
    city:       string;
    state:      string;
    postalCode: string;
    country:    string;
    street:     string;
    fireTypes:  FireType[];
}

export interface FireType {
    id:          number;
    label:       string;
    description: string;
}
