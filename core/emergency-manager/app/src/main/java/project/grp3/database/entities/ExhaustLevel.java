package project.grp3.database.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ExhaustLevel")
public class ExhaustLevel {
    @Id
    private String label;

    private Integer value;


    @OneToMany
    @JoinColumn(name = "exhaust_level_id")
    private List<Fireman> firemen;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Fireman> getFiremen() {
        return firemen;
    }

    public void setFiremen(List<Fireman> firemen) {
        this.firemen = firemen;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
