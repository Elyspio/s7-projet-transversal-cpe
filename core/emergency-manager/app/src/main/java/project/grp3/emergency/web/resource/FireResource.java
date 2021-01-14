package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.api.geocoding.model.SearchLocationResult;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.ResourceEntity;
import project.grp3.emergency.core.database.entities.SensorEntity;
import project.grp3.emergency.core.exception.EntityNotFound;
import project.grp3.emergency.core.services.Services;
import project.grp3.emergency.web.entities.FireLocation;
import project.grp3.emergency.web.resource.models.FireResourceNewFire;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Path("/fires")
@Api(value = "fires")
public class FireResource
{

    @POST()
    @ApiOperation(value = "add or update a fire", response = Long.class)
    @Consumes("application/json")
    @Produces("application/json")
    public Response newFire(FireResourceNewFire params)
    {

        try
        {
            var entity = Services.fire().handleFire(params.sensorId, params.fireTypeId, params.intensity);

            return Response
                    .ok()
                    .entity(entity.getId())
                    .build();
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
    public Response fires()
    {
        var fires = Database.fireRepository().getActive();

        var locations = new ArrayList<FireLocation>();
        for (var fire : fires)
        {
            SensorEntity sensor;
            String intensity;

            sensor = fire.getSensor();
            List<SearchLocationResult> result;
            try
            {
                result = Apis.geocoding().search(sensor.getStreet(), sensor.getPostalCode(), "json").execute().body();

                if (result != null)
                {
                    var location = result.get(0);
                    try
                    {
                        intensity = Database.logRepository().getLastIntensity(fire);
                        locations.add(new FireLocation((Double.parseDouble(location.lat)), Double.parseDouble(location.lon), Double.parseDouble(intensity)));
                    }
                    catch (EntityNotFound e)
                    {
                        if (e.getCls().equals(ResourceEntity.class))
                        {
                            Database.fireRepository().delete(fire);
                        }
                        System.err.println(e.getMessage());
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        return Response
                .status(Response.Status.OK)
                .entity(locations)
                .build();

    }

}
