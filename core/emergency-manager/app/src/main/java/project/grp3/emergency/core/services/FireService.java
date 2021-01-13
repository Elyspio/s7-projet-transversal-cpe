package project.grp3.emergency.core.services;

import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.api.truck.model.FiremanModel;
import project.grp3.emergency.core.api.truck.model.LocationModel;
import project.grp3.emergency.core.api.truck.model.MovementModel;
import project.grp3.emergency.core.api.truck.model.TruckModel;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.FireTruckEntity;
import project.grp3.emergency.core.database.entities.FiremanEntity;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.enums.LogAction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FireService extends Services.Service
{

    FireService()
    {
        Logger logger = Logger.getLogger(FireService.class.getName());
    }

    public FireEntity handleFire(Long sensorId, Long fireTypeId, Integer intensity) throws IOException
    {
        //var fire = new FireEntity();
        //Get The sensor Id linked to the fire
        var api = Apis.truck();
        var s = Database.sensorRepository().getOneById(sensorId);
        boolean exist = Database.fireRepository().isExist(s);
        FireEntity fire;
        if (exist)
        {
            //If the fire already exist, add a log line to indicate the new intensity
            fire = Database.fireRepository().getActiveBySensorId(s);
            Long resourceId = fire.getResource().getId();
            ResourceEntity resource;
            if (resourceId == null)
            {
                resource = Database.resourceRepository().getByFire(fire);
            }
            else
            {
                resource = Database.resourceRepository().getOne(resourceId);
            }
            Database.logRepository().create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            //if Intensity is 0  when the fire is dead, call back thr truck to the Barrack
            if (intensity == 0)
            {
                fire.setEndDate(new Date());
                Database.fireRepository().update(fire);
                api.resourceBack(BigDecimal.valueOf(resource.getId())).execute();
            }
        }
        else
        {
            //Create a new fire and send resources
            fire = Database.fireRepository().create(sensorId, fireTypeId);
            var resource = Services.resource().create(fire, intensity);
            //var resource = Database.resourceRepository.getOne(fire.getId());
            Database.logRepository().create(intensity, resource, LogAction.CHANGEMENT_INTENSITE_FEU);
            Database.logRepository().create(intensity, resource, LogAction.ENVOIE_DE_CAMION_VERS_FEU);


            var geocodingApi = Apis.geocoding();

            //Call the truck app to notice it to handle the resource movement.
            var callModel = new MovementModel();

            callModel.setResourceId(BigDecimal.valueOf(resource.getId()));


            List<TruckModel> truckModels = resource.getFireTrucks().stream().map(truck -> {
                var model = new TruckModel();
                model.setId(BigDecimal.valueOf(truck.getId()));
                model.setSpeed(BigDecimal.valueOf(truck.getType().getSpeed()));
                var barrack = truck.getBarrack();
                var location = new LocationModel();

                try
                {
                    var locationData = geocodingApi.search(barrack.getStreet(), barrack.getPostalCode(), "json").execute().body().get(0);
                    location.setLatitude(BigDecimal.valueOf(Double.parseDouble(locationData.lat)));
                    location.setLongitude(BigDecimal.valueOf(Double.parseDouble(locationData.lon)));
                    model.setStart(location);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                return model;
            }).collect(Collectors.toList());


            List<FiremanModel> firemenModel = affectFiremanToTruck(resource.getFireTrucks(), resource.getFiremen());


            callModel.setFiremen(firemenModel);
            callModel.setTrucks(truckModels);

            LocationModel destLocation = new LocationModel();

            var destLocationData = geocodingApi.search(fire.getSensor().getStreet(), fire.getSensor().getPostalCode(), "json")
                    .execute()
                    .body()
                    .get(0);

            destLocation.setLatitude(BigDecimal.valueOf(Double.parseDouble(destLocationData.lat)));
            destLocation.setLongitude(BigDecimal.valueOf(Double.parseDouble(destLocationData.lon)));


            callModel.setDest(destLocation);

            api.resourceSend(callModel).execute();
        }
        return fire;
    }


    public List<FiremanModel> affectFiremanToTruck(List<FireTruckEntity> trucks, List<FiremanEntity> firemen)
    {
        var ret = new ArrayList<FiremanModel>();
        int truckIndex = 0;


        var associated = new HashMap<FireTruckEntity, Integer>();
        trucks.forEach(t -> associated.put(t, 0));


        var stack = new Stack<FiremanModel>();
        stack.addAll(firemen
                .stream()
                .map(f -> new FiremanModel().id(BigDecimal.valueOf(f.getId())))
                .collect(Collectors.toList())
        );


        while (!stack.isEmpty())
        {
            FireTruckEntity truck = trucks.get(truckIndex);
            var remainingSpace = truck.getType().getCapacity() - associated.get(truck);

            if (remainingSpace > 0)
            {
                FiremanModel fire = stack.pop().fireTruckId(BigDecimal.valueOf(truck.getId()));
                fire.fireTruckId(BigDecimal.valueOf(truck.getId()));
                ret.add(fire);
                associated.put(truck, associated.get(truck) + 1);
            }

            truckIndex = (truckIndex + 1) % trucks.size();

        }

        return ret;


    }


}
