package project.grp3.emergency.core.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "Sdis")
public class SdisEntity {

    @Id
    private Long id;
    private String name;
    private String department;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "sdis_id")
    private List<BarrackEntity> barracks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<BarrackEntity> getBarracks() {
        return barracks;
    }

    public void setBarracks(List<BarrackEntity> barracks) {
        this.barracks = barracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}