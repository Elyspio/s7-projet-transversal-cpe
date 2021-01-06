package project.grp3.simulator.core.api.microbitsimulator.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import project.grp3.simulator.core.api.microbitsimulator.model.PostFireModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FireApi {
  /**
   * 
   * Send a new or updated fire to the gateway
   * @param body  (optional)
   * @return Call&lt;String&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("fires")
  Call<Void> fireNewFire(
                    @retrofit2.http.Body PostFireModel body    
  );

}