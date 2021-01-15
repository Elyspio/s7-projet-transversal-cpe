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
import java.util.stream.Collectors;

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
        fire.setSensor(Database.sensorRepository().getById(sensorId));
        fire.setType(Database.fireTypeRepository().getById(fireTypeId));
        return super.create(fire);
    }

    public boolean isExist(SensorEntity sensor)
    {
        return getActiveBySensorId(sensor) != null;
    }

    public FireEntity getActiveBySensorId(SensorEntity sensor)
    {
        return getActive()
                .stream()
                .filter(f -> f.getSensor().equals(sensor))
                .findFirst()
                .orElse(null);
    }

    public List<FireEntity> getActive()
    {

        return getAll()
                .stream()
                .filter(f -> f.getEndDate() == null)
                .collect(Collectors.toList());
    }

    public FireEntity update(FireEntity item)
    {
        return super.update(item);
    }

}
