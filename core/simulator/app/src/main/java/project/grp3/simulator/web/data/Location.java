package project.grp3.simulator.web.data;

public class Location
{
    private final Long latitude;
    private final Long longitude;

    public Location(Long latitude, Long longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getLatitude()
    {
        return latitude;
    }

    public Long getLongitude()
    {
        return longitude;
    }
}
