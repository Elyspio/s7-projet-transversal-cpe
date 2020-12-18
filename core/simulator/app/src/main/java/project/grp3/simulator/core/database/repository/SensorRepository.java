package project.grp3.simulator.core.database.repository;

import project.grp3.simulator.core.database.entity.Sensor;

import java.util.List;

public class SensorRepository extends Repository<Sensor> {
    public SensorRepository() {
        super(Sensor.class);
    }

    public List<Sensor> getAll() {
        return super.getAll();
    }

}
