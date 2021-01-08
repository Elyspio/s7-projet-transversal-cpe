package project.grp3.emergency.web.service;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.ArrayList;
import java.util.Comparator;

public class ResourceService
{

    public static ResourceEntity create(FireEntity fire, Integer intensity)
    {
        var resource = new ResourceEntity();
        resource.setFire(fire);
        resource.setTravelState(TruckTravelState.MOVING);
        var trucks = Database.fireTruckRepository.getAll();
        var firemans = Database.firemanRepository.getAll();
        var availableTrucks = new ArrayList<FireTruckEntity>();
        var availableFiremen = new ArrayList<FiremanEntity>();
        var resources = Database.resourceRepository.getAllActif();
        var exist = false;
        for (FireTruckEntity truck : trucks)
        {
            exist = false;
            for (ResourceEntity r : resources)
            {
                if (r.getFireTrucks().contains(truck))
                {
                    exist = true;
                    break;
                }
            }
            if (!exist && truck.getType().getFireTypes().contains(fire.getType()))
            {
                availableTrucks.add(truck);
            }
        }
        for (FiremanEntity fireman : firemans)
        {
            exist = false;
            for (ResourceEntity r : resources)
            {
                if (!r.getFiremen().contains(fireman))
                {
                    exist = true;
                    break;
                }
            }
            if (!exist && fireman.getExhaustLevel().getValue() != 0)
            {
                availableFiremen.add(fireman);
            }
        }
        var f = new ArrayList<FiremanEntity>();
        availableFiremen.sort(new Comparator<FiremanEntity>()
        {
            @Override
            public int compare(FiremanEntity o1, FiremanEntity o2)
            {
                return o1.getExhaustLevel().getValue() - o2.getExhaustLevel().getValue();
            }
        });
        availableTrucks.sort(new Comparator<FireTruckEntity>()
        {
            @Override
            public int compare(FireTruckEntity o1, FireTruckEntity o2)
            {
                return (int) (o1.getType().getVolume() - o2.getType().getVolume());
            }
        });
        int i = 0;
        int j = 0;
        int place = 0;
        var t = new ArrayList<FireTruckEntity>();
        while (i < intensity && availableTrucks.size() < f.size())
        {
            i += availableTrucks.get(j).getType().getVolume();
            t.add(availableTrucks.get(j));
            place += availableTrucks.get(j).getType().getCapacity();
            j++;
        }
        while (f.size() < place)
        {
            f.add(availableFiremen.get(0));
        }
        resource.setFiremen(f);
        resource.setFireTrucks(t);
        return Database.resourceRepository.create(fire, resource);
    }

    public void setArrived(Long resourceId)
    {
        var resource = Database.resourceRepository.getOne(resourceId);
        for (FiremanEntity item : resource.getFiremen())
        {
            item.getExhaustLevel().setValue(item.getExhaustLevel().getValue() - 25);
        }
        Database.resourceRepository.setArrived(resourceId);
    }

}
