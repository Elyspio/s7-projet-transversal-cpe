package project.grp3.simulator.web.assembler;

import project.grp3.simulator.core.database.entities.FireTypeEntity;
import project.grp3.simulator.core.database.entities.SensorEntity;
import project.grp3.simulator.web.data.Sensor;

import java.util.stream.Collectors;

public class SensorAssembler extends BaseAssembler<SensorEntity, Sensor>
{
    @Override
    public Sensor toData(SensorEntity e)
    {
        return new Sensor(
                e.getId(),
                e.getCity(),
                e.getState(),
                e.getPostalCode(),
                e.getCountry(),
                e.getStreet(),
                e.getFireTypes().stream().map(FireTypeEntity::getId).collect(Collectors.toList())
        );
    }

    @Override
    public SensorEntity toEntity(Sensor e)
    {
        return null;
    }
}
