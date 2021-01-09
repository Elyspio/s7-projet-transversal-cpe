package project.grp3.emergency.core.services;

import java.util.logging.Logger;

public class Services
{

    private static Services instance;
    private final ResourceService resource;
    private final FireService fire;

    private Services()
    {
        fire = new FireService();
        resource = new ResourceService();
    }

    public static void init()
    {
        instance = new Services();
    }

    public static FireService fire()
    {
        return instance.fire;
    }

    public static ResourceService resource()
    {
        return instance.resource;
    }

    public static abstract class Service
    {
        protected Logger logger;
    }
}
