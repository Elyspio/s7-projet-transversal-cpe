package project.grp3.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Fire")
public class Fire {

    @Id
    @GeneratedValue
    private Integer id;
    private Date detectionDate;
    private boolean isAlive;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "fire_type_id")
    private FireType type;


    @ManyToOne
    @JoinColumn(name = "ressource_id")
    private Ressource ressource;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(Date detectionDate) {
        this.detectionDate = detectionDate;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public FireType getType() {
        return type;
    }

    public void setType(FireType type) {
        this.type = type;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }


    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
