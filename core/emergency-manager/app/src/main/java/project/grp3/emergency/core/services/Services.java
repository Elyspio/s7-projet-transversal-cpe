package project.grp3.emergency.core.services;

import java.util.logging.Logger;

public class Services
{

    public final static ResourceService resource = new ResourceService();
    public final static FireService fire = new FireService();

    private Services()
    {
    }

    public static abstract class Service
    {
        protected Logger logger;
    }
}
