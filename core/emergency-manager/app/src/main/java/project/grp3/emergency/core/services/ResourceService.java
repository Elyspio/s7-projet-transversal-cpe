package project.grp3.emergency.core.services;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.*;
import project.grp3.emergency.core.database.enums.TruckTravelState;
import project.grp3.emergency.core.exception.EntityNotFound;
import project.grp3.emergency.web.resource.models.ResourceGetResource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceService
{
    public ResourceGetResource getById(Long id) throws EntityNotFound
    {
        var entity = Database.resourceRepository().getOne(id);

        if (entity != null)
        {
            Set<BarrackEntity> barracks = new HashSet<>();

            var ret = new ResourceGetResource();
            ret.id = entity.getId();
            ret.firemen = entity.getFiremen().stream().map(f -> {
                var fireman = ResourceGetResource.Fireman.from(f);
                barracks.add(f.getBarrack());
                return fireman;
            }).collect(Collectors.toList());

            ret.trucks = entity.getFireTrucks().stream().map(t -> {
                var truck = ResourceGetResource.FireTruck.from(t);
                barracks.add(t.getBarrack());
                return truck;
            }).collect(Collectors.toList());


            ret.baracks = barracks.stream().map(ResourceGetResource.Barack::from).collect(Collectors.toList());

            return ret;
        }
        else
        {
            throw new EntityNotFound(ResourceEntity.class, id);
        }


    }


    public ResourceEntity create(FireEntity fire, Integer intensity)
    {
        var resource = new ResourceEntity();

        resource.setFire(fire);
        resource.setTravelState(TruckTravelState.MOVING);

        var availableTrucks = Database.fireTruckRepository().getAvailable();
        var availableFiremen = Database.firemanRepository().getAvailable();

        availableTrucks.sort((o1, o2) -> (int) (o1.getType().getVolume() - o2.getType().getVolume()));
        availableFiremen.sort(Comparator.comparingInt(o -> o.getExhaustLevel().getValue()));

        int sumVolume = 0;
        int truckIndex = 0;
        int place = 0;

        var truckList = new ArrayList<FireTruckEntity>();

        while (sumVolume < intensity && truckList.size() < availableTrucks.size())
        {
            sumVolume += availableTrucks.get(truckIndex).getType().getVolume();
            truckList.add(availableTrucks.get(truckIndex));
            place += availableTrucks.get(truckIndex).getType().getCapacity();
            truckIndex++;

        }


        truckIndex = 0;
        var firemen = new ArrayList<FiremanEntity>();
        while (firemen.size() < place && truckList.size() < availableFiremen.size())
        {
            firemen.add(availableFiremen.get(truckIndex++));
        }

        resource.setFiremen(firemen);
        resource.setFireTrucks(truckList);
        return Database.resourceRepository().create(fire, resource);
    }

    public void setArrived(Long resourceId)
    {
        var resource = Database.resourceRepository().getOne(resourceId);
        for (FiremanEntity item : resource.getFiremen())
        {
            int newExhaustLevel = item.getExhaustLevel().getValue() - 25;
            if(newExhaustLevel < 0) newExhaustLevel = 0;
            item.getExhaustLevel().setValue(newExhaustLevel);
        }
        Database.resourceRepository().setArrived(resourceId);
    }

}
