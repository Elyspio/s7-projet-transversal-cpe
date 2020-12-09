package project.grp3.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "FireTruck")
public class FireTruck {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barrack_id")
    private Barrack barrack;

    @ManyToOne(optional = false)
    @JoinColumn(name="truck_type_id")
    private TruckType type;

    @ManyToMany
    private List<FireType> fireTypes;

    @ManyToMany
    private List<Ressource> ressources;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<FireType> getFireTypes() {
        return fireTypes;
    }

    public void setFireTypes(List<FireType> fireTypes) {
        this.fireTypes = fireTypes;
    }


    public List<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(List<Ressource> ressources) {
        this.ressources = ressources;
    }
}
