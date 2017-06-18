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
	
	/**
	 * Servicio web que recibe parametros desde un formulario
	 * este hace forward de los parámetros hacia el verifyUser
	 * y devuelte la respuesta desde el web service verifyUser 
	 * al cliente.
	 * 
	 * @param user Objeto User mapeado desde json proveniente del cliente
	 * @return estatus 200 ok o 401 para no autorizados
	 */
	@POST
    @Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user);
	
	/**
	 * Servicio web privado consumido internamente por el servicio
	 * web login quien le sumistra los parametros, este responde estatus
	 * 200 si esta ok y 401 si no es un usuario autorizado.
	 * 
	 * @param username nombre de ususario suministrado por webservice login.
	 * @param image base64 de la imagen.
	 * @param token token que permite que este servicio sea solo consumido internamente.
	 * @return esattus estatus 200 ok o 401 para no autorizados
	 */
	@POST
    @Path("/verifyUser/{username}")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public Response verifyUser(@PathParam("username") String username, String image, @CookieParam("token") String token);

}
