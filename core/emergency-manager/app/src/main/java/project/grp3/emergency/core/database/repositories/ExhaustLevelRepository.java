package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.entities.ExhaustLevelEntity;
import project.grp3.emergency.core.database.enums.ExhaustLevel;

public class ExhaustLevelRepository extends Repository<ExhaustLevelEntity>
{
    public ExhaustLevelRepository()
    {
        super(ExhaustLevelEntity.class);
    }

    public ExhaustLevelEntity fromCoreId(ExhaustLevel coreId)
    {
        return super
                .getAll()
                .stream()
                .filter(el -> el.getCoreId().equals(coreId))
                .findFirst()
                .get();
    }


}
