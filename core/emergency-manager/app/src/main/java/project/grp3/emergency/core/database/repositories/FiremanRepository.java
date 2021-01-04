package project.grp3.emergency.core.database.repositories;


import project.grp3.emergency.core.database.entities.FiremanEntity;

import java.util.List;

public class FiremanRepository extends Repository<FiremanEntity> {
    public FiremanRepository() {
        super(FiremanEntity.class);
    }

    public List<FiremanEntity> getAll() {
        return super.getAll();
    }
    public FiremanEntity getById(Long id) {
        return super.getById(id);
    }

}
