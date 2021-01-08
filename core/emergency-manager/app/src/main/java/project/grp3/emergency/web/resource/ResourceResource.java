package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.services.Services;
import project.grp3.emergency.web.resource.models.ResourceGetResource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/resources")
@Api(value = "resources")
public class ResourceResource
{
    @PUT()
    @ApiOperation(value = "get notice that a resource is back")
    @Produces("application/json")
    public Response resourceBack(@FormParam("resourceId") Long resourceId)
    {


        return Response
                .status(Database.resourceRepository.setArrived(resourceId))
                .build();
    }


    @GET()
    @ApiOperation(value = "get a resource from its id", response = ResourceGetResource.class)
    @Produces("application/json")
    @Path("{id}")
    public Response getResource(@PathParam("id") Long id)
    {
        var res = Services.resource.getById(id);

        return Response
                .ok()
                .entity(res)
                .build();
    }


}
