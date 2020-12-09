package project.grp3.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Fireman")
public class Fireman {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String lastname;


    @ManyToOne
    @JoinColumn(name = "exhaust_level_id")
    private ExhaustLevel exhaustLevel;

    @ManyToMany
    @JoinColumn(name="ressource_id")
    private List<Ressource> ressources;


    @ManyToOne
    @JoinColumn(name = "barrack_id")
    private Barrack barrack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ExhaustLevel getExhaustLevel() {
        return exhaustLevel;
    }

    public void setExhaustLevel(ExhaustLevel exhaustLevel) {
        this.exhaustLevel = exhaustLevel;
    }

    public Barrack getBarrack() {
        return barrack;
    }

    public void setBarrack(Barrack barrack) {
        this.barrack = barrack;
    }


    public List<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(List<Ressource> ressources) {
        this.ressources = ressources;
    }
}
