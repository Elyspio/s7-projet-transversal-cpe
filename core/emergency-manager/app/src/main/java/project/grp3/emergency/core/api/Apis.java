package project.grp3.simulator.core.api;

import project.grp3.simulator.config.NetworkConfig;
import project.grp3.simulator.core.api.fire.api.FireApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis {


    /**
     * Instance unique non préinitialisée
     */
    private static final Apis instance = new Apis();
    private final FireApi fire;

    /**
     * Constructeur privé
     */
    private Apis() {

        Retrofit microbitLink = createBuilder(NetworkConfig.getInstance().getMicrobitSimulatorLink().toString());

        fire = microbitLink.create(FireApi.class);
    }

    public static FireApi getFire() {
        return instance.fire;
    }

    private Retrofit createBuilder(String endpoint) {
        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
