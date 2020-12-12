package project.grp3.entities;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "Ressource_Log")
public class RessourceLog {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer intensity;

    @ManyToOne
    @JoinColumn(name = "fire_id")
    private Fire fire;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public Fire getFire() {
        return fire;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }
}
