package project.grp3.simulator.core.api.emergency.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HelloApi {
  /**
   * test the world
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("hello-world")
  Call<Void> hello();
    

  /**
   * test the microbit (simulator) link
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("hello-world/link")
  Call<Void> testLink();
    

}