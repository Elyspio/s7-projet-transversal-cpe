package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.web.Assembler.FireTruckAssembler;
import project.grp3.emergency.web.Assembler.FiremanAssembler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/fireTruck")
@Api(value = "fireTruck")
public class FireTruckResource {
    @GET
    @ApiOperation(value = "get all fireTruck")
    @Produces("application/json")
    public Response fireTruck() {
        return Response
                .status(Response.Status.OK)
                .entity(Database.fireTruckRepository.getAll()
                        .stream()
                        .map(fireTruckEntity ->new FireTruckAssembler().toData(fireTruckEntity))
                        .toArray())
                .build();
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "get one fireTruck by id")
    @Produces("application/json")
    public Response fireTruckById(@PathParam("id") Long id) {
        return Response
                .status(Response.Status.OK)
                .entity(new FireTruckAssembler().toData(Database.fireTruckRepository.getById(id)))
                .build();

    }

}
