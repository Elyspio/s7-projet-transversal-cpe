package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello-world")
@Api(value = "hello")
public class HelloResource
{
    @GET
    @ApiOperation(value = "test the world")
    @Produces("application/json")
    public Response hello()
    {
        return Response
                .status(Response.Status.OK)
                .entity(Database.sensorRepository.getAll())
                .build();
    }

    @GET
    @Path("link")
    @ApiOperation(value = "test the microbit (simulator) link")
    @Produces("application/json")
    public Response testLink()
    {
        return Response
                .status(Response.Status.OK)
                .build();

    }


}