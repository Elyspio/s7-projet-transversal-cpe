package project.grp3.emergency.web.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import project.grp3.emergency.core.api.Apis;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.core.database.entities.BarrackEntity;
import project.grp3.emergency.core.database.entities.FireEntity;
import project.grp3.emergency.core.database.entities.LocationEntity;
import project.grp3.emergency.core.database.entities.SensorEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;

public class BarrackRessource {


    @GET
    @ApiOperation(value = "Returns the list of fires ")
    @ApiResponses(
            @ApiResponse(code = 500, response = IOException.class, message = "Thrown on network issue")
    )
    @Produces("application/json")
    @Path("/barracksLocation")
    public Response fires() throws IOException {
        var barracks = Database.barrackRepository().getAll();
        var locations = new ArrayList<LocationEntity>();
        for (BarrackEntity barrack: barracks) {
            var result = Apis.geocoding().search(barrack.getStreet(), barrack.getPostalCode(), "json").execute().body();
            if (result != null) {
                var location = result.get(0);
                locations.add(new LocationEntity((Double.parseDouble(location.lat)),Double.parseDouble(location.lon)));
            }
        }
        return Response
                .status(Response.Status.OK)
                .entity(locations)
                .build();

    }

}
