package project.grp3.emergency.web.Service;

import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.api.truck.model.MovementModel;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.enums.LogAction;

public class FireService {

    public static boolean handleFire(Long sensorId,Long fireTypeId,Integer intensity){
        //var fire = new FireEntity();
        if(Database.fireRepository.isExist(sensorId)){
            var id = Database.fireRepositiry.getActifBySensorId(sensorId).getId();
            var resource = Database.resourceRepository.getOne(id);
            var logNewFire = Database.logRepository.create(intensity,resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            return true;
        }
        else {
            var fire = Database.fireRepository.create(sensorId,fireTypeId);
            var resource = Database.resourceRepository.create(fire,intensity);
            //var resource = Database.resourceRepository.getOne(fire.getId());
            var logNewFire = Database.logRepository.create(intensity,resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            var logSendTruck = Database.logRepository.create(intensity,resource, LogAction.ENVOIE_DE_CAMION_VERS_FEU);
            //var api = Apis.getTruckApp();
            //var m = new MovementModel();
            //TODO FAIRE LE POUTAIN DE MOVEMENT
            //api.resourceSend(m);
        }
        return false;
    }

}
