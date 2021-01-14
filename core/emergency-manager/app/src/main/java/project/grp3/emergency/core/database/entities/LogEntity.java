package project.grp3.emergency.core.database.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import project.grp3.emergency.core.database.enums.LogAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Log")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LogEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String value;
    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private ResourceEntity resource;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LogAction action;

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    private Date date;


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof LogEntity)) return false;
        LogEntity logEntity = (LogEntity) o;
        return Objects.equals(id, logEntity.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public ResourceEntity getResource()
    {
        return this.resource;
    }

    public void setResource(ResourceEntity resource)
    {
        this.resource = resource;
    }

    public LogAction getAction()
    {
        return this.action;
    }

    public void setAction(LogAction action)
    {
        this.action = action;
    }
}
