package project.grp3.emergency.web.Entity;

import project.grp3.emergency.core.database.entities.BarrackEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.entities.TruckTypeEntity;

import javax.persistence.*;
import java.util.List;

public class FireTruck {

    private Long id;

    private Long barrackId;

    private Long typeId;

    private List<Long> ressources;

    public FireTruck(Long id, Long barrackId, Long typeId, List<Long> ressources) {
        this.id = id;
        this.barrackId = barrackId;
        this.typeId = typeId;
        this.ressources = ressources;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Long> getRessources() {
        return ressources;
    }

    public void setRessources(List<Long> ressources) {
        this.ressources = ressources;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBarrackId() {
        return barrackId;
    }

    public void setBarrackId(Long barrackId) {
        this.barrackId = barrackId;
    }
}
