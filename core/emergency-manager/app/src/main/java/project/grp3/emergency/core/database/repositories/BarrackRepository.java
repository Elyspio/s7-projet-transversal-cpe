package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.entities.BarrackEntity;
import project.grp3.emergency.web.resource.BarrackRessource;

public class BarrackRepository extends Repository<BarrackEntity>
{
public BarrackRepository()
        {
        super(BarrackEntity.class);
        }
}
