package project.grp3.emergency.core.api.emergency.api;

import retrofit2.Call;
import retrofit2.http.PUT;

public interface ResourcesApi
{
    /**
     * get notice that a ressource is back
     *
     * @param ressourceId (optional)
     * @return Call&lt;Void&gt;
     */
    @retrofit2.http.Multipart
    @PUT("resources")
    Call<Void> ressourceBack(
            @retrofit2.http.Part("ressourceId") Long ressourceId
    );

}