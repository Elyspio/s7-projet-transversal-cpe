package project.grp3.simulator.core.database.repositories;

import project.grp3.simulator.core.database.entities.SensorEntity;

public class SensorRepository extends Repository<SensorEntity>
{
    public SensorRepository()
    {
        super(SensorEntity.class);
    }
}
