import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from "typeorm";
import {TruckLocationEntity} from "./TruckLocationEntity";
import {FiremanEntity} from "./FiremanEntity";

@Entity({name: "truck"})
export class TruckEntity {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({nullable: false})
    id_truck: number;

    @Column({nullable: false})
    id_resource: number
    /**
     * Nominal truck's speed
     */
    @Column("double precision", {nullable: false})
    speed: number;

    @Column("double precision", {nullable: false})
    start_latitude: number

    @Column("double precision", {nullable: false})
    start_longitude: number

    @Column("double precision", {nullable: false})
    dest_latitude: number

    @Column("double precision", {nullable: false})
    dest_longitude: number

    /**
     *
     */
    @Column("int")
    travelState: TravelState

    @OneToMany(() => TruckLocationEntity, truckLocation => truckLocation.truck)
    locations: TruckLocationEntity[]

    @OneToMany(() => FiremanEntity, fireman => fireman.truck)
    firemen: FiremanEntity[]


    public get isActive() {
        return ([TravelState.MOVING, TravelState.OPERATING].includes(this.travelState))
    }

}


export enum TravelState {
    MOVING,
    OPERATING,
    DONE
}
