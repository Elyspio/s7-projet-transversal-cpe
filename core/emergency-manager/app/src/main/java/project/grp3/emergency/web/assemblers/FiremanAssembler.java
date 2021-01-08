package project.grp3.emergency.web.assemblers;

import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.web.entities.Fireman;

import java.util.ArrayList;

public class FiremanAssembler extends BaseAssembler<FiremanEntity, Fireman>
{


    @Override
    public Fireman toData(FiremanEntity firemanEntity)
    {

        var ressources = new ArrayList<Long>();
        for (ResourceEntity item : firemanEntity.getResources())
        {
            ressources.add(item.getId());
        }

        return new Fireman(
                firemanEntity.getId(),
                firemanEntity.getName(),
                firemanEntity.getLastname(),
                firemanEntity.getExhaustLevel().getId(),
                ressources,
                firemanEntity.getBarrack().getId()
        );
    }

    @Override
    public FiremanEntity toEntity(Fireman fireman)
    {
        return null;
    }
}
