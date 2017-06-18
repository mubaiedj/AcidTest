package cl.mubaied.AcidTest.rest;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mubaied.AcidTest.model.User;
import cl.mubaied.AcidTest.service.WebServiceClient;
import cl.mubaied.AcidTest.util.Properties;

@Service("loginRestServiceFacade")
public class LoginRestServiceImpl implements LoginRestServiceFacade{
	
	@Autowired
	private WebServiceClient webServiceClient;
	
	@Override
	public Response login(User user) {
		return Response.status(webServiceClient.clientPost(user)).build();
	}
	
	@Override
	public Response verifyUser(String username, String image, String token) {
		if(!Properties.getWebServiceToken().equals(token))
			return Response.status(401).build();
		
		if("h001".equals(username)){
			return Response.status(200).build();
		}else{
			return Response.status(401).build();
		}
	}

}
