package project.grp3.emergency.core.database.repositories;


import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FireTruckRepository extends Repository<FireTruckEntity>
{
    public FireTruckRepository()
    {
        super(FireTruckEntity.class);
    }

    public List<FireTruckEntity> getAll()
    {
        return super.getAll();
    }

    public FireTruckEntity getById(Long id)
    {
        return super.getById(id);
    }


    public List<FireTruckEntity> getAvailable()
    {
        return getAll().stream().filter(fireTruck -> {
            var stream = new ArrayList<>(fireTruck.getResources());
            return stream.isEmpty() || stream.stream().anyMatch(r -> r.getTravelState() != TruckTravelState.AVAILABLE);
        }).collect(Collectors.toList());
    }

}
