package project.grp3.simulator.core.api.microbitsimulator.api;


import project.grp3.simulator.core.api.microbitsimulator.model.PostFireModel;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FireApi
{
    /**
     * Send a new or updated fire to the gateway
     *
     * @param body (optional)
     * @return Call&lt;String&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("fires")
    Call<Void> fireNewFire(@retrofit2.http.Body PostFireModel body);

}