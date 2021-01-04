package project.grp3.emergency.core.database.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ExhaustLevel")
public class ExhaustLevelEntity {
    @Id
    private Long id;

    private String label;

    private Integer value;


    @OneToMany()
    @JoinColumn(name = "exhaust_level_id")
    @JsonIgnore
    private List<FiremanEntity> firemen;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<FiremanEntity> getFiremen() {
        return firemen;
    }

    public void setFiremen(List<FiremanEntity> firemen) {
        this.firemen = firemen;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
