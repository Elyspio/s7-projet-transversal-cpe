package project.grp3.simulator.core.api.fire.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import project.grp3.simulator.core.api.fire.model.Forbidden;
import project.grp3.simulator.core.api.fire.model.PostFireModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FireApi {
  /**
   * 
   * 
   * @return Call&lt;String&gt;
   */
  @GET("core/fires/test")
  Call<String> fireGetAdmin();
    

  /**
   * 
   * Envoie d&#x27;un &#x27;nouveau&#x27; feu vers la passerelle
   * @param body  (optional)
   * @return Call&lt;PostFireModel&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/fires")
  Call<PostFireModel> fireNewFire(
                    @retrofit2.http.Body PostFireModel body    
  );

}