package project.grp3.simulator.core.database.repositories;

import project.grp3.simulator.core.database.entities.FireEntity;

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
}
