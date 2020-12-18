package project.grp3.database.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Fireman")
public class Fireman {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "exhaust_level_id")
    private ExhaustLevel exhaustLevel;

    @ManyToMany(mappedBy = "firemen")
    private List<Resource> ressources;

    @ManyToOne
    @JoinColumn(name = "barrack_id")
    private Barrack barrack;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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


    public List<Resource> getRessources() {
        return ressources;
    }

    public void setRessources(List<Resource> ressources) {
        this.ressources = ressources;
    }
}
