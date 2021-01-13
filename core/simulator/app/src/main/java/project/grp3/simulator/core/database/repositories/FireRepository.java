package project.grp3.simulator.core.database.repositories;

import project.grp3.simulator.core.database.entities.FireEntity;
import project.grp3.simulator.core.database.entities.SensorEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class FireRepository extends Repository<FireEntity>
{
    public FireRepository()
    {
        super(FireEntity.class);
    }


    public List<FireEntity> getActiveFire()
    {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        var cq = cb.createQuery(FireEntity.class);
        var root = cq.from(FireEntity.class);
        List<Predicate> criteres = new ArrayList<>();
        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
        return manager.createQuery(cq).getResultList();
    }

    public boolean isExist(SensorEntity sensor)
    {
        var cq = manager.getCriteriaBuilder().createQuery(FireEntity.class);
        var root = cq.from(FireEntity.class);
        List<Predicate> criteres = new ArrayList<>();
        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
        criteres.add(manager.getCriteriaBuilder().equal(root.get("sensor"), sensor));
        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
        var res = manager.createQuery(cq).getResultStream().toArray();
        return res.length > 0;
    }

    public FireEntity getActiveBySensorId(SensorEntity sensor)
    {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        var cq = cb.createQuery(FireEntity.class);
        var root = cq.from(FireEntity.class);
        List<Predicate> criteres = new ArrayList<>();
        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
        criteres.add(manager.getCriteriaBuilder().equal(root.get("sensor"), sensor));

        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
        return manager.createQuery(cq).getSingleResult();
    }

}
