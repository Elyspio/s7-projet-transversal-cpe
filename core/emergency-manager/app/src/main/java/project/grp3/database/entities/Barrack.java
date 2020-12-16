package project.grp3.database.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Barrack")
public class Barrack {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String street;

    @OneToMany
    @JoinColumn(name = "barrack_id")
    private List<Fireman> firemen;

    @OneToMany
    @JoinColumn(name = "barrack_id")
    private List<FireTruck> fireTrucks;

    @ManyToOne
    @JoinColumn(name = "sdis_id")
    private Sdis sdis;

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

    public List<Fireman> getFiremen() {
        return firemen;
    }

    public void setFiremen(List<Fireman> firemen) {
        this.firemen = firemen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Sdis getSdis() {
        return sdis;
    }

    public void setSdis(Sdis sdis) {
        this.sdis = sdis;
    }

    public List<FireTruck> getFireTrucks() {
        return fireTrucks;
    }

    public void setFireTrucks(List<FireTruck> fireTrucks) {
        this.fireTrucks = fireTrucks;
    }
}
