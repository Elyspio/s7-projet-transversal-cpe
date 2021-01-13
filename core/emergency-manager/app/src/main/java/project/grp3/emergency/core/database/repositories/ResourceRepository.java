package project.grp3.emergency.core.database.repositories;

import org.hibernate.query.NativeQuery;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.util.List;

public class ResourceRepository extends Repository<ResourceEntity>
{
    public ResourceRepository()
    {
        super(ResourceEntity.class);
    }

    public List<ResourceEntity> getAllActif()
    {
        var cq = DbAccess.manager.getCriteriaBuilder().createQuery(ResourceEntity.class);
        var all = cq.select(cq.from(ResourceEntity.class));
        all.where(DbAccess.manager.getCriteriaBuilder().notEqual(cq.from(ResourceEntity.class).get("travelState"), TruckTravelState.AVAILABLE));
        return DbAccess.manager.createQuery(cq).getResultList();
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
        String sql = "SELECT * FROM resource where fire_id = :fire_id";
        NativeQuery<ResourceEntity> query = DbAccess.session.createNativeQuery(sql, ResourceEntity.class);
        query.setParameter("fire_id", fire.getId());
        return query.getSingleResult();
//        var cq = DbAccess.manager.getCriteriaBuilder().createQuery(ResourceEntity.class);
//        var all = cq.select(cq.from(ResourceEntity.class));
//        all.where(DbAccess.manager.getCriteriaBuilder().notEqual(cq.from(ResourceEntity.class).get("fire"), fire));
//        return DbAccess.manager.createQuery(cq).getResultList().get(0);
    }
}
