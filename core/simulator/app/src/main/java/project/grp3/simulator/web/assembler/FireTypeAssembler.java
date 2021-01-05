package project.grp3.simulator.web.assembler;

import project.grp3.simulator.core.database.entities.FireEntity;
import project.grp3.simulator.core.database.entities.FireTypeEntity;
import project.grp3.simulator.core.database.entities.SensorEntity;
import project.grp3.simulator.web.data.FireType;

import java.util.Collections;
import java.util.stream.Collectors;

public class FireTypeAssembler extends BaseAssembler<FireTypeEntity, FireType>
{
    @Override
    public FireType toData(FireTypeEntity e)
    {
        return new FireType(
                e.getId(),
                e.getLabel(),
                e.getDescription(),
                e.getFires().stream().map(FireEntity::getId).collect(Collectors.toList()),
                e.getSensors().stream().map(SensorEntity::getId).collect(Collectors.toList())
        );
    }

    @Override
    public FireTypeEntity toEntity(FireType d)
    {
        return null;
    }
}
