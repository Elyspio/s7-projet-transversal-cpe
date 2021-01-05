import {Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn} from "typeorm";
import {TruckEntity} from "./TruckEntity";

@Entity({name: "fireman"})
export class FiremanEntity {
    @PrimaryGeneratedColumn()
    id: number;

    @Column({nullable: false})
    id_fireman: number

    @Column({nullable: false})
    id_resource: number

    @ManyToOne(() => TruckEntity, truck => truck.id)
    @JoinColumn({name: "truck_id"})
    truck: TruckEntity;

}


