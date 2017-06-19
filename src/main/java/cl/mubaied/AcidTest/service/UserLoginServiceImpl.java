package cl.mubaied.AcidTest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService{
	
	private List<String> users = new ArrayList<String>();
	
	public UserLoginServiceImpl() {
		super();
		this.users.add("h001");
	}

	/**
	 * Busca el usaario de entrada en la estructura de datos users
	 * 
	 * @param username nombre del usuario
	 * @param image base64 de la imagen cargada
	 * @return true si existe el usuario
	 */
	@Override
	public boolean validateCredentials(String username, String image) {
		return this.users.contains(username);
	}
}
