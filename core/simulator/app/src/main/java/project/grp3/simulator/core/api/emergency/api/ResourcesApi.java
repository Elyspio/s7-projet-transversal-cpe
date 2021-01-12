package project.grp3.simulator.core.api.emergency.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import project.grp3.simulator.core.api.emergency.model.EntityNotFoundResponse;
import project.grp3.simulator.core.api.emergency.model.ResourceGetResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResourcesApi {
  /**
   * get a resource from its id
   * 
   * @param id  (required)
   * @return Call&lt;ResourceGetResource&gt;
   */
  @GET("resources/{id}")
  Call<ResourceGetResource> getResource(
            @retrofit2.http.Path("id") Long id            
  );

  /**
   * get notice that a resource is back
   * 
   * @param resourceId  (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.Multipart
  @PUT("resources")
  Call<Void> resourceBack(
                        @retrofit2.http.Part("resourceId") Long resourceId
  );

}