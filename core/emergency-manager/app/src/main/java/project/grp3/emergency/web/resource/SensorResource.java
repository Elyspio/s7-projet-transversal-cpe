package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import project.grp3.emergency.core.database.Database;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/sensors")
@Api(value = "sensors")
public class SensorResource
{

    @POST()
    @Produces("application/json")
    public Response getAll()
    {

        var sensors = Database.sensorRepository().getAll();

        return Response
                .status(Response.Status.OK)
                .entity(sensors)
                .build();

    }

}
