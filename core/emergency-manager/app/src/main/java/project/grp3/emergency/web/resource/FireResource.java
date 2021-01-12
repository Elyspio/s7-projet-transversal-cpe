package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.LocationEntity;
import project.grp3.emergency.core.database.entities.SensorEntity;
import project.grp3.emergency.core.services.Services;
import project.grp3.emergency.web.resource.models.FireResourceNewFire;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;


@Path("/fires")
@Api(value = "fires")
public class FireResource
{

    @POST()
    @ApiOperation(value = "add or update a fire")
    @Consumes("application/json")
    @Produces("application/json")
    public Response newFire(FireResourceNewFire params)
    {

        try
        {
            boolean fire = Services.fire().handleFire(params.sensorId, params.fireTypeId, params.intensity);

            if (fire)
            {
                return Response
                        .status(Response.Status.CREATED)
                        .build();
            }
            else
            {
                return Response
                        .status(204)
                        .build();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
            return Response.serverError().entity(e).build();
        }


    }

    @GET
    @ApiOperation(value = "Returns the list of fires ")
    @ApiResponses(
            @ApiResponse(code = 500, response = IOException.class, message = "Thrown on network issue")
    )
    @Produces("application/json")
    @Path("/firesLocations")
    public Response fires() throws IOException {
        var fires = Database.fireRepository().getActive();
        var locations = new ArrayList<LocationEntity>();
        SensorEntity sensor = null;
        for (FireEntity fire: fires) {
            sensor = fire.getSensor();
            var result = Apis.geocoding().search(sensor.getStreet(), sensor.getPostalCode(), "json").execute().body();
            if (result != null) {
                var location = result.get(0);
                locations.add(new LocationEntity((Double.parseDouble(location.lat)),Double.parseDouble(location.lon)));
            }
        }
        return Response
                .status(Response.Status.OK)
                .entity(locations)
                .build();

    }

}
