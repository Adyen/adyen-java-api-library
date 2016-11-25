package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;

public class Modification extends Service{

//	private Cancel cancel;
	
	public Modification(Client client) {
		super(client);
//		cancel = new Cancel(this);
	}
	
//	public Map<String, Object> cancel(Map<String, Object> params) {
//		return cancel.request(params);
//	}

}
