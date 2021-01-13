import {Column, CreateDateColumn, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from "typeorm";
import {TruckEntity} from "./TruckEntity";
import {Property} from "@tsed/schema";

export const truckLocationTableName = "truck_location"

@Entity({name: truckLocationTableName})
export class TruckLocationEntity {
    @PrimaryGeneratedColumn()
    @Property(Number)
    id: number;

    @CreateDateColumn()
    @Property(Date)
    date: Date

    @Column("double precision", {nullable: false})
    @Property(Number)
    current_latitude: number

    @Column("double precision", {nullable: false})
    @Property(Number)
    current_longitude: number

    /**
     * Real truck's speed
     */
    @Column("double precision", {nullable: false})
    @Property(Number)
    speed: number;

    @ManyToOne(() => TruckEntity, truck => truck.id)
    @JoinColumn({name: "truck_id"})
    truck: TruckEntity;

}


