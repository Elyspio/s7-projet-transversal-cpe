package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceRepository extends Repository<ResourceEntity>
{
    public ResourceRepository()
    {
        super(ResourceEntity.class);
    }

    public List<ResourceEntity> getAllActif()
    {
        return getAll()
                .stream()
                .filter(res -> res.getTravelState().equals(TruckTravelState.AVAILABLE))
                .collect(Collectors.toList());
    }

    public ResourceEntity create(FireEntity fire, ResourceEntity resource)
    {
        fire.setResource(resource);
        fire = Database.fireRepository().update(fire);
        return fire.getResource();
    }

    public void setArrived(Long ressourceId)
    {
        var resource = super.getById(ressourceId);
        resource.setTravelState(TruckTravelState.AVAILABLE);
        var resource2 = super.update(resource);
    }

    public ResourceEntity getOne(Long resourceId)
    {
        return super.get(resourceId);
    }

    public ResourceEntity getByFire(FireEntity fire)
    {
        return getAll().stream().filter(res -> res.getFire().equals(fire)).findFirst().orElseGet(null);
    }


}
