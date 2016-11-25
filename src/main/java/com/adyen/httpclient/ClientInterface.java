package com.adyen.httpclient;

import com.adyen.Request;
import com.adyen.Service;

import java.util.Map;

public interface ClientInterface {
	
	Map<String, Object> requestJson(Service service, String requestUrl, Map<String, Object> params);

}
