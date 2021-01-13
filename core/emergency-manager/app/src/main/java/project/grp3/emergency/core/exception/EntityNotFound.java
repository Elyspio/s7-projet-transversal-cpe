package project.grp3.emergency.core.exception;

public class EntityNotFound extends Exception
{


    private final Class cls;
    private final Long id;

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

