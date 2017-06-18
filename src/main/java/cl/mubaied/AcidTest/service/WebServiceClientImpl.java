package cl.mubaied.AcidTest.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import cl.mubaied.AcidTest.model.User;
import cl.mubaied.AcidTest.util.Properties;

@Service("webServiceClient")
public class WebServiceClientImpl implements WebServiceClient {
	
	/**
	 * Metodo encargado de realizar una llamada post a un servicio 
	 * web privado enviandole un objeto user y retorna el codigo
	 * obtenido del response de la peticion.
	 * 
	 * @param user objeto obtenido del llamado del servicio web login
	 * @return el codigo de la respuesta del servicio cosumido
	 */
	@Override
	public Integer clientPost(User user) {
		
		HttpURLConnection conn = null;
		String input = "{\"image\":" + user.getImage() + "}";
		
		try {
			
			URL url = new URL(Properties.getWebServiceUrl() + "/" + user.getUsername());
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Cookie", "token=" + Properties.getWebServiceToken());
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
						
			return conn.getResponseCode();
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null){
				conn.disconnect();
			}
		}
		
		return 400;
	}

}
