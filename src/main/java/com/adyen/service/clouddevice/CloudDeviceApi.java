package com.adyen.service.clouddevice;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.binlookup.ThreeDSAvailabilityResponse;
import com.adyen.model.clouddevice.CloudDeviceApiRequest;
import com.adyen.model.clouddevice.CloudDeviceApiResponse;
import com.adyen.service.resource.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudDeviceApi extends Service {

	public static final String API_VERSION = "1";

	protected String baseURL;

	/**
	 * CloudDeviceApi constructor in {@link com.adyen.service.clouddevice package}.
	 *
	 * @param client {@link Client } (required)
	 */
	public CloudDeviceApi(Client client) {
		super(client);
		this.baseURL = createBaseURL("");
	}

	public CloudDeviceApiResponse sendSync(String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest) throws Exception {

		// Add path params
		Map<String, String> pathParams = new HashMap<>();

		if (merchantAccount == null) {
			throw new IllegalArgumentException("Please provide the merchantAccount path parameter");
		}
		pathParams.put("merchantAccount", merchantAccount);

		if (deviceId == null) {
			throw new IllegalArgumentException("Please provide the deviceId path parameter");
		}
		pathParams.put("deviceId", deviceId);

		// set deviceId
		cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

		String requestBody = cloudDeviceApiRequest.toJson();
		Resource resource = new Resource(this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/sync", null);
		String jsonResult = resource.request(requestBody, null, ApiConstants.HttpMethod.POST, pathParams);

		return CloudDeviceApiResponse.fromJson(jsonResult);

	}


}
