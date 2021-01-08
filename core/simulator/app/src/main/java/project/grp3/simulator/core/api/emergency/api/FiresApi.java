package project.grp3.simulator.core.api.emergency.api;


import project.grp3.simulator.core.api.emergency.model.FireResourceNewFire;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FiresApi
{
    /**
     * add or update a fire
     *
     * @param body (optional)
     * @return Call&lt;Void&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("fires")
    Call<Void> newFire(
            @retrofit2.http.Body FireResourceNewFire body
    );

}