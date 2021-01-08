package project.grp3.simulator.core.api;

import project.grp3.simulator.config.NetworkConfig;
import project.grp3.simulator.core.api.emergency.api.FireTruckApi;
import project.grp3.simulator.core.api.emergency.api.ResourcesApi;
import project.grp3.simulator.core.api.geocoding.GeocodingApi;
import project.grp3.simulator.core.api.microbitsimulator.api.FireApi;
import project.grp3.simulator.core.api.truck.api.ResourceApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis
{

    private static final Apis instance = new Apis();

    private final FireApi microbit;
    private final ResourceApi truck;
    private final GeocodingApi geocoding;
    private final EmergencyApi emergency;

    private Apis()
    {

        NetworkConfig config = NetworkConfig.getInstance();

        Retrofit microbitLink = createBuilder(config.microbitSimulatorServer().toString());
        Retrofit truckServer = createBuilder(config.truck().toString());
        Retrofit geocodingServer = createBuilder("https://nominatim.openstreetmap.org/");

        microbit = microbitLink.create(FireApi.class);
        truck = truckServer.create(ResourceApi.class);
        geocoding = geocodingServer.create(GeocodingApi.class);
        emergency = new EmergencyApi(config);
    }

    public static FireApi microbit()
    {
        return instance.microbit;
    }

    public static ResourceApi truck()
    {
        return instance.truck;
    }

    private static Retrofit createBuilder(String endpoint)
    {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static EmergencyApi emergency()
    {
        return instance.emergency;
    }

    public static GeocodingApi geocoding()
    {
        return instance.geocoding;
    }


    public static class EmergencyApi
    {
        private final FireTruckApi truck;
        private final ResourcesApi resource;

        public EmergencyApi(NetworkConfig config)
        {
            truck = createBuilder(config.emergencyServer().toString()).create(FireTruckApi.class);
            resource = createBuilder(config.emergencyServer().toString()).create(ResourcesApi.class);
        }

        public FireTruckApi truck()
        {
            return truck;
        }

        public ResourcesApi resource()
        {
            return resource;
        }
    }


}
