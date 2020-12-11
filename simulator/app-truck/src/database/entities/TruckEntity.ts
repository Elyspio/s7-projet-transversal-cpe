import {Column, Entity, OneToMany, PrimaryColumn, PrimaryGeneratedColumn} from "typeorm";
import {TruckLocationEntity} from "./TruckLocationEntity";
import {FiremanEntity} from "./FiremanEntity";

@Entity({name: "truck"})
export class TruckEntity {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({nullable: false})
    id_truck: number;

    /**
     * Nominal truck's speed
     */
    @Column({nullable: false})
    speed: number;

    @Column({nullable: false})
    start_latitude: number

    @Column({nullable: false})
    start_longitude: number

    @Column({nullable: false})
    dest_latitude: number

    @Column({nullable: false})
    dest_longitude: number

    /**
     *
     */
    @Column({default: false})
    arrived: boolean

    @OneToMany(() => TruckLocationEntity, truckLocation => truckLocation.truck)
    locations: TruckLocationEntity[]

    @OneToMany(() => FiremanEntity, fireman => fireman.truck)
    firemen: FiremanEntity[]
}


