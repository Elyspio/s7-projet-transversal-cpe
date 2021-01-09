package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.web.assemblers.FiremanAssembler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/firemen")
@Api(value = "firemen")
public class FiremanRessource
{
    @GET
    @ApiOperation(value = "get all firemen")
    @Produces("application/json")
    public Response firemen()
    {
        return Response
                .ok()
                .entity(new FiremanAssembler().toData(Database.firemanRepository().getAll()))
                .build();
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "get one fireman by id")
    @Produces("application/json")
    public Response firemenById(@PathParam("id") Long id)
    {
        return Response
                .ok()
                .entity(new FiremanAssembler().toData(Database.firemanRepository().getById(id)))
                .build();

    }

}
