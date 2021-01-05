package project.grp3.simulator.web.assembler;

public abstract class BaseAssembler<Entity, Data>
{
    public abstract Data toData(Entity e);
    public abstract Entity toEntity(Data d);
}
