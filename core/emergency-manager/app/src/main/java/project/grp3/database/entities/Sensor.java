package project.grp3.database.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String street;

    @OneToMany
    @JoinColumn(name = "fire_id")
    private List<Fire> fires;

    @ManyToMany
    @JoinTable(
            name = "sensor_firetype",
            joinColumns = @JoinColumn(name = "firetype_id"),
            inverseJoinColumns = @JoinColumn(name = "sensor_id")
    )
    private List<FireType> fireTypes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Fire> getFires() {
        return fires;
    }

    public void setFires(List<Fire> fires) {
        this.fires = fires;
    }

    public List<FireType> getFireTypes() {
        return fireTypes;
    }

    public void setFireTypes(List<FireType> fireTypes) {
        this.fireTypes = fireTypes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
