package project.grp3.emergency.web.service;

import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.api.truck.model.*;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.SensorEntity;
import project.grp3.emergency.core.database.enums.LogAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class FireService
{

    public static boolean handleFire(Long sensorId, Long fireTypeId, Integer intensity)
    {
        //var fire = new FireEntity();
        var api = Apis.getTruckApp();
        var s = Database.sensorRepository.getOneById(sensorId);
        boolean exist = Database.fireRepository.isExist(s);
        if (exist)
        {
            var fire = Database.fireRepository.getActifBySensorId(s);
            var resource = Database.resourceRepository.getOne(fire.getRessource().getId());
            Database.logRepository.create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            if(intensity == 0){
                fire.setEndDate(Date.from(Instant.now()));
                Database.fireRepository.update(fire);
                //TODO Faire l'appel vers le rapellage de camion
                api.resourceBack(BigDecimal.valueOf(resource.getId()));
            }
        }
        else
        {
            var fire = Database.fireRepository.create(sensorId, fireTypeId);
            var resource = Database.resourceRepository.create(fire, intensity);
            //var resource = Database.resourceRepository.getOne(fire.getId());
            Database.logRepository.create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            Database.logRepository.create(intensity, resource, LogAction.ENVOIE_DE_CAMION_VERS_FEU);
            var m = new MovementModel();
            var lP=new ArrayList<FiremanModel>();
            var fMod = new FiremanModel();
            var j =0;
            var i=0;
            for (FiremanEntity f:resource.getFiremen()) {
                fMod.setId(BigDecimal.valueOf(f.getId()));
                fMod.setFireTruckId(BigDecimal.valueOf(resource.getFireTrucks().get(i).getId()));
                fMod.setResourceId(BigDecimal.valueOf(resource.getId()));
                lP.add(fMod);
                j++;
                if(j==4){
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
            var lT=new ArrayList<TruckModel>();
            var tMod = new TruckModel();
            for (FireTruckEntity t:resource.getFireTrucks()) {
                tMod.current(locationStart);
                tMod.setId(BigDecimal.valueOf(t.getId()));
                tMod.setDest(locationDest);
                tMod.setResourceId(BigDecimal.valueOf(resource.getId()));
                tMod.setTravelState(BigDecimal.valueOf(Long.parseLong(String.valueOf(resource.getTravelState()))));
                tMod.setSpeed(BigDecimal.valueOf(t.getType().getSpeed()));
                lT.add(tMod);
                j++;
                if(j==4){
                    i++;
                }
            }


            m.setFiremen(lP);
            m.setTrucks(lT);
            m.setLocations(locations);

            api.resourceSend(m);
        }
        return exist;
    }

}
