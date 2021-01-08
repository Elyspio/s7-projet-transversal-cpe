package project.grp3.simulator.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import project.grp3.simulator.core.api.Apis;
import project.grp3.simulator.core.api.microbitsimulator.model.PostFireModel;
import project.grp3.simulator.core.services.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;

@Path("/resources")
@Api(value = "hello")
public class FireResource
{
    @POST
    @ApiOperation(value = "Returns the list of simulator's  ")
    @ApiResponses(
            @ApiResponse(code = 500, response = IOException.class, message = "Thrown on network issue")
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


}
