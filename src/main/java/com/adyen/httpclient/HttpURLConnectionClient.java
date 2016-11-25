package com.adyen.httpclient;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.Request;
import com.adyen.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpURLConnectionClient implements ClientInterface { 
		
	public static final String CHARSET = "UTF-8";
	
	@SuppressWarnings("serial")
	public Map<String, Object> requestJson(Service service, String requestUrl,
			Map<String, Object> params) {
		
		Map<String, Object> json = new HashMap<String, Object>();
		
		Client client = service.getClient();
		Config config = client.getConfig();

		try {

			URL targetUrl = new URL(requestUrl);

			// set configurations
			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setUseCaches(false);
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			
			// set headers
			httpConnection.setRequestProperty("Content-Type", "application/json");
			httpConnection.setRequestProperty("Accept-Charset", CHARSET);
			httpConnection.setRequestProperty("User-Agent",
					String.format("%s %s%s", config.getApplicationName(), Client.USER_AGENT_SUFFIX, Client.LIB_VERSION));
						
			
			// set basic authentication
			String authString = config.getUsername() + ":" + config.getPassword();
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			
			httpConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);

			// convert parameters to JSON
			Gson gson = new GsonBuilder()
					.enableComplexMapKeySerialization()
					.create();
			String input = gson.toJson(params);

			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ httpConnection.getResponseCode());
			}

//			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
//					(httpConnection.getInputStream())));

			// get JSON result
			String result = getResponseBody(httpConnection.getInputStream());
			System.out.println(result);
			
			// convert back to HashMap
			json = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {}.getType());

			// close the connection
			httpConnection.disconnect();
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		 }
		return json;
	}
	
	private static String getResponseBody(InputStream responseStream)
			throws IOException {
		//\A is the beginning of the stream boundary
		Scanner scanner = new Scanner(responseStream, CHARSET);
		scanner.useDelimiter("\\A");
		String rBody = scanner.useDelimiter("\\A").next();
		scanner.close();
		responseStream.close();
		return rBody;
	}
	
//	public JSONObject requestJson(Service service, String requestUrl, JSONObject params) throws Exception
//    {	
//		JSONObject paymentResult = null;
//		
//		
//		URL adyenUrl = new URL(requestUrl);
//		
//		HttpURLConnection conn =  (HttpURLConnection) adyenUrl.openConnection();
//		conn.setConnectTimeout(30 * 1000);
//		conn.setReadTimeout(80 * 1000);
//		conn.setUseCaches(false);
////		for (Map.Entry<String, String> header : getHeaders(options).entrySet()) {
////			conn.setRequestProperty(header.getKey(), header.getValue());
////		}
//		
//		conn.setRequestMethod("POST");
//		
//		conn.setDoOutput(true);
//		
//		conn.setRequestProperty("Content-Type", String.format(
//				"application/x-www-form-urlencoded;charset=%s", CHARSET));
//
//		
//		query = createQuery(params);
//		
//		OutputStream output = null;
//		try {
//			output = conn.getOutputStream();
//			output.write(query.getBytes(CHARSET));
//		} finally {
//			if (output != null) {
//				output.close();
//			}
//		}
//		
//		
//		
//		return paymentResult;
//    
//    }
	
	
	public static String httpPost(String urlStr, String[] paramName,
			String[] paramVal) throws Exception {
			  URL url = new URL(urlStr);
			  HttpURLConnection conn =
			      (HttpURLConnection) url.openConnection();
			  conn.setRequestMethod("POST");
			  conn.setDoOutput(true);
			  conn.setDoInput(true);
			  conn.setUseCaches(false);
			  conn.setAllowUserInteraction(false);
			  conn.setRequestProperty("Content-Type",
			      "application/x-www-form-urlencoded");

			  conn.disconnect();
			  return "";
	}
}
