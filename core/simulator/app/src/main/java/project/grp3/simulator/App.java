package project.grp3.simulator;

import io.swagger.jaxrs.config.BeanConfig;
import project.grp3.simulator.config.NetworkConfig;
import project.grp3.simulator.core.managment.Managment;
import project.grp3.simulator.web.filter.CrossDomainFilter;
import project.grp3.simulator.web.resource.FireResource;

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

        beanConfig.setHost("localhost:" + NetworkConfig.getInstance().self().getPort());

        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("project.grp3.simulator.web.resource");
        beanConfig.setVersion("1.0.2");
        beanConfig.setScan(true);

        try
        {
            Managment.init();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new HashSet<>();

        // Resources
        resources.add(FireResource.class);

        // ALLOW CORS
        resources.add(CrossDomainFilter.class);

        // SWAGGER
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}

