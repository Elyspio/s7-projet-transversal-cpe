package project.grp3.emergency.core.database.repositories;


import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    /*public List<FireTruckEntity> getAllArrived() {
        manager = sessionFactory.createEntityManager();
        var cq = manager.getCriteriaBuilder().createQuery(entity);
        var all = cq.select(cq.from(entity));
        return manager.createQuery(cq).getResultList();
    }*/

    public List<FireTruckEntity> getAvailable()
    {
        return getAll().stream().filter(fireTruck -> {
            Stream<ResourceEntity> stream = fireTruck
                    .getResources()
                    .stream();
            return stream.count() == 0 || stream.anyMatch(r -> r.getTravelState() != TruckTravelState.AVAILABLE);
        }).collect(Collectors.toList());
    }

}
