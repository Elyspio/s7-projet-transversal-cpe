package project.grp3.emergency;

import io.swagger.jaxrs.config.BeanConfig;
import project.grp3.emergency.config.NetworkConfig;
import project.grp3.emergency.core.database.Database;
import project.grp3.emergency.web.filters.CrossDomainFilter;
import project.grp3.emergency.web.resource.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class App extends Application
{

    public App()
    {
        BeanConfig beanConfig = new BeanConfig();


        beanConfig.setHost("localhost:" + NetworkConfig.getInstance().getSelf().getPort());

        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("project.grp3.emergency.web.resource");
        beanConfig.setVersion("1.0.2");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new HashSet<>();

        // Resources
        resources.add(HelloResource.class);
        resources.add(FiremanRessource.class);
        resources.add(FireTruckResource.class);
        resources.add(ResourceResource.class);
        resources.add(FireRessource.class);

        // ALLOW CORS
        resources.add(CrossDomainFilter.class);


        // SWAGGER
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);


        Database.init();

        return resources;
    }
}

