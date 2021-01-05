package project.grp3.simulator.core.database.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FireType")
public class FireTypeEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = true)
    private String description;

    @OneToMany
    @JoinColumn(name = "fire_type_id")
    private List<FireEntity> fires;

    @ManyToMany
    @JoinTable(
            name = "firetype_sensor",
            joinColumns = @JoinColumn(name = "sensor_id"),
            inverseJoinColumns = @JoinColumn(name = "firetype_id")
    )
    private List<SensorEntity> sensors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FireEntity> getFires() {
        return fires;
    }

    public void setFires(List<FireEntity> fires) {
        this.fires = fires;
    }

    public List<SensorEntity> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorEntity> sensors) {
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
