package project.grp3.emergency.core.database.repositories;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;

import javax.xml.crypto.Data;

public class FireRepository extends Repository<FireEntity> {
    public FireRepository() {
        super(FireEntity.class);
    }

    public FireEntity create(Long sensorId,Integer intensity,Long fireTypeId){
        var fire = new FireEntity();
        fire.setSensor(Database.sensorRepository.getById(sensorId));
        fire.setType(Database.fireTypeRepositiry.getById(fireTypeId));
        return super.create(fire);
    }

}
