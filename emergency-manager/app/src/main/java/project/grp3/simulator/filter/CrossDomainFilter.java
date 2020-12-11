package project.grp3.simulator.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CrossDomainFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext creq, ContainerResponseContext cres) {
        cres.getHeaders().add("Access-Control-Allow-Origin", "*");
        cres.getHeaders().add("Access-Control-Allow-Headers", "*");
        cres.getHeaders().add("Access-Control-Allow-Credentials", "*");
        cres.getHeaders().add("Access-Control-Allow-Methods", "*");
        cres.getHeaders().add("Access-Control-Max-Age", "*");
    }
}
