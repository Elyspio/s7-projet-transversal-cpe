package project.grp3.emergency.web.assemblers;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAssembler<Entity, Data>
{


    public abstract Entity toEntity(Data data);

    public abstract Data toData(Entity entity);

    public List<Data> toData(List<Entity> entities)
    {
        return entities.stream().map(this::toData).collect(Collectors.toList());
    }

    public List<Entity> toEntity(List<Data> entities)
    {
        return entities.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
