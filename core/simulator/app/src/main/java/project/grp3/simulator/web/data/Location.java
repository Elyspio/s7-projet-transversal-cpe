package project.grp3.simulator.web.data;

public class Location
{
    private final Double latitude;
    private final Double longitude;
    private final Double intensity;

    public Location(Double latitude, Double longitude, Double intensity)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.intensity = intensity;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public Double getIntensity()
    {
        return intensity;
    }
}
