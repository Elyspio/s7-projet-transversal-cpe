package project.grp3.emergency.core.exception;

import javax.persistence.Entity;

public class EntityNotFound extends Exception
{


    private Class cls;
    private Long id;

    public EntityNotFound(Class cls, Long id)
    {
        super("Could not found object of class %s for id %s".formatted(cls.getName(), id));
        this.cls = cls;
        this.id = id;
    }

    public Class getCls()
    {
        return cls;
    }


    public Long getId()
    {
        return id;
    }
}

