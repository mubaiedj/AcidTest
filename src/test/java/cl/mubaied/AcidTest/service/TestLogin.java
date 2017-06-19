package cl.mubaied.AcidTest.service;

import javax.ws.rs.core.Response;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.mubaied.AcidTest.model.User;
import cl.mubaied.AcidTest.rest.LoginRestServiceImpl;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestLogin extends TestCase{
	
	private UserLoginService userLoginService;
	private WebServiceClient webServiceClient;
	private User user;
	
	@Before
    public void setup() {
		userLoginService = EasyMock.createMock(UserLoginService.class);
		webServiceClient = EasyMock.createMock(WebServiceClient.class);
		
		user =  new User();
		user.setUsername("h001");
		user.setImage("TWFuIGlzIGRpc3Rpbmd1aXNoZ");
    }
	
	/**
	 * Test para comprobar la funcionalidad de la implementacion
	 * del web service login y garantizar hace forward del estatus 
	 * segun la respuesta del cliente post.
	 */
	@Test
	public void testLogin() {
		EasyMock.expect(webServiceClient.clientPost(user)).andReturn(200);
		EasyMock.replay(webServiceClient);
		
		LoginRestServiceImpl lrs = new LoginRestServiceImpl();
		lrs.setWebServiceClient(webServiceClient);
		
		Response res = lrs.login(user);
		assertEquals(200, res.getStatus());
	}
	
	/**
	 * Test para comprobar el funcionamiento del web service
	 * verifyUser de manera que responda status 200 para un usuario
	 * existente y status 401 para un usuario inexistente.
	 */
	@Test
	public void testVerifyUser() {
		EasyMock.expect(userLoginService.validateCredentials("h001", null)).andReturn(true);
		EasyMock.expect(userLoginService.validateCredentials("h002", null)).andReturn(false);
		EasyMock.replay(userLoginService);
		
		LoginRestServiceImpl lrs = new LoginRestServiceImpl();
		lrs.setUserLoginService(userLoginService);
		
		Response res =  null;
		
		res = lrs.verifyUser("h001",  null, "acidTestToken");
		assertEquals(200, res.getStatus());
		
		res = lrs.verifyUser("h002",  null, "acidTestToken");
		assertEquals(401, res.getStatus());
	}
}
