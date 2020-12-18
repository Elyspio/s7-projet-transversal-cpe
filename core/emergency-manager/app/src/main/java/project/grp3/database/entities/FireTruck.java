package project.grp3.database.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "FireTruck")
public class FireTruck {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barrack_id")
    private Barrack barrack;

    @ManyToOne(optional = false)
    @JoinColumn(name="truck_type_id")
    private TruckType type;



    @ManyToMany(mappedBy = "fireTrucks")
    private List<Resource> ressources;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Barrack getBarrack() {
        return barrack;
    }

    public void setBarrack(Barrack barrack) {
        this.barrack = barrack;
    }


    public TruckType getType() {
        return type;
    }

    public void setType(TruckType type) {
        this.type = type;
    }


    public List<Resource> getRessources() {
        return ressources;
    }

    public void setRessources(List<Resource> ressources) {
        this.ressources = ressources;
    }
}
