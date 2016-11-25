package com.adyen;

import com.adyen.service.Modification;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ModificationTest extends BaseTest{
	
	@Test
	public void TestCancelModification()
	{
		
		// do payment call
		PaymentTest paymentTest = new PaymentTest();
		Map<String, Object> paymentResult = paymentTest.doPaymentCall();
		
		Object pspReference = paymentResult.get("pspReference");
		
		Client client = this.createClientFromConfigurations();
		
		// define parameters
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("merchantAccount", this.getMerchantAccount());
		params.put("originalReference", pspReference);
	

		Modification modification = new Modification(client);
		
//		Map<String, Object> result = modification.cancel(params);
//
//		System.out.println(result);
		
		
		
	}

}
