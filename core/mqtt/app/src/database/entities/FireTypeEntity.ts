import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from "typeorm";
import {SensorEntity} from "./SensorEntity";
import {FireEntity} from "./FireEntity";


@Entity({name: "fire_type"})
export class FireTypeEntity {

    @PrimaryGeneratedColumn()
    id: number;

    @Column({name: "fire_type_id"})
    fireTypeId: number


    @Column()
    description: string

    @Column()
    label: string

    @OneToMany(() => FireEntity, fire => fire.type)
    fires: FireEntity[]

    @Column("timestamp")
    date: Date
}
