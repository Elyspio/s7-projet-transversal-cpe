import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from "typeorm";
import {TruckLocationEntity} from "./TruckLocationEntity";
import {FiremanEntity} from "./FiremanEntity";


export enum TravelState {
    MOVING = "MOVING",
    DONE = "DONE"
}


export enum TravelDirection {
    FIRE = "fire",
    BARRACK = "barrack"
}

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
    @Column({
        type: "enum",
        enum: TravelState,
    })
    travelState: TravelState

    @Column({
        type: "enum",
        enum: TravelDirection,
    })
    travelDirection: TravelDirection

    @OneToMany(() => TruckLocationEntity, truckLocation => truckLocation.truck)
    locations: TruckLocationEntity[]

    @OneToMany(() => FiremanEntity, fireman => fireman.truck)
    firemen: FiremanEntity[]


    public get isMoving() {
        return this.travelState === TravelState.MOVING
    }

    public get isArrived() {
        return this.travelState === TravelState.DONE
    }

}

