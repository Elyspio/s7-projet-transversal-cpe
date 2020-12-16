package project.grp3.database.entities;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "Sdis")
public class Sdis {

    @Id
    private String name;
    private String department;

    @OneToMany
    @JoinColumn(name = "sdis_id")
    private List<Barrack> barracks;

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

    public List<Barrack> getBarracks() {
        return barracks;
    }

    public void setBarracks(List<Barrack> barracks) {
        this.barracks = barracks;
    }
}
