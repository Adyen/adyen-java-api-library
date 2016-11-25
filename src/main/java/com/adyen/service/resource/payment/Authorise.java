package com.adyen.service.resource.payment;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class Authorise extends Resource {
	

	public Authorise(Service service) {
		super(service,
				service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + service.getClient().getApiVersion() + "/authorise",
				Arrays.asList(
						"merchantAccount",
						"amount.value",
						"amount.currency",
						"reference"
				));
	}
}
