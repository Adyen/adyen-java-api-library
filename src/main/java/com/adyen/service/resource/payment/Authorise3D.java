package com.adyen.service.resource.payment;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;
import java.util.List;

public class Authorise3D extends Resource {

	public Authorise3D(Service service) {
		super(service,
				service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + service.getClient().getApiVersion() + "/authorise3d",
				Arrays.asList(
						"merchantAccount",
						"browserInfo",
						"md",
						"paResponse"
				));
	}
}
