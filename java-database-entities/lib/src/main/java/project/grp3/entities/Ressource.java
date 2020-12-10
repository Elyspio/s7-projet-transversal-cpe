package project.grp3.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ressource")
public class Ressource {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "fire_id", nullable = false)
    private Fire fire;

    @ManyToMany
    @JoinColumn(name="fireman_id")
    private List<Fireman> firemen;

    @ManyToMany
    @JoinColumn(name="fire_truck_id")
    private List<FireTruck> fireTrucks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fire getFire() {
        return fire;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }


    public List<FireTruck> getFireTrucks() {
        return fireTrucks;
    }
    public void setFireTrucks(List<FireTruck> fireTrucks) {
        this.fireTrucks = fireTrucks;
    }


    public List<Fireman> getFiremen() {
        return firemen;
    }

    public void setFiremen(List<Fireman> firemen) {
        this.firemen = firemen;
    }
}
