package project.grp3.simulator.core.api.emergency.api;


import project.grp3.simulator.core.api.emergency.model.ResourceGetResource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface ResourcesApi
{
    /**
     * get a resource from its id
     *
     * @param id (required)
     * @return Call&lt;ResourceGetResource&gt;
     */
    @GET("resources/{id}")
    Call<ResourceGetResource> getResource(
            @retrofit2.http.Path("id") Long id
    );

    /**
     * get notice that a resource is back
     *
     * @param resourceId (optional)
     * @return Call&lt;Void&gt;
     */
    @retrofit2.http.Multipart
    @PUT("resources")
    Call<Void> resourceBack(
            @retrofit2.http.Part("resourceId") Long resourceId
    );

}