package project.grp3.emergency.web.service;

import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.enums.LogAction;

public class FireService
{

    public static boolean handleFire(Long sensorId, Long fireTypeId, Integer intensity)
    {
        //var fire = new FireEntity();
        boolean exist = Database.fireRepository.isExist(sensorId);
        if (exist)
        {
            var fire = Database.fireRepository.getActifBySensorId(sensorId);
            var resource = Database.resourceRepository.getOne(fire.getRessource().getId());
            Database.logRepository.create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
        }
        else
        {
            var fire = Database.fireRepository.create(sensorId, fireTypeId);
            var resource = Database.resourceRepository.create(fire, intensity);
            //var resource = Database.resourceRepository.getOne(fire.getId());
            Database.logRepository.create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            Database.logRepository.create(intensity, resource, LogAction.ENVOIE_DE_CAMION_VERS_FEU);
            //var api = Apis.getTruckApp();
            //var m = new MovementModel();
            //TODO FAIRE LE POUTAIN DE MOVEMENT
            //api.resourceSend(m);
        }
        return exist;
    }

}
