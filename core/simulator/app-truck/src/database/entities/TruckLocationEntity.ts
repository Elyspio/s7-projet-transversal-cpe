import {Column, Entity, JoinColumn, ManyToOne, PrimaryColumn, PrimaryGeneratedColumn} from "typeorm";
import {TruckEntity} from "./TruckEntity";

@Entity({name: "truck_location"})
export class TruckLocationEntity {
    @PrimaryGeneratedColumn()
    id: number;

    @Column("double precision", {nullable: false})
    current_latitude: number

    @Column("double precision", {nullable: false})
    current_longitude: number

    /**
     * Real truck's speed
     */
    @Column("double precision", {nullable: false})
    speed: number;

    @ManyToOne(() => TruckEntity, truck => truck.id)
    @JoinColumn({name: "truck_id"})
    truck: TruckEntity;

}


