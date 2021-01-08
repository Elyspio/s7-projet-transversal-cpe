package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.SensorEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public boolean isExist(SensorEntity sensor)
    {
        var cq = manager.getCriteriaBuilder().createQuery(FireEntity.class);
        var root = cq.from(FireEntity.class);
        //var all = cq.select(cq.from(FireEntity.class));
        /*all.where(manager.getCriteriaBuilder().and(manager.getCriteriaBuilder().equal(cq.from(FireEntity.class).get("sensor"), sensorId),manager.getCriteriaBuilder().isNull(cq.from(FireEntity.class).get("endDate"))));

         */
        List<Predicate> criteres = new ArrayList<Predicate>();
        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
        criteres.add(manager.getCriteriaBuilder().equal(root.get("sensor"), sensor));

        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
        var res = manager.createQuery(cq).getResultList();
        return !res.isEmpty();
    }

    // FIXME DORIAN
    public FireEntity getActifBySensorId(SensorEntity sensor)
    {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        var cq = cb.createQuery(FireEntity.class);
        var root = cq.from(FireEntity.class);
        List<Predicate> criteres = new ArrayList<Predicate>();
        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
        criteres.add(manager.getCriteriaBuilder().equal(root.get("sensor"), sensor));

        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
        return manager.createQuery(cq).getSingleResult();
    }

    public FireEntity update(FireEntity item)
    {
        return super.update(item);
    }

}
