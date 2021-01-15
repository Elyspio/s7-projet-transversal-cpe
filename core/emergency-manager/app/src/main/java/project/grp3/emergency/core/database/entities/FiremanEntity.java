package project.grp3.emergency.core.database.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Fireman")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FiremanEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastname;
    @ManyToOne()
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "exhaust_level_id")
    private ExhaustLevelEntity exhaustLevel;
    @ManyToMany(mappedBy = "firemen")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ResourceEntity> resources;
    @ManyToOne()
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "barrack_id")
    private BarrackEntity barrack;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof FiremanEntity)) return false;
        FiremanEntity that = (FiremanEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public ExhaustLevelEntity getExhaustLevel()
    {
        return exhaustLevel;
    }

    public void setExhaustLevel(ExhaustLevelEntity exhaustLevel)
    {
        this.exhaustLevel = exhaustLevel;
    }

    public BarrackEntity getBarrack()
    {
        return barrack;
    }

    public void setBarrack(BarrackEntity barrack)
    {
        this.barrack = barrack;
    }


    public List<ResourceEntity> getResources()
    {
        return resources;
    }

    public void setResources(List<ResourceEntity> ressources)
    {
        this.resources = ressources;
    }


}
