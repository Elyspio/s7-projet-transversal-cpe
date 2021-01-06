package project.grp3.emergency.core.api.emergency.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FireTruckApi
{
    /**
     * get all fireTruck
     *
     * @return Call&lt;Void&gt;
     */
    @GET("fireTruck")
    Call<Void> fireTruck();


    /**
     * get one fireTruck by id
     *
     * @param id (required)
     * @return Call&lt;Void&gt;
     */
    @GET("fireTruck/{id}")
    Call<Void> fireTruckById(
            @retrofit2.http.Path("id") Long id
    );

}