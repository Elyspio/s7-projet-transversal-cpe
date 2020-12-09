package project.grp3.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "FireType")
public class FireType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = true)
    private String description;


    @ManyToMany
    @JoinColumn(name = "fire_truck_id")
    private List<TruckType> truckTypes;

    @OneToMany
    @JoinColumn(name = "fire_type_id")
    private List<Fire> fires;

    @ManyToMany
    @JoinColumn(name = "sensor_id")
    private List<Sensor> sensors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TruckType> getTruckTypes() {
        return truckTypes;
    }

    public void setTruckTypes(List<TruckType> truckTypes) {
        this.truckTypes = truckTypes;
    }


    public List<Fire> getFires() {
        return fires;
    }

    public void setFires(List<Fire> fires) {
        this.fires = fires;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
