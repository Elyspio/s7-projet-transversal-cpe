package project.grp3.emergency.core.api.truck.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.math.BigDecimal;
import project.grp3.emergency.core.api.truck.model.MovementModel;
import project.grp3.emergency.core.api.truck.model.TruckLocationEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResourceApi {
  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @POST("resources/{id}/back")
  Call<Void> resourceBack(
            @retrofit2.http.Path("id") BigDecimal id            
  );

  /**
   * 
   * Returns a list of trucks that are in operation
   * @return Call&lt;List&lt;TruckLocationEntity&gt;&gt;
   */
  @GET("resources/location")
  Call<List<TruckLocationEntity>> resourceLocation();
    

  /**
   * 
   * Returns a list of resource ids near a location
   * @param longitude  (optional)
   * @param latitude  (optional)
   * @return Call&lt;List&lt;BigDecimal&gt;&gt;
   */
  @GET("resources")
  Call<List<BigDecimal>> resourceNear(
        @retrofit2.http.Query("longitude") BigDecimal longitude                ,     @retrofit2.http.Query("latitude") BigDecimal latitude                
  );

  /**
   * 
   * 
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("resources/send")
  Call<Void> resourceSend(
                    @retrofit2.http.Body MovementModel body    
  );

}