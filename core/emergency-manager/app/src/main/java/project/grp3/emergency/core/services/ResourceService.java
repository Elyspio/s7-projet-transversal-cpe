package project.grp3.emergency.core.services;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.BarrackEntity;
import project.grp3.emergency.web.resource.models.ResourceGetResource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceService
{
    public ResourceGetResource getById(Long id)
    {
        var entity = Database.resourceRepository.getOne(id);

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
}
