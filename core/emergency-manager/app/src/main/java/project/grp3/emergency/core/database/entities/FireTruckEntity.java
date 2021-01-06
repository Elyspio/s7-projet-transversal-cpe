package project.grp3.emergency.core.database.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "FireTruck")
public class FireTruckEntity
{
    @Id
    @GeneratedValue
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
