package project.grp3.simulator.core.api.emergency.api;


import retrofit2.Call;
import retrofit2.http.GET;

public interface FiremenApi
{
    /**
     * get all firemen
     *
     * @return Call&lt;Void&gt;
     */
    @GET("firemen")
    Call<Void> firemen();


    /**
     * get one fireman by id
     *
     * @param id (required)
     * @return Call&lt;Void&gt;
     */
    @GET("firemen/{id}")
    Call<Void> firemenById(
            @retrofit2.http.Path("id") Long id
    );

}