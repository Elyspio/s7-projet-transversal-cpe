package project.grp3.simulator.core.api.geocoding.model;

import com.google.gson.annotations.SerializedName;

public class Address
{
    public String historic;
    public String road;
    public String suburb;
    public String city;
    public String state;
    public String postcode;
    public String country;

    @SerializedName("country_code")
    public String countryCode;
}
