package project.grp3.simulator.web.data;

import java.util.List;

public class Sensor
{
    private final Long id;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String country;
    private final String street;
    private final List<Long> fireIds;


    public Sensor(Long id, String city, String state, String postalCode, String country, String street, List<Long> fireIds)
    {
        this.id = id;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.street = street;
        this.fireIds = fireIds;
    }

    public Long getId()
    {
        return id;
    }

    public String getState()
    {
        return state;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public List<Long> getFireIds()
    {
        return fireIds;
    }
}