package com.adyen;

import com.google.gson.Gson;

public class Service{
	
	protected static final Gson GSON = new Gson();
	
	private Client client;
	
	protected Service(Client client){
		this.client = client;
	}
		
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
