package project.grp3.emergency.core.services;

import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.api.truck.model.*;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.enums.LogAction;
import project.grp3.emergency.core.database.enums.TruckTravelState;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class FireService extends Services.Service
{

    FireService(){
        Logger logger = Logger.getLogger(FireService.class.getName());
    }
    
    public boolean handleFire(Long sensorId, Long fireTypeId, Integer intensity) throws IOException {
        //var fire = new FireEntity();
        //Get The sensor Id linked to the fire
        var api = Apis.getTruckApp();
        var s = Database.sensorRepository.getOneById(sensorId);
        boolean exist = Database.fireRepository.isExist(s);
        if (exist)
        {
            //If the fire already exist, add a log lign to indicate the new intensity
            var fire = Database.fireRepository.getActifBySensorId(s);
            var resource = Database.resourceRepository.getOne(fire.getRessource().getId());
            Database.logRepository.create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            //if Intensity is 0 the nthe fire is dead, call back thr truck to the Barrack
            if (intensity == 0)
            {
                fire.setEndDate(Date.from(Instant.now()));
                Database.fireRepository.update(fire);
                //TODO Faire l'appel vers le rapellage de camion
                api.resourceBack(BigDecimal.valueOf(resource.getId()));
            }
        }
        else
        {
            //Create a new fire and send ressources
            var fire = Database.fireRepository.create(sensorId, fireTypeId);
            var resource = Services.resource.create(fire, intensity);
            //var resource = Database.resourceRepository.getOne(fire.getId());
            Database.logRepository.create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            Database.logRepository.create(intensity, resource, LogAction.ENVOIE_DE_CAMION_VERS_FEU);


            //Call the truc app to notice it to handle the ressource mouvement.
            var m = new MovementModel();
            var lP = new ArrayList<FiremanModel>();
            var fMod = new FiremanModel();
            var j = 0;
            var i = 0;
            for (FiremanEntity f : resource.getFiremen())
            {
                fMod.setId(BigDecimal.valueOf(f.getId()));
                fMod.setFireTruckId(BigDecimal.valueOf(resource.getFireTrucks().get(i).getId()));
                fMod.setResourceId(BigDecimal.valueOf(resource.getId()));
                lP.add(fMod);
                j++;
                if (j == resource.getFireTrucks().get(i).getType().getCapacity())
                {
                    i++;
                }
            }
            var locationStart = new LocationModel();
            var locationDest = new LocationModel();
            var locations = new LocationsModel();
            locationStart.setLatitude(BigDecimal.valueOf(45.7607));
            locationStart.setLongitude(BigDecimal.valueOf(4.8520));
            locationDest.setLatitude(BigDecimal.valueOf(45.7841));
            locationDest.setLongitude(BigDecimal.valueOf(4.8698));
            locations.setDest(locationDest);
            locations.setStart(locationStart);
            var lT = new ArrayList<TruckModel>();
            var tMod = new TruckModel();
            for (FireTruckEntity t : resource.getFireTrucks())
            {
                tMod.current(locationStart);
                tMod.setId(BigDecimal.valueOf(t.getId()));
                tMod.setDest(locationDest);
                tMod.setStart(locationStart);
                tMod.setResourceId(BigDecimal.valueOf(resource.getId()));
                tMod.setTravelState(BigDecimal.valueOf(resource.getTravelState().ordinal()));
                tMod.setSpeed(BigDecimal.valueOf(t.getType().getSpeed()));
                lT.add(tMod);
            }


            m.setFiremen(lP);
            m.setTrucks(lT);
            m.setLocations(locations);
            //logger.info("I will send the ressources to the Truck Appp");
            api.resourceSend(m).execute();
        }
        return exist;
    }

}
