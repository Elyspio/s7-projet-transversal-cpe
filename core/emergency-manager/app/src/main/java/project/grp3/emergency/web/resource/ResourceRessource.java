package project.grp3.emergency.web.resource;

import io.swagger.annotations.ApiOperation;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.repositories.ResourceRepository;
import project.grp3.emergency.web.Entity.Resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class ResourceRessource {
    @PUT
    @ApiOperation(value = "get notice that a ressource is back")
    @Produces("application/json")
    public Response ressourceBack(Long ressourceId) {


        return Response
                .status(Database.resourceRepository.setArrived(ressourceId))
                .build();
    }

}
