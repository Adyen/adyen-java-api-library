package com.adyen;

import com.adyen.enums.Environment;

import java.util.HashMap;
import java.util.Map;

public class Config {
	
	protected String username;
	protected String password;
	protected String merchantAccount;
	protected Environment environment;
	protected String endpoint;
	protected String applicationName;
	
	protected HashMap<String, Object> additionalData;
	
	
	public Config() {
		// do nothing
	}
	
	public Config(Map<String, Object>params) {
		
		if(!params.isEmpty()) {
			
			// loop through settings and set them
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMerchantAccount() {
		return merchantAccount;
	}

	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}

	public HashMap<String, Object> getAdditionalData() {
		return additionalData;
	}
	
	public void setAdditionalData(HashMap<String, Object> additionalData) {
		this.additionalData = additionalData;
	}
	
	public void addAddtionalData(String key, Object value) {
		this.additionalData.put(key, value);
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
}
