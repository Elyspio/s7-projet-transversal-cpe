import {Column, CreateDateColumn, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from "typeorm";
import {TruckEntity} from "./TruckEntity";

export const truckLocationTableName = "truck_location"

@Entity({name: truckLocationTableName})
export class TruckLocationEntity {
    @PrimaryGeneratedColumn()
    id: number;

    @CreateDateColumn()
    date: Date

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


