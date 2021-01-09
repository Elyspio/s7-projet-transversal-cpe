package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.services.Services;
import project.grp3.emergency.web.resource.models.FireResourceNewFire;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;


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
}
