package project.grp3.simulator.web.resource;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import project.grp3.simulator.core.api.Apis;
import project.grp3.simulator.core.api.microbitsimulator.model.PostFireModel;
import project.grp3.simulator.core.database.Database;
import project.grp3.simulator.core.database.entities.FireEntity;
import project.grp3.simulator.core.database.entities.SensorEntity;
import project.grp3.simulator.core.services.Services;
import project.grp3.simulator.web.data.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@Path("/resources")
@Api(value = "resources")
public class FireResource
{
    @POST
    @Operation(
            summary = "Create a fire on the simulator "
    )
    @Produces("application/json")
    @Path("/send")
    public Response send(
            @FormParam("sensorId") Long sensorId,
            @FormParam("intensity") Long intensity,
            @FormParam("fireTypeId") Long fireTypeId
    )
    {

        var newFire = Services.fire.createFireEntity(sensorId, intensity, fireTypeId);
        var model = new PostFireModel();
        model.setFireTypeId(BigDecimal.valueOf(newFire.getType().getId()));
        model.setIntensity(BigDecimal.valueOf(newFire.getIntensity()));
        model.setSensorId(BigDecimal.valueOf(newFire.getSensor().getId()));
        try
        {
            Apis.microbit().fireNewFire(model).execute();
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
        catch (IOException e)
        {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/fires")
    public Response fires() throws IOException
    {
        var fires = Database.fireRepository.getActiveFire();
        var locations = new ArrayList<Location>();
        SensorEntity sensor = null;
        for (FireEntity fire : fires)
        {
            sensor = fire.getSensor();
            var result = Apis.geocoding().search(sensor.getStreet(), sensor.getPostalCode(), "json").execute().body();
            if (result != null)
            {
                var location = result.get(0);

                locations.add(new Location(Double.parseDouble(location.lat), Double.parseDouble(location.lon),  fire.getIntensity() * 1.0));
            }
        }
        return Response
                .status(Response.Status.OK)
                .entity(locations)
                .build();

    }


}
