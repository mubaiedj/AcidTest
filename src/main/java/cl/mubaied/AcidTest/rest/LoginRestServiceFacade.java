package cl.mubaied.AcidTest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public interface LoginRestServiceFacade {
	
	@GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDefaultUserInJSON();

}
