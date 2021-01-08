package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.ArrayList;
import java.util.List;

public class ResourceRepository extends Repository<ResourceEntity>
{
    public ResourceRepository()
    {
        super(ResourceEntity.class);
    }

    public List<ResourceEntity> getAllActif(){
        var cq = manager.getCriteriaBuilder().createQuery(ResourceEntity.class);
        var all = cq.select(cq.from(ResourceEntity.class));
        all.where(manager.getCriteriaBuilder().notEqual(cq.from(ResourceEntity.class).get("travelState"),TruckTravelState.ARRIVED));
        return manager.createQuery(cq).getResultList();
    }

    public ResourceEntity create(FireEntity fire, Integer intensity)
    {
        var resource = new ResourceEntity();
        resource.setFire(fire);
        resource.setTravelState(TruckTravelState.MOVING);
        var trucks = Database.fireTruckRepository.getAll();
        var firemans = Database.firemanRepository.getAll();
        var availableTrucks = new ArrayList<FireTruckEntity>();
        var availableFiremen = new ArrayList<FiremanEntity>();
        var resources = this.getAllActif();
        var exist= false;
        for (FireTruckEntity truck : trucks) {
            exist = false;
            for (ResourceEntity r : resources) {
                if (r.getFireTrucks().contains(truck)) {
                    exist=true;
                    break;
                }
            }
            if(!exist){
                availableTrucks.add(truck);
            }
        }
        for (FiremanEntity fireman : firemans) {
            exist = false;
            for (ResourceEntity r : resources) {
                if (!r.getFiremen().contains(fireman)) {
                    exist=true;
                    break;
                }
            }
            if(!exist){
                availableFiremen.add(fireman);
            }
        }
        var f = new ArrayList<FiremanEntity>();
        f.add(availableFiremen.get(0));
        var t = new ArrayList<FireTruckEntity>();
        t.add(availableTrucks.get(0));
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


}
