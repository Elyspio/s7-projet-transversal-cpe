package project.grp3.emergency.web.assemblers;

import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.web.entities.FireTruck;

import java.util.ArrayList;

public class FireTruckAssembler extends BaseAssembler<FireTruckEntity, FireTruck>
{


    @Override
    public FireTruck toData(FireTruckEntity fireTruckEntity)
    {

        var ressources = new ArrayList<Long>();
        for (ResourceEntity item : fireTruckEntity.getResources())
        {
            ressources.add(item.getId());
        }
        return new FireTruck(
                fireTruckEntity.getId(),
                fireTruckEntity.getBarrack().getId(),
                fireTruckEntity.getType().getId(),
                ressources
        );
    }

    @Override
    public FireTruckEntity toEntity(FireTruck fireTruck)
    {
        return null;
    }
}
