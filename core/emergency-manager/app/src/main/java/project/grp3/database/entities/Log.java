package project.grp3.database.entities;


import project.grp3.database.enums.LogAction;

import javax.persistence.*;

@Entity
@Table(name = "Log")
public class Log {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String value;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
    private LogAction action;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public LogAction getAction() {
        return this.action;
    }

    public void setAction(LogAction action) {
        this.action = action;
    }
}
