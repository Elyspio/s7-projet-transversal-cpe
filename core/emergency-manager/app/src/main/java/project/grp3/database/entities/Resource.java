package project.grp3.database.entities;

import project.grp3.database.enums.TruckTravelState;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Resource")
public class Resource {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "fire_id", nullable = false)
    private Fire fire;

    @ManyToMany
    @JoinTable(
            name = "fireman_resource",
            joinColumns = @JoinColumn(name = "fireman_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )    private List<Fireman> firemen;

    @ManyToMany
    @JoinTable(
            name = "firetruck_resource",
            joinColumns = @JoinColumn(name = "firetruck_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id")
    )
    private List<FireTruck> fireTrucks;

    @OneToMany
    @JoinColumn(name = "ressource_log_id")
    private List<Log> logs;
    private TruckTravelState travelState;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fire getFire() {
        return this.fire;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }

    public List<FireTruck> getFireTrucks() {
        return this.fireTrucks;
    }

    public void setFireTrucks(List<FireTruck> fireTrucks) {
        this.fireTrucks = fireTrucks;
    }

    public List<Fireman> getFiremen() {
        return this.firemen;
    }

    public void setFiremen(List<Fireman> firemen) {
        this.firemen = firemen;
    }

    public TruckTravelState getTravelState() {
        return this.travelState;
    }

    public void setTravelState(TruckTravelState travelState) {
        this.travelState = travelState;
    }
}
