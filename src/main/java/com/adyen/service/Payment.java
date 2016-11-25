package com.adyen.service;

import com.adyen.Client;
import com.adyen.Request;
import com.adyen.Service;
import com.adyen.service.resource.payment.Authorise;
import com.adyen.service.resource.payment.Authorise3D;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class Payment extends Service {

	private Authorise authorise;
	private Authorise3D authorise3D;
	
	public Payment(Client client) {
		super(client);	
		
		authorise = new Authorise(this);
		authorise3D = new Authorise3D(this);
	}
	
	public Map<String, Object> authorise(Map<String, Object> params) throws Exception {
		return authorise.request(params);
	}

	public Map<String, Object> authorise(String json) throws Exception {

		// convert to Map<String, Object>
		Map<String, Object> params = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>() {}.getType());

		return authorise.request(params);
	}
	
	
	public Map<String, Object> authorise3D(Map<String, Object> params) throws Exception {
		return authorise3D.request(params);
	}
}
