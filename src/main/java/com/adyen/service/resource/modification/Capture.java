package com.adyen.service.resource.modification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;
import java.util.List;

public class Capture extends Resource {
	
	protected List<String> requiredFields = Arrays.asList(
	        "merchantAccount",
	        "originalReference"
	    );
	
	protected String endpoint;
	
	public Capture(Service service) {
		super(service,
				service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + service.getClient().getApiVersion() + "/capture",
				Arrays.asList(
						"merchantAccount",
						"originalReference")
		);
	}
}
