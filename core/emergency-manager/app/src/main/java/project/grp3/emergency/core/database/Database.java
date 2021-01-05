package project.grp3.emergency.core.database;

import project.grp3.emergency.core.database.repositories.*;

public class Database {

    public final static FireRepository fireRepositiry = new FireRepository();
    public final static FireTypeRepository fireTypeRepositiry = new FireTypeRepository();
    public final static SensorRepository sensorRepository = new SensorRepository();
    public final static FiremanRepository firemanRepository = new FiremanRepository();
    public final static FireTruckRepository fireTruckRepository = new FireTruckRepository();
    public final static ResourceRepository resourceRepository = new ResourceRepository();
    public final static FireRepository fireRepository = new FireRepository();

    private Database() {
    }
}
