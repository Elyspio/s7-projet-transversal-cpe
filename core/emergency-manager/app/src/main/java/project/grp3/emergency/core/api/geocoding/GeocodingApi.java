package project.grp3.emergency.core.api.geocoding;

import project.grp3.emergency.core.api.geocoding.model.SearchLocationResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;


public interface GeocodingApi
{
    /**
     * get all firemen
     *
     * @return Call&lt;Void&gt;
     */
    @GET("search")
    Call<List<SearchLocationResult>> search(@Query("street") String street, @Query("postalcode") String postalcode, @Query("format") String format);


}
