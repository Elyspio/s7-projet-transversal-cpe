package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.LogEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.LogAction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class LogRepository extends Repository<LogEntity>
{
    public LogRepository()
    {
        super(LogEntity.class);
    }

    public LogEntity create(Integer intensity, ResourceEntity resource, LogAction action)
    {
        var logEntity = new LogEntity();
        logEntity.setAction(action);
        logEntity.setValue(String.valueOf(intensity));
        logEntity.setResource(resource);
        return super.create(logEntity);
    }

    public String getLastIntensity(FireEntity fire)
    {
        CriteriaBuilder cb = DbAccess.manager.getCriteriaBuilder();
        var cq = cb.createQuery(LogEntity.class);
        var root = cq.from(LogEntity.class);
        List<Predicate> criteres = new ArrayList<>();
        criteres.add(DbAccess.manager.getCriteriaBuilder().equal(root.get("resource"), fire.getResource()));
        criteres.add(DbAccess.manager.getCriteriaBuilder().equal(root.get("action"), LogAction.CHANGEMENT_INTENSITE_FEU));
        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true).orderBy(cb.desc(root.get("id")));
        var logs = DbAccess.manager.createQuery(cq).getResultList();
        if (logs.isEmpty())
        {
            return "0";
        }
        return logs.get(0).getValue();
    }


}
