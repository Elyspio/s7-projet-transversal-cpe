package project.grp3.emergency.core.database;

import project.grp3.emergency.core.database.repositories.*;

public class Database
{

    public final static FireTypeRepository fireTypeRepository = new FireTypeRepository();
    public final static SensorRepository sensorRepository = new SensorRepository();
    public final static FiremanRepository firemanRepository = new FiremanRepository();
    public final static FireTruckRepository fireTruckRepository = new FireTruckRepository();
    public final static ResourceRepository resourceRepository = new ResourceRepository();
    public final static FireRepository fireRepository = new FireRepository();
    public final static LogRepository logRepository = new LogRepository();

    private Database()
    {
    }

    public static void init()
    {
    }
}
