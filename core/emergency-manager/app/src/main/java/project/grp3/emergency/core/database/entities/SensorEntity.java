package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Sensor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SensorEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String street;
    @OneToMany
    @JoinColumn(name = "sensor_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<FireEntity> fires;
    @ManyToMany
    @JoinTable(
            name = "sensor_firetype",
            joinColumns = @JoinColumn(name = "firetype_id"),
            inverseJoinColumns = @JoinColumn(name = "sensor_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<FireTypeEntity> fireTypes;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SensorEntity)) return false;
        SensorEntity e = (SensorEntity) o;
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


    public List<FireEntity> getFires()
    {
        return fires;
    }

    public void setFires(List<FireEntity> fires)
    {
        this.fires = fires;
    }

    public List<FireTypeEntity> getFireTypes()
    {
        return fireTypes;
    }

    public void setFireTypes(List<FireTypeEntity> fireTypes)
    {
        this.fireTypes = fireTypes;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }
}
