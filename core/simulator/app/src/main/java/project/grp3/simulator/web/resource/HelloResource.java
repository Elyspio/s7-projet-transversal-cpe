package project.grp3.simulator.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.simulator.core.api.*;
import project.grp3.simulator.core.api.fire.model.PostFireModel;
import project.grp3.simulator.core.database.Database;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;

@Path("/hello-world")
@Api(value = "hello")
public class HelloResource {
    @GET
    @ApiOperation(value = "test the world")
    @Produces("application/json")
    public Response hello() {

        return Response
                .status(Response.Status.OK)
                .entity(Database.sensorRepository.getAll())
                .build();
    }

    @GET
    @Path("link")
    @ApiOperation(value = "test the microbit (simulator) link")
    @Produces("application/json")
    public Response testLink() {

        var data = new PostFireModel()
                .fireTypeId(BigDecimal.valueOf(12))
                .intensity(BigDecimal.valueOf(3))
                .sensorId(BigDecimal.valueOf(125));

        PostFireModel response = null;
        try {
            response = Apis.getFire().fireNewFire(data).execute().body();
            return Response
                    .status(Response.Status.OK)
                    .entity(response)
                    .build();
        } catch (IOException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }

    }


}