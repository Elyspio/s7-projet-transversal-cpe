package project.grp3.emergency.core.database.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "FireTruck")
public class FireTruckEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barrack_id")
    private BarrackEntity barrack;

    @ManyToOne(optional = false)
    @JoinColumn(name="truck_type_id")
    private TruckTypeEntity type;



    @ManyToMany(mappedBy = "fireTrucks")
    private List<ResourceEntity> ressources;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public BarrackEntity getBarrack() {
        return barrack;
    }

    public void setBarrack(BarrackEntity barrack) {
        this.barrack = barrack;
    }


    public TruckTypeEntity getType() {
        return type;
    }

    public void setType(TruckTypeEntity type) {
        this.type = type;
    }


    public List<ResourceEntity> getRessources() {
        return ressources;
    }

    public void setRessources(List<ResourceEntity> ressources) {
        this.ressources = ressources;
    }
}
