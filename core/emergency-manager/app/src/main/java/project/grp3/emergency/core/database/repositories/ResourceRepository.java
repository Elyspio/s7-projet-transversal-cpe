package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.ArrayList;

public class ResourceRepository extends Repository<ResourceEntity>
{
    public ResourceRepository()
    {
        super(ResourceEntity.class);
    }

    public ResourceEntity create(FireEntity fire, Integer intensity)
    {
        var resource = new ResourceEntity();
        resource.setFire(fire);
        resource.setTravelState(TruckTravelState.MOVING);
        var trucks = Database.fireTruckRepository.getAll();
        var firemans = Database.firemanRepository.getAll();
        var resources = this.getAll();
        for (ResourceEntity r : resources)
        {
            for (FireTruckEntity truck : trucks)
            {
                if (r.getFireTrucks().contains(truck))
                {
                    trucks.remove(truck);
                }
            }
            for (FiremanEntity fireman : firemans)
            {
                if (r.getFiremen().contains(fireman))
                {
                    firemans.remove(fireman);
                }
            }
        }
        var f = new ArrayList<FiremanEntity>();
        f.add(firemans.get(0));
        var t = new ArrayList<FireTruckEntity>();
        t.add(trucks.get(0));
        resource.setFiremen(f);
        resource.setFireTrucks(t);
        fire.setRessource(resource);
        fire = Database.fireRepository.update(fire);
        return fire.getRessource();
    }

    public int setArrived(Long ressourceId)
    {
        var resource = super.getById(ressourceId);
        resource.setTravelState(TruckTravelState.ARRIVED);
        var resource2 = super.update(resource);
        if (resource2.getId() != null && resource2.getId() == resource.getId())
        {
            return 201;
        }
        return 500;
    }

    public ResourceEntity getOne(Long resourceId)
    {
        return super.get(resourceId);
    }

    public void getOneByFireId(Long id)
    {
    }
}
