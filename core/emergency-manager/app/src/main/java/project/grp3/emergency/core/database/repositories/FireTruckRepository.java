package project.grp3.emergency.core.database.repositories;


import project.grp3.emergency.core.database.entities.FireTruckEntity;

import java.util.List;

public class FireTruckRepository extends Repository<FireTruckEntity> {
    public FireTruckRepository() {
        super(FireTruckEntity.class);
    }

    public List<FireTruckEntity> getAll() {
        return super.getAll();
    }
    public FireTruckEntity getById(Long id) {
        return super.getById(id);
    }
    /*public List<FireTruckEntity> getAllArrived() {
        manager = sessionFactory.createEntityManager();
        var cq = manager.getCriteriaBuilder().createQuery(entity);
        var all = cq.select(cq.from(entity));
        return manager.createQuery(cq).getResultList();
    }*/

}
