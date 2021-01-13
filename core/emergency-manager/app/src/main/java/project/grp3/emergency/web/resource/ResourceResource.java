package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import project.grp3.emergency.core.exception.EntityNotFound;
import project.grp3.emergency.core.exception.EntityNotFoundResponse;
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
    @Path("{id}")
    public Response resourceBack(@PathParam("id") Long resourceId)
    {
        try
        {
            Services.resource().setArrived(resourceId);

            return Response
                    .ok()
                    .build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return Response
                    .serverError()
                    .entity(e)
                    .build();
        }
    }


    @GET()
    @ApiOperation(value = "get a resource from its id", response = ResourceGetResource.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Thrown if there is no Resource with the provided id", response = EntityNotFoundResponse.class)
    })
    @Produces("application/json")
    @Path("{id}")
    public Response getResource(@PathParam("id") Long id)
    {
        ResourceGetResource res = null;
        try
        {
            res = Services.resource().getById(id);
            return Response
                    .ok()
                    .entity(res)
                    .build();
        }
        catch (EntityNotFound entityNotFound)
        {
            entityNotFound.printStackTrace();

            return Response
                    .status(404)
                    .entity(new EntityNotFoundResponse(entityNotFound))
                    .build();
        }


    }


}
