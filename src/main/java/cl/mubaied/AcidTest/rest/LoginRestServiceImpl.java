package cl.mubaied.AcidTest.rest;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mubaied.AcidTest.model.User;
import cl.mubaied.AcidTest.service.UserLoginService;
import cl.mubaied.AcidTest.service.WebServiceClient;
import cl.mubaied.AcidTest.util.Properties;

@Service("loginRestServiceFacade")
public class LoginRestServiceImpl implements LoginRestServiceFacade{
	
	@Autowired
	private WebServiceClient webServiceClient;
	
	@Autowired
	private UserLoginService userLoginService;
	
	/**
	 * Servicio web que recibe parametros desde un formulario
	 * este hace forward de los parámetros hacia el verifyUser
	 * y devuelte la respuesta desde el web service verifyUser 
	 * al cliente.
	 * 
	 * @param user Objeto User mapeado desde json proveniente del cliente
	 * @return estatus 200 ok o 401 para no autorizados
	 */
	@Override
	public Response login(User user) {
		return Response.status(webServiceClient.clientPost(user)).build();
	}
	
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
	@Override
	public Response verifyUser(String username, String image, String token) {
		if(!Properties.getWebServiceToken().equals(token))
			return Response.status(401).build();
		
		if(userLoginService.validateCredentials(username, image)){
			return Response.status(200).build();
		}else{
			return Response.status(401).build();
		}
	}

	public void setWebServiceClient(WebServiceClient webServiceClient) {
		this.webServiceClient = webServiceClient;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
}
