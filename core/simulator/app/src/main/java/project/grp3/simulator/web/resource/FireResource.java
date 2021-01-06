package project.grp3.simulator.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.simulator.core.api.Apis;
import project.grp3.simulator.core.api.microbitsimulator.model.PostFireModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;

@Path("/resources")
@Api(value = "hello")
public class FireResource
{
    @POST
    @ApiOperation(value = "Returns the list of simulator's  ")
    @Produces("application/json")
    @Path("/send")
    public Response send(
            @FormParam("sensorId") Long sensorId,
            @FormParam("intensity") Integer intensity,
            @FormParam("firetyipeId") Long firetyipeId
    )
    {

        var newFire = new PostFireModel();
        newFire.fireTypeId(BigDecimal.valueOf(firetyipeId));
        newFire.intensity(BigDecimal.valueOf(intensity));
        newFire.sensorId(BigDecimal.valueOf(sensorId));
        try
        {
           Apis.getMicrobit().fireNewFire(newFire).execute();
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


}
