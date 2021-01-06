package project.grp3.emergency.core.api.emergency.api;

import retrofit2.Call;
import retrofit2.http.POST;

public interface FiresApi
{
    /**
     * get notice that a ressource is back
     *
     * @param sensorId   (optional)
     * @param intensity  (optional)
     * @param fireTypeId (optional)
     * @return Call&lt;Void&gt;
     */
    @retrofit2.http.Multipart
    @POST("fires")
    Call<Void> newFire(
            @retrofit2.http.Part("sensorId") Long sensorId, @retrofit2.http.Part("intensity") Integer intensity, @retrofit2.http.Part("fireTypeId") Long fireTypeId
    );

}