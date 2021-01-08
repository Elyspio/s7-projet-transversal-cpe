package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FireType")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FireTypeEntity
{
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String label;
    @Column(nullable = true)
    private String description;
    @ManyToMany(mappedBy = "fireTypes")
    private List<TruckTypeEntity> truckTypes;
    @OneToMany
    @JoinColumn(name = "fire_type_id")
    private List<FireEntity> fires;
    @ManyToMany(mappedBy = "fireTypes")
    private List<SensorEntity> sensors;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof FireTypeEntity)) return false;
        FireTypeEntity that = (FireTypeEntity) o;
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

    public List<TruckTypeEntity> getTruckTypes()
    {
        return truckTypes;
    }

    public void setTruckTypes(List<TruckTypeEntity> truckTypes)
    {
        this.truckTypes = truckTypes;
    }


    public List<FireEntity> getFires()
    {
        return fires;
    }

    public void setFires(List<FireEntity> fires)
    {
        this.fires = fires;
    }

    public List<SensorEntity> getSensors()
    {
        return sensors;
    }

    public void setSensors(List<SensorEntity> sensors)
    {
        this.sensors = sensors;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
