package project.grp3.database.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Fire")
public class Fire {

    @Id
    @GeneratedValue
    private Long id;
    private Date detectionDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "fire_type_id")
    private FireType type;


    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(Date detectionDate) {
        this.detectionDate = detectionDate;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
