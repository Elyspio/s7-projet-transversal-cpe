package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.entities.SensorEntity;

import java.util.List;

public class SensorRepository extends Repository<SensorEntity>
{
    public SensorRepository()
    {
        super(SensorEntity.class);
    }

    public List<SensorEntity> getAll()
    {
        return super.getAll();
    }

    public SensorEntity getOneById(Long id){ return super.get(id); }

}
