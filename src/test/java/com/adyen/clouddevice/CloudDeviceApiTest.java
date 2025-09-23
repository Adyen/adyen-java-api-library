package com.adyen.clouddevice;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.*;
import com.adyen.service.clouddevice.CloudDeviceApi;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

public class CloudDeviceApiTest extends BaseTest {

	@Test
	public void sendSync() throws Exception {
		Client client = createMockClientFromFile("mocks/clouddevice/payment-sync-success.json");

		CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

		CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

		var response = cloudDeviceApi.sendSync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

		assertNotNull(response);
		assertNotNull(response.getSaleToPOIResponse());
		assertNotNull(response.getSaleToPOIResponse().getMessageHeader());
		assertEquals("P400Plus-123456789", response.getSaleToPOIResponse().getMessageHeader().getPOIID());

		verify(client.getHttpClient())
				.request(
						"/merchants/myMerchant/devices/P400Plus-123456789/sync",
						cloudDeviceApiRequest.toJson(),
						client.getConfig(),
						false,
						null,
						ApiConstants.HttpMethod.POST,
						null);

	}

	protected CloudDeviceApiRequest createCloudDeviceAPIPaymentRequest()
			throws DatatypeConfigurationException {
		SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setProtocolVersion("3.0");
		messageHeader.setMessageClass(MessageClassType.SERVICE);
		messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
		messageHeader.setMessageType(MessageType.REQUEST);
		messageHeader.setSaleID("001");
		messageHeader.setServiceID("001");
		messageHeader.setPOIID("P400Plus-123456789");

		saleToPOIRequest.setMessageHeader(messageHeader);

		PaymentRequest paymentRequest = new PaymentRequest();

		SaleData saleData = new SaleData();
		TransactionIdentification transactionIdentification = new TransactionIdentification();
		transactionIdentification.setTransactionID("001");
		OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
		transactionIdentification.setTimeStamp(timestamp);
		saleData.setSaleTransactionID(transactionIdentification);

		PaymentTransaction paymentTransaction = new PaymentTransaction();
		AmountsReq amountsReq = new AmountsReq();
		amountsReq.setCurrency("EUR");
		amountsReq.setRequestedAmount(BigDecimal.ONE);
		paymentTransaction.setAmountsReq(amountsReq);

		paymentRequest.setSaleData(saleData);
		paymentRequest.setPaymentTransaction(paymentTransaction);

		saleToPOIRequest.setPaymentRequest(paymentRequest);

		CloudDeviceApiRequest cloudDeviceApiRequest = new CloudDeviceApiRequest();
		cloudDeviceApiRequest.setSaleToPOIRequest(saleToPOIRequest);

		return cloudDeviceApiRequest;
	}

}
