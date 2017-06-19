package cl.mubaied.AcidTest.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import cl.mubaied.AcidTest.model.User;

@Component
@Path("/")
public interface LoginRestServiceFacade {

	@POST
    @Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user);
	
	@POST
    @Path("/verifyUser/{username}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response verifyUser(@PathParam("username") String username, String image, @CookieParam("token") String token);

}
