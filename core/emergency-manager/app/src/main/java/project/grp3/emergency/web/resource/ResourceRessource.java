package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;

import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/resources")
@Api(value = "resources")
public class ResourceRessource
{
    @PUT()
    @ApiOperation(value = "get notice that a ressource is back")
    @Produces("application/json")
    public Response ressourceBack(@FormParam("ressourceId") Long ressourceId)
    {


        return Response
                .status(Database.resourceRepository.setArrived(ressourceId))
                .build();
    }

}
