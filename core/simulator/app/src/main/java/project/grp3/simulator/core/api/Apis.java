package project.grp3.simulator.core.api;

import project.grp3.simulator.config.NetworkConfig;
import project.grp3.simulator.core.api.microbitsimulator.api.FireApi;
import project.grp3.simulator.core.api.truck.api.ResourceApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis
{


    /**
     * Instance unique non préinitialisée
     */
    private static final Apis instance = new Apis();
    private final FireApi microbit;
    private final ResourceApi truck;

    /**
     * Constructeur privé
     */
    private Apis()
    {

        Retrofit microbitLink = createBuilder(NetworkConfig.getInstance().getMicrobitSimulatorLink().toString());
        Retrofit truckServer = createBuilder(NetworkConfig.getInstance().getMicrobitSimulatorLink().toString());

        microbit = microbitLink.create(FireApi.class);
        this.truck = truckServer.create(ResourceApi.class);


        // Apis.instance.truck.resourceSend()

    }

    public static FireApi getMicrobit()
    {
        return instance.microbit;
    }

    public static ResourceApi getTruck()
    {
        return instance.truck;
    }

    private Retrofit createBuilder(String endpoint)
    {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
