package cl.mubaied.AcidTest.util;

public class Properties {
	
	private static String webServiceUrl;
	private static String webServiceToken;
	
	public static String getWebServiceUrl() {
		return webServiceUrl;
	}
	
	public static void setWebServiceUrl(String webServiceUrl) {
		Properties.webServiceUrl = webServiceUrl;
	}
	
	public static String getWebServiceToken() {
		return webServiceToken;
	}
	
	public static void setWebServiceToken(String webServiceToken) {
		Properties.webServiceToken = webServiceToken;
	}
	
}
