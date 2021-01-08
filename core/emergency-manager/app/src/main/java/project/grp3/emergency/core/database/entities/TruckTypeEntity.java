package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TruckType")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TruckTypeEntity
{


    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private int capacity;
    private float volume;
    private float speed;

    @OneToMany
    @JoinColumn(name = "truck_type_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<FireTruckEntity> fireTrucks;

    @ManyToMany
    @JoinTable(
            name = "trucktype_firetype",
            joinColumns = @JoinColumn(name = "firetype_id"),
            inverseJoinColumns = @JoinColumn(name = "trucktype_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<FireTypeEntity> fireTypes;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof TruckTypeEntity)) return false;
        TruckTypeEntity e = (TruckTypeEntity) o;
        return Objects.equals(id, e.id);
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


    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public float getVolume()
    {
        return volume;
    }

    public void setVolume(float volume)
    {
        this.volume = volume;
    }

    public List<FireTruckEntity> getFireTrucks()
    {
        return fireTrucks;
    }

    public void setFireTrucks(List<FireTruckEntity> fireTrucks)
    {
        this.fireTrucks = fireTrucks;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public List<FireTypeEntity> getFireTypes()
    {
        return fireTypes;
    }

    public void setFireTypes(List<FireTypeEntity> fireTypes)
    {
        this.fireTypes = fireTypes;
    }
}
