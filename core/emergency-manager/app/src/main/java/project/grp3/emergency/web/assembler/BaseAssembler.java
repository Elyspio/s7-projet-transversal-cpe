package project.grp3.emergency.web.assembler;

public abstract class BaseAssembler<Entity, Data>
{

    public abstract Data toData(Entity entity);

    public abstract Entity toEntity(Data data);

}
