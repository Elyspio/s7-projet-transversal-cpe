package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.entities.LogEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.LogAction;

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


}
