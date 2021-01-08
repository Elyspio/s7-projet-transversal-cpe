package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Fire")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FireEntity
{

    @Id
    @GeneratedValue
    private Long id;
    private Date detectionDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "fire_type_id")
    private FireTypeEntity type;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "ressource_id")
    private ResourceEntity ressource;
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorEntity sensor;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof FireEntity)) return false;
        FireEntity that = (FireEntity) o;
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

    public Date getDetectionDate()
    {
        return detectionDate;
    }

    public void setDetectionDate(Date detectionDate)
    {
        this.detectionDate = detectionDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public FireTypeEntity getType()
    {
        return type;
    }

    public void setType(FireTypeEntity type)
    {
        this.type = type;
    }

    public ResourceEntity getRessource()
    {
        return ressource;
    }

    public void setRessource(ResourceEntity ressource)
    {
        this.ressource = ressource;
    }


    public SensorEntity getSensor()
    {
        return sensor;
    }

    public void setSensor(SensorEntity sensor)
    {
        this.sensor = sensor;
    }
}
