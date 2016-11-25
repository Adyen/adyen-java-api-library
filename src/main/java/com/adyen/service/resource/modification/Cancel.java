package com.adyen.service.resource.modification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class Cancel extends Resource {

//	protected List<String> requiredFields = ;
//
//	protected String endpoint;

	public Cancel(Service service) {
		super(service,
				service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + service.getClient().getApiVersion() + "/cancel",
				Arrays.asList(
					"merchantAccount",
					"originalReference"
				)
		);
	}
}
