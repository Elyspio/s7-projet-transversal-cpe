package project.grp3.emergency.core.database.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sensor")
public class SensorEntity
{
    @Id
    @GeneratedValue
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
