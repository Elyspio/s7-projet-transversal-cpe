package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.entities.SensorEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

public class ResourceRepository extends Repository<ResourceEntity> {
    public ResourceRepository() { super(ResourceEntity.class); }

    public ResourceEntity create(){
        var resource = new ResourceEntity();
        return resource;
    }

    public int setArrived(Long ressourceId){
        var resource = super.getById(ressourceId);
        resource.setTravelState(TruckTravelState.ARRIVED);
        var resource2 = super.update(resource);
        if(resource2.getId() != null && resource2.getId() == resource.getId()) {
            return 201;
        }
        return 500;
    }

}
