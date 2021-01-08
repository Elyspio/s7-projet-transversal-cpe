package project.grp3.simulator.core.api.geocoding.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchLocationResult
{
    @SerializedName("place_id")
    public int placeId;

    @SerializedName("licence")
    public String licence;

    @SerializedName("osm_type")
    public String osmType;

    @SerializedName("osm_id")
    public long osmId;

    @SerializedName("boundingbox")
    public List<String> boundingBox;

    @SerializedName("lat")
    public String lat;

    @SerializedName("lon")
    public String lon;

    @SerializedName("display_name")
    public String displayName;

    @SerializedName("type")
    public String type;

    @SerializedName("importance")
    public double importance;

    @SerializedName("address")
    public Address address;
}



