package project.grp3.emergency.core.database.entities;

public class LocationEntity
{

    private final Double latitude;
    private final Double longitude;

    public LocationEntity(Double latitude, Double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }
}
