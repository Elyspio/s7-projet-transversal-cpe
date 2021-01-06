package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.Date;

public class FireRepository extends Repository<FireEntity>
{
    public FireRepository()
    {
        super(FireEntity.class);
    }

    public FireEntity create(Long sensorId, Long fireTypeId)
    {
        var fire = new FireEntity();
        fire.setDetectionDate(Date.from(Instant.now()));
        fire.setSensor(Database.sensorRepository.getById(sensorId));
        fire.setType(Database.fireTypeRepository.getById(fireTypeId));
        return super.create(fire);
    }

    public boolean isExist(Long sensorId)
    {
        var cq = manager.getCriteriaBuilder().createQuery(FireEntity.class);
        var all = cq.select(cq.from(FireEntity.class));
        all.where(manager.getCriteriaBuilder().equal(cq.from(FireEntity.class).get("sensor"), sensorId));
        return !manager.createQuery(cq).getResultList().isEmpty();
    }

    // FIXME DORIAN
    public FireEntity getActifBySensorId(Long sensorId)
    {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        var cq = cb.createQuery(FireEntity.class);
        var all = cq.select(cq.from(FireEntity.class));
        all.where(manager.getCriteriaBuilder().equal(cq.from(FireEntity.class).get("sensor"), sensorId));
        return manager.createQuery(cq).getSingleResult();
    }

}
