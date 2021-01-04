package project.grp3.simulator.core.database;

import project.grp3.simulator.core.database.repository.FireRepository;
import project.grp3.simulator.core.database.repository.FireTypeRepository;
import project.grp3.simulator.core.database.repository.SensorRepository;

public class Database {

    public final static FireRepository fireRepositiry = new FireRepository();
    public final static FireTypeRepository fireTypeRepositiry = new FireTypeRepository();
    public final static SensorRepository sensorRepository = new SensorRepository();
    private Database() {
    }
}
