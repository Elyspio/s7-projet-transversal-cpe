package project.grp3.emergency.core.database.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Fireman")
public class FiremanEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;

    @ManyToOne()
    @JoinColumn(name = "exhaust_level_id")
    private ExhaustLevelEntity exhaustLevel;

    @ManyToMany()
    private List<ResourceEntity> ressources;

    @ManyToOne()
    @JoinColumn(name = "barrack_id")
    private BarrackEntity barrack;


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

    public ExhaustLevelEntity getExhaustLevel() {
        return exhaustLevel;
    }

    public void setExhaustLevel(ExhaustLevelEntity exhaustLevel) {
        this.exhaustLevel = exhaustLevel;
    }

    public BarrackEntity getBarrack() {
        return barrack;
    }

    public void setBarrack(BarrackEntity barrack) {
        this.barrack = barrack;
    }


    public List<ResourceEntity> getRessources() {
        return ressources;
    }

    public void setRessources(List<ResourceEntity> ressources) {
        this.ressources = ressources;
    }


}