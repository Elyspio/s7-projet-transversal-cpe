package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Resource")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ResourceEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name = "fire_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private FireEntity fire;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "fireman_resource",
            joinColumns = @JoinColumn(name = "fireman_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<FiremanEntity> firemen;
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "firetruck_resource",
            joinColumns = @JoinColumn(name = "firetruck_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<FireTruckEntity> fireTrucks;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private List<LogEntity> logs;
    private TruckTravelState travelState;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof ResourceEntity)) return false;
        ResourceEntity logEntity = (ResourceEntity) o;
        return Objects.equals(id, logEntity.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public FireEntity getFire()
    {
        return this.fire;
    }

    public void setFire(FireEntity fire)
    {
        this.fire = fire;
    }

    public List<FireTruckEntity> getFireTrucks()
    {
        return this.fireTrucks;
    }

    public void setFireTrucks(List<FireTruckEntity> fireTrucks)
    {
        this.fireTrucks = fireTrucks;
    }

    public List<FiremanEntity> getFiremen()
    {
        return this.firemen;
    }

    public void setFiremen(List<FiremanEntity> firemen)
    {
        this.firemen = firemen;
    }

    public TruckTravelState getTravelState()
    {
        return this.travelState;
    }

    public void setTravelState(TruckTravelState travelState)
    {
        this.travelState = travelState;
    }
}
