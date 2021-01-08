package project.grp3.simulator.core.services;

import project.grp3.simulator.core.api.Apis;
import project.grp3.simulator.core.api.emergency.model.FireTruck;
import project.grp3.simulator.core.api.emergency.model.ResourceGetResource;
import project.grp3.simulator.core.api.emergency.model.TruckType;
import project.grp3.simulator.core.api.microbitsimulator.model.PostFireModel;
import project.grp3.simulator.core.database.Database;
import project.grp3.simulator.core.database.entities.FireEntity;
import project.grp3.simulator.core.database.entities.SensorEntity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FireService extends Services.Service
{

    FireService()
    {
        logger = Logger.getLogger(FireService.class.getName());
    }


    public Long getNewFireIntencity(FireEntity fire)
    {

        logger.info("Calculation of new fire intensity for fire with " + fire.getId());

        SensorEntity sensor = fire.getSensor();
        try
        {
            var result = Apis.geocoding().search(sensor.getStreet(), sensor.getPostalCode(), "json").execute().body();
            if (result != null)
            {
                var location = result.get(0);
                var truckIds = Apis.truck().resourceNear(
                        BigDecimal.valueOf(Double.parseDouble(location.lon)),
                        BigDecimal.valueOf(Double.parseDouble(location.lat))
                ).execute().body();


                if (truckIds != null)
                {
                    var resources = truckIds.stream().map(id -> {
                        try
                        {
                            return Apis.emergency().resource().getResource(id.longValue()).execute().body();
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        return null;
                    }).collect(Collectors.toList());


                    var intensity = fire.getIntensity() + 2;
                    var fireType = fire.getType();

                    for (ResourceGetResource res : resources)
                    {
                        var trucks = res.getTrucks();
                        for (FireTruck t : trucks)
                        {
                            TruckType tType = t.getType();
                            if (tType.getFireTypes().stream().anyMatch(type -> type.getId().equals(fireType.getId())))
                            {
                                intensity -= (long) (tType.getVolume() / 10);
                            }
                        }
                    }

                    logger.info("New fire intensity " + intensity);


                    return intensity;
                }
                else
                {
                    throw new Exception("Could not find a location for sensor: " + sensor.getId());
                }


            }
            throw new Exception("Could not find a location for sensor: " + sensor.getId());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return fire.getIntensity();
    }


    public void changeFireIntensity(FireEntity fire, Long intensity)
    {
        fire.setIntensity(intensity);
        Database.fireRepository.update(fire);
    }


    public FireEntity createFireEntity(Long sensorId, Long intensity, Long fireTypeId)
    {
        var entity = new FireEntity();
        entity.setIntensity(intensity);
        entity.setDetectionDate(new Date());
        entity.setType(Database.fireTypeRepository.getById(fireTypeId));
        entity.setSensor(Database.sensorRepository.getById(sensorId));
        entity = createFire(entity);
        return entity;
    }


    public List<FireEntity> getActiveFire()
    {
        return Database.fireRepository.getActiveFire();
    }

    public void createRandomFire()
    {
        Random rand = new Random();

        var sensors = Database.sensorRepository.getAll();
        var sensor = sensors.get(rand.nextInt(sensors.size()));

        var fireTypes = Database.fireTypeRepository.getAll();
        var fireType = fireTypes.get(rand.nextInt(fireTypes.size()));

        var fire = new FireEntity();
        fire.setSensor(sensor);
        fire.setType(fireType);
        fire.setIntensity((long) rand.nextInt(201));

        createFire(fire);


    }


    private FireEntity createFire(FireEntity fire)
    {
        var created = Database.fireRepository.create(fire);

        try
        {
            Apis.microbit().fireNewFire(new PostFireModel()
                    .fireTypeId(BigDecimal.valueOf(created.getType().getId()))
                    .intensity(BigDecimal.valueOf(created.getIntensity()))
                    .sensorId(BigDecimal.valueOf(created.getSensor().getId()))
            ).execute();
        }
        catch (IOException e)
        {
            System.err.println("FireService.createFire: Error in microbit.fireNewFire action");
            e.printStackTrace();
        }

        return created;
    }


    //  public void createFire
}
