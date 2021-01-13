package project.grp3.emergency.core.database;

import project.grp3.emergency.core.database.repositories.*;

public class Database
{

    private static Database instance;
    private final FireTypeRepository fireTypeRepository;
    private final SensorRepository sensorRepository;
    private final FiremanRepository firemanRepository;
    private final FireTruckRepository fireTruckRepository;
    private final ResourceRepository resourceRepository;
    private final FireRepository fireRepository;
    private final LogRepository logRepository;
    private final BarrackRepository barrackRepository;
    private final ExhaustLevelRepository exhaustLevelRepository;

    private Database()
    {
        fireTypeRepository = new FireTypeRepository();
        sensorRepository = new SensorRepository();
        firemanRepository = new FiremanRepository();
        fireTruckRepository = new FireTruckRepository();
        resourceRepository = new ResourceRepository();
        fireRepository = new FireRepository();
        logRepository = new LogRepository();
        barrackRepository = new BarrackRepository();
        exhaustLevelRepository = new ExhaustLevelRepository();
    }

    public static void init()
    {
        if (instance == null)
        {
            Repository.DbAccess.init();
            instance = new Database();
        }
    }


    public static FireTypeRepository fireTypeRepository()
    {
        return instance.fireTypeRepository;
    }

    public static SensorRepository sensorRepository()
    {
        return instance.sensorRepository;
    }

    public static FiremanRepository firemanRepository()
    {
        return instance.firemanRepository;
    }

    public static FireTruckRepository fireTruckRepository()
    {
        return instance.fireTruckRepository;
    }

    public static ResourceRepository resourceRepository()
    {
        return instance.resourceRepository;
    }

    public static FireRepository fireRepository()
    {
        return instance.fireRepository;
    }

    public static LogRepository logRepository()
    {
        return instance.logRepository;
    }

    public static BarrackRepository barrackRepository()
    {
        return instance.barrackRepository;
    }

    public static ExhaustLevelRepository getExhaustLevelRepository()
    {
        return instance.exhaustLevelRepository;
    }
}
