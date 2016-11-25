package com.adyen;

import com.adyen.service.Payment;
import com.google.gson.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class PaymentTest extends BaseTest{
	
	
	public Map<String, Object> doPaymentCall() {
		
		Client client = this.createClientFromConfigurations();


		// define parameters
		Map<String, Object> params = new HashMap<String, Object>();

		String merchantAccount = configurations.get("merchantAccount");
		String reference = "TEST-PAYMENT-2";


		Map<String, String> amount = new HashMap<String, String>();
		amount.put("currency", "EUR");
		amount.put("value", "100000"); // minor units!
		params.put("amount", amount);



		// reflection with dot in gson ? problem is then cse encryption

		Map<String, String> card = new HashMap<String, String>();
		card.put("expiryMonth", "08");
		card.put("expiryYear", "2018");
		card.put("holderName", "John Doe");
		card.put("number", "5136333333333335");
		card.put("cvc", "737");

		params.put("card", card);

		params.put("merchantAccount", merchantAccount);
		params.put("reference", reference);

		Payment paymentRequest = new Payment(client);

		try {
			Map<String, Object> result = paymentRequest.authorise(params);
			return result;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
	
	
	@Test
	public void TestSuccessFulPaymentAuthorisation()
	{
		Map<String, Object> result = this.doPaymentCall();
		System.out.println(result);
		
//		Object pspReference = result.get("pspReference");
        String resultCode = result.get("resultCode").toString();

        assertEquals("Authorised", resultCode);
	}

	@Test
	public void TestSuccessFulPaymentAuthorisationJson()
	{

		Client client = this.createClientFromConfigurations();
		Payment paymentRequest = new Payment(client);

		String json = "{ " +
			"\"reference\": \"1000000\", " +
			"\"merchantAccount\": \"MagentoMerchantRik\", " +
			"\"amount\": { " +
				"\"currency\": \"EUR\"," +
				" \"value\": \"10000\" " +
			"}, " +
			"\"card\": { " +
			"\"expiryMonth\": \"08\"," +
			"\"expiryYear\": \"2018\"," +
			"\"holderName\": \"John Doe\"," +
			"\"number\": \"5136333333333335\"," +
			"\"cvc\": \"737\"" +
			"} " +
		"}";


		Map<String, Object> result = null;
		try {
			result = paymentRequest.authorise(json);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(result);


//		Object pspReference = result.get("pspReference");
		String resultCode = result.get("resultCode").toString();

		assertEquals("Authorised", resultCode);
	}

}
