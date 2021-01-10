package project.grp3.emergency.core.api;

import project.grp3.emergency.config.NetworkConfig;
import project.grp3.emergency.core.api.geocoding.GeocodingApi;
import project.grp3.emergency.core.api.truck.api.ResourceApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis
{


    /**
     * Instance unique non préinitialisée
     */
    private static final Apis instance = new Apis();

    private final ResourceApi truckApp;
    private final GeocodingApi geocodingApi;

    /**
     * Constructeur privé
     */
    private Apis()
    {
        Retrofit truckServerLink = createBuilder(NetworkConfig.getInstance().getTruckApp().toString());
        truckApp = truckServerLink.create(ResourceApi.class);

        geocodingApi = createBuilder("https://nominatim.openstreetmap.org/").create(GeocodingApi.class);
    }

    public static ResourceApi truck()
    {
        return instance.truckApp;
    }

    public static GeocodingApi geocoding()
    {
        return instance.geocodingApi;
    }

    private Retrofit createBuilder(String endpoint)
    {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
