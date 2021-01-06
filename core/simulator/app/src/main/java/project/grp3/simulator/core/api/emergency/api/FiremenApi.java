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

public interface FiremenApi {
  /**
   * get all firemen
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("firemen")
  Call<Void> firemen();
    

  /**
   * get one fireman by id
   * 
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @GET("firemen/{id}")
  Call<Void> firemenById(
            @retrofit2.http.Path("id") Long id            
  );

}