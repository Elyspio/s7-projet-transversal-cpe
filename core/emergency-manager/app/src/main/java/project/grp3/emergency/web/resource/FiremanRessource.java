package project.grp3.emergency.web.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.web.Assembler.FiremanAssembler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/firemen")
@Api(value = "firemen")
public class FiremanRessource {
        @GET
        @ApiOperation(value = "get all firemen")
        @Produces("application/json")
        public Response firemen() {
            return Response
                    .status(Response.Status.OK)
                    .entity(Database.firemanRepository.getAll()
                            .stream()
                            .map(firemanEntity ->new FiremanAssembler().toData(firemanEntity))
                            .toArray())
                    .build();
        }

        @GET
        @Path("{id}")
        @ApiOperation(value = "get one fireman by id")
        @Produces("application/json")
        public Response firemenById(@PathParam("id") Long id) {
            return Response
                    .status(Response.Status.OK)
                    .entity(new FiremanAssembler().toData(Database.firemanRepository.getById(id)))
                    .build();

        }

}
