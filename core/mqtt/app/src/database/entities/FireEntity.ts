import {Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from "typeorm";
import {SensorEntity} from "./SensorEntity";
import {FireType} from "../../../../../truck-manager/app/src/core/apis/emergency/models";
import {FireTypeEntity} from "./FireTypeEntity";


export type SensorEntityWithId =  Omit<SensorEntity, "id">


@Entity({name: "fire"})
export class FireEntity {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({name: "fire_id"})
    fireId: number

    @Column()
    intensity: number

    @ManyToOne(() => SensorEntity, sensor => sensor.sensorId)
    @JoinColumn({name: "sensor_id"})
    sensor: SensorEntity

    @Column("timestamp")
    date: Date


    @ManyToOne(() => FireTypeEntity, fireType => fireType.fireTypeId)
    type: FireType
}
