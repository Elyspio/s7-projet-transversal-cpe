import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from "typeorm";
import {FireEntity} from "./FireEntity";


@Entity({name: "sensor"})
export class SensorEntity {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({name: "sensor_id"})
    sensorId: number

    @OneToMany(() => FireEntity, fire => fire.sensor)
    fires: FireEntity[]

    @Column("timestamp")
    date: Date

    @Column()
    city: string

    @Column()
    state: string

    @Column({name: "postal_code"})
    postalCode: string

    @Column()
    country: string

    @Column()
    street: string
}
