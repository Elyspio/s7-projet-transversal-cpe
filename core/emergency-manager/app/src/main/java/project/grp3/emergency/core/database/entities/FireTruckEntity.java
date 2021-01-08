package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "FireTruck")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FireTruckEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "barrack_id")
    private BarrackEntity barrack;
    @ManyToOne(optional = false)
    @JoinColumn(name = "truck_type_id")
    private TruckTypeEntity type;
    @ManyToMany(mappedBy = "fireTrucks")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ResourceEntity> resources;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof FireTruckEntity)) return false;
        FireTruckEntity that = (FireTruckEntity) o;
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


    public BarrackEntity getBarrack()
    {
        return barrack;
    }

    public void setBarrack(BarrackEntity barrack)
    {
        this.barrack = barrack;
    }


    public TruckTypeEntity getType()
    {
        return type;
    }

    public void setType(TruckTypeEntity type)
    {
        this.type = type;
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
