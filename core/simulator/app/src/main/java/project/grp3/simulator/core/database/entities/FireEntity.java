package project.grp3.simulator.core.database.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Fire", schema = "public")
public class FireEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date detectionDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "fire_type_id")
    private FireTypeEntity type;


    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorEntity sensor;


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

    public FireTypeEntity getType() {
        return type;
    }

    public void setType(FireTypeEntity type) {
        this.type = type;
    }

    public SensorEntity getSensor() {
        return sensor;
    }

    public void setSensor(SensorEntity sensor) {
        this.sensor = sensor;
    }
}
