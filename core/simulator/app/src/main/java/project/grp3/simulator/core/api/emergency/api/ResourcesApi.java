package project.grp3.emergency.core.api.emergency.api;

import project.grp3.emergency.core.api.emergency.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResourcesApi {
  /**
   * get notice that a ressource is back
   * 
   * @param ressourceId  (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.Multipart
  @PUT("resources")
  Call<Void> ressourceBack(
                        @retrofit2.http.Part("ressourceId") Long ressourceId
  );

}