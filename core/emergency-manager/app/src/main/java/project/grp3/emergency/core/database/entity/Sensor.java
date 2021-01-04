package project.grp3.simulator.core.database.entity;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Sensor")
public class Sensor {
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
    private List<Fire> fires;


    @ManyToMany(mappedBy = "sensors")
    private Set<FireType> fireTypes;


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

    public Set<FireType> getFireTypes() {
        return fireTypes;
    }
}