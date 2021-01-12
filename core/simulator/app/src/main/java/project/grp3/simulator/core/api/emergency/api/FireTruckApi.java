package project.grp3.simulator.core.api.emergency.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FireTruckApi {
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
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @GET("fireTruck/{id}")
  Call<Void> fireTruckById(
            @retrofit2.http.Path("id") Long id            
  );

}