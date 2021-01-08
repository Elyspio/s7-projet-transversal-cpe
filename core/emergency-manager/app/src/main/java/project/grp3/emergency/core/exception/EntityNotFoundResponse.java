package project.grp3.emergency.core.exception;

public class EntityNotFoundResponse
{
    public Long id;
    public String entity;

    public EntityNotFoundResponse(EntityNotFound err)
    {
        this.id = err.getId();
        this.entity = err.getCls().getName();
    }
}
