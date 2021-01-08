package project.grp3.emergency.web.resource.models;

import project.grp3.emergency.core.database.entities.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceGetResource
{

    public Long id;
    public List<Fireman> firemen;
    public List<FireTruck> trucks;
    public List<Barack> baracks;

    public static class Fireman
    {
        public Long id;
        public String name;
        public String lastname;
        public ExhaustLevel exhaustLevel;
        public Long barrackId;

        public Fireman(Long id, String name, String lastname, ExhaustLevel exhaustLevel, Long barrackId)
        {
            this.id = id;
            this.name = name;
            this.lastname = lastname;
            this.exhaustLevel = exhaustLevel;
            this.barrackId = barrackId;
        }

        public static Fireman from(FiremanEntity entity)
        {
            return new Fireman(
                    entity.getId(),
                    entity.getName(),
                    entity.getLastname(),
                    ExhaustLevel.from(entity.getExhaustLevel()),
                    entity.getBarrack().getId()
            );
        }

    }

    public static class FireTruck
    {
        public Long barrackId;
        public TruckType type;
        public Long id;

        public FireTruck(Long id, Long barrackId, TruckType type)
        {
            this.barrackId = barrackId;
            this.type = type;
            this.id = id;
        }

        public static FireTruck from(FireTruckEntity entity)
        {
            return new FireTruck(
                    entity.getId(),
                    entity.getBarrack().getId(),
                    TruckType.from(entity.getType())
            );
        }
    }

    public static class ExhaustLevel
    {

        public Long id;
        public String label;
        public Integer value;

        public ExhaustLevel(Long id, String label, Integer value)
        {
            this.id = id;
            this.label = label;
            this.value = value;
        }

        public static ExhaustLevel from(ExhaustLevelEntity entity)
        {
            return new ExhaustLevel(
                    entity.getId(),
                    entity.getLabel(),
                    entity.getValue()
            );
        }
    }

    public static class FireType
    {


        public Long id;
        public String label;
        public String description;

        public FireType(Long id, String label, String description)
        {
            this.id = id;
            this.label = label;
            this.description = description;
        }

        public static FireType from(FireTypeEntity entity)
        {
            return new FireType(
                    entity.getId(),
                    entity.getLabel(),
                    entity.getDescription()
            );
        }
    }

    public static class Barack
    {

        public Long id;
        public String city;
        public String state;
        public String postalCode;
        public String country;
        public String street;


        public Barack(Long id, String city, String state, String postalCode, String country, String street)
        {
            this.id = id;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.country = country;
            this.street = street;
        }

        public static Barack from(BarrackEntity entity)
        {
            return new Barack(
                    entity.getId(),
                    entity.getCity(),
                    entity.getState(),
                    entity.getPostalCode(),
                    entity.getCountry(),
                    entity.getStreet()
            );
        }
    }

    public static class TruckType
    {

        public final Long id;
        public final String label;
        public final int capacity;
        public final float volume;
        public final float speed;
        public final List<FireType> fireTypes;

        public TruckType(Long id, String label, int capacity, float volume, float speed, List<FireType> fireTypes)
        {
            this.id = id;
            this.label = label;
            this.capacity = capacity;
            this.volume = volume;
            this.speed = speed;
            this.fireTypes = fireTypes;
        }

        public static TruckType from(TruckTypeEntity entity)
        {
            return new TruckType(
                    entity.getId(),
                    entity.getLabel(),
                    entity.getCapacity(),
                    entity.getVolume(),
                    entity.getSpeed(),
                    entity.getFireTypes().stream().map(FireType::from).collect(Collectors.toList())
            );
        }
    }

}
