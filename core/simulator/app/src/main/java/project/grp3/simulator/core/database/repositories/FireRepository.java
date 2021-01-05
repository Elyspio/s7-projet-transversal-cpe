package project.grp3.simulator.core.database.repositories;

import project.grp3.simulator.core.database.entities.FireEntity;

public class FireRepository extends Repository<FireEntity> {
    public FireRepository() {
        super(FireEntity.class);
    }

}
