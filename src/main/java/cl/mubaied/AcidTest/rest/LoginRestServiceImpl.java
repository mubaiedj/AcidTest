package cl.mubaied.AcidTest.rest;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service("loginRestServiceFacade")
public class LoginRestServiceImpl implements LoginRestServiceFacade{

	@Override
	public Response getDefaultUserInJSON() {
		return Response.status(200).build();
	}

}
