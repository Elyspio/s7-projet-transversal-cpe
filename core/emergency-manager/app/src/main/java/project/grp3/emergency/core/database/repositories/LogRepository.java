package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.LogEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.LogAction;
import project.grp3.emergency.core.exception.EntityNotFound;

import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

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
        logEntity.setDate(new Date());
        return super.create(logEntity);
    }

    public String getLastIntensity(FireEntity fire) throws EntityNotFound
    {

        if (fire.getResource() == null)
        {
            throw new EntityNotFound("There is no resource for this fire: fire_id=" + fire.getId(), ResourceEntity.class);
        }

        final var logs = this.getAll()
                .stream()
                .filter(log -> log.getResource()
                        .getFire()
                        .getId()
                        .equals(fire.getId())
                        && log
                        .getAction()
                        .equals(LogAction.CHANGEMENT_INTENSITE_FEU)
                );

        final var sorted = logs.sorted(Comparator.comparing(LogEntity::getDate).reversed()).collect(Collectors.toList());

        if (sorted.isEmpty())
        {
            throw new EntityNotFound("There is no log for this fire: fire_id=" + fire.getId(), LogEntity.class);
        }

        return sorted.get(0).getValue();


//        CriteriaBuilder cb = DbAccess.manager.getCriteriaBuilder();
//        var cq = cb.createQuery(LogEntity.class);
//        var root = cq.from(LogEntity.class);
//        List<Predicate> criteres = new ArrayList<>();
//        criteres.add(DbAccess.manager.getCriteriaBuilder().equal(root.get("resource"), fire.getResource()));
//        criteres.add(DbAccess.manager.getCriteriaBuilder().equal(root.get("action"), LogAction.CHANGEMENT_INTENSITE_FEU));
//        cq.select(root).where(criteres.toArray(Predicate[]::new)).distinct(true).orderBy(cb.desc(root.get("id")));
//        var logs = DbAccess.manager.createQuery(cq).getResultList();

    }


}
