package project.grp3.emergency;

import io.swagger.jaxrs.config.BeanConfig;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.web.filter.CrossDomainFilter;
import project.grp3.emergency.web.resource.FireTruckResource;
import project.grp3.emergency.web.resource.FiremanRessource;
import project.grp3.emergency.web.resource.HelloResource;
import project.grp3.emergency.web.resource.ResourceRessource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class App extends Application {

    public App() {
        BeanConfig beanConfig = new BeanConfig();

        var port = "8083";

        if (System.getenv().containsKey("OWN_PORT")) {
            port = System.getenv("OWN_PORT");
        }

        beanConfig.setHost("localhost:" + port);

        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("project.grp3.simulator.resources");
        beanConfig.setVersion("1.0.2");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        // Resources
        resources.add(HelloResource.class);
        resources.add(FiremanRessource.class);
        resources.add(FireTruckResource.class);
        resources.add(ResourceRessource.class);

        // ALLOW CORS
        resources.add(CrossDomainFilter.class);

        // SWAGGER
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}

