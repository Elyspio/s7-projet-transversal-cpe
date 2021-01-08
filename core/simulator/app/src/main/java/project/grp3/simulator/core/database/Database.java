package project.grp3.simulator.core.database;

import project.grp3.simulator.core.database.repositories.FireRepository;
import project.grp3.simulator.core.database.repositories.FireTypeRepository;
import project.grp3.simulator.core.database.repositories.SensorRepository;

public class Database
{

    public final static FireRepository fireRepository = new FireRepository();
    public final static FireTypeRepository fireTypeRepository = new FireTypeRepository();
    public final static SensorRepository sensorRepository = new SensorRepository();

    private Database()
    {
    }
}
