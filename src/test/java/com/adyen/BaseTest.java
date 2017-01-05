package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.httpclient.HttpURLConnectionClient;
import com.adyen.model.Amount;
import com.adyen.model.BrowserInfo;
import com.adyen.model.Card;
import com.adyen.model.PaymentRequest;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

public class BaseTest {
	protected static Map<String,String> configurations;
	
	/**
	 * Load configuration values
	 */
	@BeforeClass
	public static void setUp() {
		try {
			File file = new File("src/test/java/com/adyen/config/test.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			configurations = new HashMap<String, String>();
			
			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				configurations.put(key, value);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Client createClientFromConfigurations()
	{
		Client client = new Client(
				configurations.get("username"),
				configurations.get("password"),
				Environment.TEST,
				"My Test Application"
		);
		return client;
	}
	
	public String getMerchantAccount()
	{
		return configurations.get("merchantAccount");
	}

	/**
	 * Returns a Client object that has a mocked response
	 *
	 * @param response
	 * @return
	 */
	public Client createMockClientFromResponse(String response)
	{
		HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
		try {
			when(httpURLConnectionClient.
					request(any(String.class), any(String.class), any(Config.class))).
					thenReturn(response);
		} catch (IOException | HTTPClientException e) {
			e.printStackTrace();
		}
		Client client = new Client();
		client.setHttpClient(httpURLConnectionClient);
		return client;
	}

	/**
	 * Returns a Client object that has a mocked response from fileName
	 *
	 * @param fileName
	 * @return
	 */
	public Client createMockClientFromFile(String fileName) {
		String response = getFileContents(fileName);

		return createMockClientFromResponse(response);
	}

	/**
	 * Helper for file reading
	 *
	 * @param fileName
	 * @return
	 */
	private String getFileContents(String fileName){
		String result = "";

		ClassLoader classLoader = getClass().getClassLoader();
		try {
			result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Returns a sample PaymentRequest opbject
	 *
	 * @return
	 */
	public PaymentRequest createFullCardPaymentRequest() {
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setReference("123456");
		paymentRequest.setMerchantAccount("AMerchant");

		Amount amount = new Amount();
		amount.setCurrency("EUR");
		amount.setValue(new Long("1000"));

		paymentRequest.setAmount(amount);

		Card card = new Card();
		card.setExpiryMonth("08");
		card.setExpiryYear("2018");
		card.setHolderName("John Doe");
		card.setNumber("5136333333333335");
		card.setCvc("737");

		paymentRequest.setCard(card);

		BrowserInfo browserInfo = new BrowserInfo();
		browserInfo.setAcceptHeader("*/*");
		browserInfo.setUserAgent("User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

		paymentRequest.setBrowserInfo(browserInfo);
		paymentRequest.setShopperIP("1.2.3.4");

		return paymentRequest;
	}

	/**
	 * Returns a Client that has a mocked error response from fileName
	 *
	 * @param status
	 * @param fileName
	 * @return
	 */
	public Client createMockClientForErrors(int status, String fileName) {
		String response = getFileContents(fileName);

		HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
		HTTPClientException httpClientException = new HTTPClientException(
				status,
				"An error occured",
				new HashMap<String, List<String>>(),
				response);
		try {
			when(httpURLConnectionClient.
					request(any(String.class), any(String.class), any(Config.class))).
					thenThrow(httpClientException);
		} catch (IOException | HTTPClientException e) {
			e.printStackTrace();
		}
		Client client = new Client();
		client.setHttpClient(httpURLConnectionClient);
		return client;
	}
}
