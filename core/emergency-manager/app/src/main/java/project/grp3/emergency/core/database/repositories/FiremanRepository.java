package project.grp3.emergency.core.database.repositories;


import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiremanRepository extends Repository<FiremanEntity>
{
    public FiremanRepository()
    {
        super(FiremanEntity.class);
    }

    public List<FiremanEntity> getAll()
    {
        return super.getAll();
    }

    public List<FiremanEntity> getAvailable()
    {
        return getAll().stream().filter(fireTruck -> {
            Stream<ResourceEntity> stream = fireTruck
                    .getResources()
                    .stream();
            return stream.count() == 0 || stream.anyMatch(r -> r.getTravelState() != TruckTravelState.AVAILABLE);
        }).collect(Collectors.toList());
    }

    public FiremanEntity getById(Long id)
    {
        return super.getById(id);
    }

}
