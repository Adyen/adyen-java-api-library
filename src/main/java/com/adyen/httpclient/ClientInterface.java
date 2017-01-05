package com.adyen.httpclient;

import com.adyen.Config;
import com.adyen.Service;

import java.io.IOException;
import java.util.Map;

public interface ClientInterface {
	
	Map<String, Object> requestJson(Service service, String requestUrl, Map<String, Object> params);

	String request(String endpoint, String json, Config config) throws IOException, HTTPClientException;
}
