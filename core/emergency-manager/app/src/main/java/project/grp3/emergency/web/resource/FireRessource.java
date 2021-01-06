package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.web.service.FireService;
import project.grp3.emergency.web.resource.models.FireResourceNewFire;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/fires")
@Api(value = "fires")
public class FireRessource
{

    @POST()
    @ApiOperation(value = "add or update a fire")
    @Consumes("application/json")
    @Produces("application/json")
    public Response newFire(FireResourceNewFire params)

    {
        var fire = FireService.handleFire(params.sensorId, params.fireTypeId, params.intensity);
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
}
