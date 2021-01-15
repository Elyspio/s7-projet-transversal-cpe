package project.grp3.simulator.core.database.repositories;

import project.grp3.simulator.core.database.entities.FireEntity;
import project.grp3.simulator.core.database.entities.SensorEntity;

import java.util.List;
import java.util.stream.Collectors;

public class FireRepository extends Repository<FireEntity>
{
    public FireRepository()
    {
        super(FireEntity.class);
    }


    public List<FireEntity> getActiveFire()
    {

        return this.getAll().stream().filter(f -> f.getEndDate() == null).collect(Collectors.toList());
//
//        CriteriaBuilder cb = manager.getCriteriaBuilder();
//        var cq = cb.createQuery(FireEntity.class);
//        var root = cq.from(FireEntity.class);
//        List<Predicate> criteres = new ArrayList<>();
//        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
//        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
//        return manager.createQuery(cq).getResultList();
    }

    public boolean isExist(SensorEntity sensor)
    {

        return this.getActiveFire().stream().anyMatch(f -> f.getSensor().equals(sensor));

//        var cq = manager.getCriteriaBuilder().createQuery(FireEntity.class);
//        var root = cq.from(FireEntity.class);
//        List<Predicate> criteres = new ArrayList<>();
//        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
//        criteres.add(manager.getCriteriaBuilder().equal(root.get("sensor"), sensor));
//        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
//        var res = manager.createQuery(cq).getResultStream().toArray();
//        return res.length > 0;
    }

    public FireEntity getActiveBySensorId(SensorEntity sensor)
    {

        return this.getActiveFire().stream().filter(f -> f.getSensor().equals(sensor)).findFirst().get();
//
//        CriteriaBuilder cb = manager.getCriteriaBuilder();
//        var cq = cb.createQuery(FireEntity.class);
//        var root = cq.from(FireEntity.class);
//        List<Predicate> criteres = new ArrayList<>();
//        criteres.add(manager.getCriteriaBuilder().isNull(root.get("endDate")));
//        criteres.add(manager.getCriteriaBuilder().equal(root.get("sensor"), sensor));
//
//        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true);
//        return manager.createQuery(cq).getSingleResult();
    }

}
