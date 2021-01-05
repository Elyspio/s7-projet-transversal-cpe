package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Barrack")
public class BarrackEntity {
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
    @JsonIgnore
    private List<FiremanEntity> firemen;

    @OneToMany
    @JoinColumn(name = "barrack_id")
    @JsonIgnore
    private List<FireTruckEntity> fireTrucks;

    @ManyToOne
    @JoinColumn(name = "sdis_id")
    private SdisEntity sdis;

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

    public List<FiremanEntity> getFiremen() {
        return firemen;
    }

    public void setFiremen(List<FiremanEntity> firemen) {
        this.firemen = firemen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public SdisEntity getSdis() {
        return sdis;
    }

    public void setSdis(SdisEntity sdis) {
        this.sdis = sdis;
    }

    public List<FireTruckEntity> getFireTrucks() {
        return fireTrucks;
    }

    public void setFireTrucks(List<FireTruckEntity> fireTrucks) {
        this.fireTrucks = fireTrucks;
    }
}