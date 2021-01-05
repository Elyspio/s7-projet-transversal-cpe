package project.grp3.emergency.web.resource;

import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public class FireRessource {

    @POST
    @ApiOperation(value = "get notice that a ressource is back")
    @Produces("application/json")
    public Response newFire(Long sensorId, Integer intensity,Long fireTypeId) {
    var fire = Database.fireRepository.create(sensorId,intensity,fireTypeId);
    var resource = Database.resourceRepository.create(fire);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
}
