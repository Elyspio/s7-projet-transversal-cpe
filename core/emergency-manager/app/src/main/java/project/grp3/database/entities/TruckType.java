package project.grp3.database.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TruckType")
public class TruckType {

    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private int capacity;
    private float volume;
    private float speed;

    @OneToMany
    @JoinColumn(name="truck_type_id")
    private List<FireTruck> fireTrucks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public List<FireTruck> getFireTrucks() {
        return fireTrucks;
    }

    public void setFireTrucks(List<FireTruck> fireTrucks) {
        this.fireTrucks = fireTrucks;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
