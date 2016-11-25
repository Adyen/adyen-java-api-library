package com.adyen.service.resource.modification;

import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;
import java.util.List;

public class CancelOrRefund extends Resource {
	

	public CancelOrRefund(Service service) {
		super(service,
				service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + service.getClient().getApiVersion() + "/cancelOrRefund",
				Arrays.asList(
					"merchantAccount",
					"originalReference")
		);
	}
}
