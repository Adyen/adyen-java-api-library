package com.adyen;

public class Service{
	
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
