package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.api.truck.model.MovementModel;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.enums.LogAction;
import project.grp3.emergency.web.Assembler.FiremanAssembler;
import project.grp3.emergency.web.Service.FireService;
import retrofit2.http.Body;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;


@Path("/fires")
@Api(value = "fires")
public class FireRessource {

    @POST()
    @ApiOperation(value = "get notice that a ressource is back")
    @Produces("application/json")
    public Response newFire(@FormParam("sensorId") Long sensorId,@FormParam("intensity") Integer intensity,@FormParam("fireTypeId") Long fireTypeId) {
        var fire = FireService.handleFire(sensorId,fireTypeId,intensity);
        if(fire){
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        }
        else{
            return Response
                    .status(Response.Status.ACCEPTED)
                    .build();
        }

    }
}
