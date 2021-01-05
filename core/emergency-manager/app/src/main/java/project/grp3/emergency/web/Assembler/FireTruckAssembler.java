package project.grp3.emergency.web.Assembler;

import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.web.Entity.FireTruck;
import project.grp3.emergency.web.Entity.Fireman;

import java.util.ArrayList;

public class FireTruckAssembler extends BaseAssembler<FireTruckEntity, FireTruck>{



    @Override
    public FireTruck toData(FireTruckEntity fireTruckEntity) {

        var ressources = new ArrayList<Long>();
        for (ResourceEntity item:fireTruckEntity.getRessources()) {
            ressources.add(item.getId());
        }
        var f = new FireTruck(fireTruckEntity.getId(),fireTruckEntity.getBarrack().getId(),fireTruckEntity.getType().getId(), ressources);
        return f;
    }

    @Override
    public FireTruckEntity toEntity(FireTruck fireTruck) {
        return null;
    }
}
