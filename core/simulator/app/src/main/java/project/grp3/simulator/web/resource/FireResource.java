package project.grp3.simulator.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.simulator.core.api.Apis;
import project.grp3.simulator.core.api.fire.model.PostFireModel;
import project.grp3.simulator.core.database.Database;
import project.grp3.simulator.web.data.Location;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;

@Path("/resources")
@Api(value = "hello")
public class FireResource
{
    @POST
    @ApiOperation(value = "Indiqué l'envoie d'un camion et d'une équipe pour traiter le trajet.")
    @Produces("application/json")
    @Path("/send")
    public Response send(
            @FormParam("sensorId") long sensorId,
            @FormParam("intensity") Integer intensity,
            @FormParam("firetyipeId") Long firetyipeId
            ) {

        var newFire = new PostFireModel();
        newFire.fireTypeId(BigDecimal.valueOf(firetyipeId));
        newFire.intensity(BigDecimal.valueOf(intensity));
        newFire.sensorId(BigDecimal.valueOf(sensorId));
        return Response
                .status(Response.Status.OK)
                .entity(Database.sensorRepository.getAll())
                .build();
    }




}