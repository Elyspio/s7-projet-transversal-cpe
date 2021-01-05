package project.grp3.simulator.web.data;

public class Location
{
    private Long latitude;
    private Long longitude;

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
