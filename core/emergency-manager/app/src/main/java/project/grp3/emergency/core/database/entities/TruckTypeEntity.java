package project.grp3.emergency.core.database.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TruckType")
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
