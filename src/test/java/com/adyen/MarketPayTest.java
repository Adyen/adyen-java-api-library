package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.ApiError;
import com.adyen.model.marketpayaccount.AccountHolderDetails;
import com.adyen.model.marketpayaccount.CreateAccountHolderRequest;
import com.adyen.model.marketpayaccount.CreateAccountHolderResponse;
import com.adyen.model.marketpayaccount.ErrorFieldType;
import com.adyen.model.marketpayaccount.FieldType;
import com.adyen.model.marketpayaccount.GetTaxFormRequest;
import com.adyen.model.marketpayaccount.GetTaxFormResponse;
import com.adyen.model.marketpayconfiguration.CreateNotificationConfigurationRequest;
import com.adyen.model.marketpayconfiguration.GetNotificationConfigurationResponse;
import com.adyen.model.marketpayfund.PayoutAccountHolderRequest;
import com.adyen.model.marketpayfund.PayoutAccountHolderResponse;
import com.adyen.model.marketpayhop.GetOnboardingUrlRequest;
import com.adyen.model.marketpayhop.GetOnboardingUrlResponse;
import com.adyen.service.classicplatforms.ClassicPlatformAccountApi;
import com.adyen.service.classicplatforms.ClassicPlatformConfigurationApi;
import com.adyen.service.classicplatforms.ClassicPlatformFundApi;
import com.adyen.service.classicplatforms.ClassicPlatformHopApi;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class MarketPayTest extends BaseTest {

    @Test
    public void testConfigurationApi() throws IOException, ApiException, HTTPClientException {
        CreateNotificationConfigurationRequest request = CreateNotificationConfigurationRequest.fromJson("{\n" +
                                                                                                         "  \"configurationDetails\": {\n" +
                                                                                                         "    \"active\": true,\n" +
                                                                                                         "    \"description\": \"Unique description 123\",\n" +
                                                                                                         "    \"eventConfigs\": [\n" +
                                                                                                         "      {\n" +
                                                                                                         "        \"eventType\": \"ACCOUNT_HOLDER_VERIFICATION\",\n" +
                                                                                                         "        \"includeMode\": \"INCLUDE\"\n" +
                                                                                                         "      }\n" +
                                                                                                         "    ],\n" +
                                                                                                         "    \"notifyURL\": \"https://www.adyen.com/notification-handler\",\n" +
                                                                                                         "    \"notifyUsername\": \"testUserName\",\n" +
                                                                                                         "    \"notifyPassword\": \"testPassword\",\n" +
                                                                                                         "    \"sslProtocol\": \"TLSv13\"\n" +
                                                                                                         "  }\n" +
                                                                                                         "}");
        String jsonRequest = request.toJson();
        assertTrue(jsonRequest.contains("eventType\":\"ACCOUNT_HOLDER_VERIFICATION"));
        assertTrue(jsonRequest.contains("\"sslProtocol\":\"TLSv13\""));
        GetNotificationConfigurationResponse response = GetNotificationConfigurationResponse.fromJson("{\n" +
                                                                                                      "  \"pspReference\": \"8516178952380553\",\n" +
                                                                                                      "  \"configurationDetails\": {\n" +
                                                                                                      "    \"active\": true,\n" +
                                                                                                      "    \"description\": \"Unique description 123\",\n" +
                                                                                                      "    \"eventConfigs\": [\n" +
                                                                                                      "      {\n" +
                                                                                                      "        \"eventType\": \"ACCOUNT_HOLDER_VERIFICATION\",\n" +
                                                                                                      "        \"includeMode\": \"INCLUDE\"\n" +
                                                                                                      "      }\n" +
                                                                                                      "    ],\n" +
                                                                                                      "    \"notificationId\": 28468,\n" +
                                                                                                      "    \"notifyURL\": \"https://www.adyen.com/notification-handler\",\n" +
                                                                                                      "    \"sslProtocol\": \"TLSv13\"\n" +
                                                                                                      "  }\n" +
                                                                                                      "}");
        String json = response.toJson();
        assertTrue(json.contains("eventType\":\"ACCOUNT_HOLDER_VERIFICATION"));
        assertTrue(json.contains("\"sslProtocol\":\"TLSv13\""));

        Client client = createMockClientFromResponse(json);
        ClassicPlatformConfigurationApi api = new ClassicPlatformConfigurationApi(client);

        api.createNotificationConfiguration(request);
        verify(client.getHttpClient()).request(
                "https://cal-test.adyen.com/cal/services/Notification/v6/createNotificationConfiguration",
                jsonRequest,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }

    @Test
    public void testHopApi() throws IOException, ApiException, HTTPClientException {
        GetOnboardingUrlRequest request = GetOnboardingUrlRequest.fromJson("{\n" +
                                                                           "  \"accountHolderCode\": \"CODE_OF_ACCOUNT_HOLDER\",\n" +
                                                                           "  \"returnUrl\": \"https://your.return-url.com/?submerchant=123\"\n" +
                                                                           "}");
        String jsonRequest = request.toJson();
        GetOnboardingUrlResponse response = GetOnboardingUrlResponse.fromJson("{\n" +
                                                                              "  \"invalidFields\": [],\n" +
                                                                              "  \"pspReference\": \"9115677600500127\",\n" +
                                                                              "  \"resultCode\": \"Success\",\n" +
                                                                              "  \"redirectUrl\": \"https://hop-test.adyen.com/hop/view/?token=<token>\"\n" +
                                                                              "}");
        String json = response.toJson();
        Client client = createMockClientFromResponse(json);
        ClassicPlatformHopApi api = new ClassicPlatformHopApi(client);

        api.getOnboardingUrl(request);
        verify(client.getHttpClient()).request(
                "https://cal-test.adyen.com/cal/services/Hop/v6/getOnboardingUrl",
                jsonRequest,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }

    @Test
    public void testAccountApi() throws IOException, ApiException, HTTPClientException {
        GetTaxFormRequest request = GetTaxFormRequest.fromJson("{\n" +
                                                               "  \"accountHolderCode\": \"CODE_OF_ACCOUNT_HOLDER\",\n" +
                                                               "  \"formType\": \"1099-K\",\n" +
                                                               "  \"year\": 2020\n" +
                                                               "}");
        String jsonRequest = request.toJson();
        GetTaxFormResponse response = GetTaxFormResponse.fromJson("{\n" +
                                                                  "  \"content\": \"AQIDBAUGBwgJCgsMDQ4PEBESExQ=\",\n" +
                                                                  "  \"contentType\": \"String\",\n" +
                                                                  "  \"invalidFields\": [\n" +
                                                                  "    {\n" +
                                                                  "      \"errorCode\": 0,\n" +
                                                                  "      \"errorDescription\": \"string\",\n" +
                                                                  "      \"fieldType\": {\n" +
                                                                  "        \"field\": \"string\",\n" +
                                                                  "        \"fieldName\": \"accountCode\",\n" +
                                                                  "        \"shareholderCode\": \"string\"\n" +
                                                                  "      }\n" +
                                                                  "    }\n" +
                                                                  "  ],\n" +
                                                                  "  \"pspReference\": \"string\",\n" +
                                                                  "  \"resultCode\": \"string\"\n" +
                                                                  "}");
        // For some reason setting this content byte [] is broken
        String json = response.toJson();
        Client client = createMockClientFromResponse(json);
        ClassicPlatformAccountApi api = new ClassicPlatformAccountApi(client);

        api.getTaxForm(request);
        verify(client.getHttpClient()).request(
                "https://cal-test.adyen.com/cal/services/Account/v6/getTaxForm",
                jsonRequest,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }

    @Test
    public void testAccountApiMissingRequiredField() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/afp-validation-error.json");
        ClassicPlatformAccountApi api = new ClassicPlatformAccountApi(client);
        CreateAccountHolderRequest request = new CreateAccountHolderRequest();
        request.setAccountHolderCode("GENERATE_CODE");

        try {
            api.createAccountHolder(request);
            fail("invalid request should throw exception");
        } catch (ApiException e) {
            assertEquals(422, e.getStatusCode());
            ApiError apiError = e.getError();
            assertEquals(422, (int) apiError.getStatus());
            assertEquals("702", apiError.getErrorCode());
            assertEquals("Required field 'accountHolderDetails' is null", apiError.getMessage());
            assertEquals("validation", apiError.getErrorType());
        }
    }

    @Test
    public void testAccountApiInvalidValue() throws IOException {
        Client client = createMockClientForErrors(400, "mocks/invalid-phone-afp-response.json");
        ClassicPlatformAccountApi api = new ClassicPlatformAccountApi(client);
        CreateAccountHolderRequest request = new CreateAccountHolderRequest();
        request.setAccountHolderCode("GENERATE_CODE");
        AccountHolderDetails accountHolderDetails = new AccountHolderDetails();
        accountHolderDetails.setEmail("tim@green.com");
        accountHolderDetails.setFullPhoneNumber("foo bar");
        request.setLegalEntity(CreateAccountHolderRequest.LegalEntityEnum.INDIVIDUAL);
        request.setAccountHolderDetails(accountHolderDetails);

        try {
            api.createAccountHolder(request);
            fail("invalid request should throw exception");
        } catch (ApiException e) {
            CreateAccountHolderResponse res = CreateAccountHolderResponse.fromJson(e.getResponseBody());

            assertEquals(400, e.getStatusCode());
            ErrorFieldType error = res.getInvalidFields().get(0);
            assertEquals(92, (int) error.getErrorCode());
            assertEquals("The fullPhoneNumber must be in the format of a beginning plus (+) followed by the country code and phone number.  Only digits and the leading plus are permitted.", error.getErrorDescription());
            assertEquals("AccountHolderDetails.PhoneNumber.fullPhoneNumber", error.getFieldType().getField());
            assertEquals(FieldType.FieldNameEnum.FULLPHONENUMBER, error.getFieldType().getFieldName());
        }
    }

    @Test
    public void testFundApi() throws IOException, ApiException, HTTPClientException {
        PayoutAccountHolderRequest request = PayoutAccountHolderRequest.fromJson("{\n" +
                                                                                 "  \"accountCode\": \"118731451\",\n" +
                                                                                 "  \"amount\": {\n" +
                                                                                 "    \"currency\": \"EUR\",\n" +
                                                                                 "    \"value\": 99792\n" +
                                                                                 "  },\n" +
                                                                                 "  \"accountHolderCode\": \"CODE_OF_ACCOUNT_HOLDER\",\n" +
                                                                                 "  \"description\": \"12345 – Test\",\n" +
                                                                                 "  \"bankAccountUUID\": \"000b81aa-ae7e-4492-aa7e-72b2129dce0c\"\n" +
                                                                                 "}");
        String jsonRequest = request.toJson();
        PayoutAccountHolderResponse response = PayoutAccountHolderResponse.fromJson("{\n" +
                                                                                    "  \"bankAccountUUID\": \"string\",\n" +
                                                                                    "  \"invalidFields\": [\n" +
                                                                                    "    {\n" +
                                                                                    "      \"errorCode\": 0,\n" +
                                                                                    "      \"errorDescription\": \"string\",\n" +
                                                                                    "      \"fieldType\": {\n" +
                                                                                    "        \"field\": \"string\",\n" +
                                                                                    "        \"fieldName\": \"accountCode\",\n" +
                                                                                    "        \"shareholderCode\": \"string\"\n" +
                                                                                    "      }\n" +
                                                                                    "    }\n" +
                                                                                    "  ],\n" +
                                                                                    "  \"merchantReference\": \"string\",\n" +
                                                                                    "  \"payoutSpeed\": \"STANDARD\",\n" +
                                                                                    "  \"pspReference\": \"string\",\n" +
                                                                                    "  \"resultCode\": \"string\"\n" +
                                                                                    "}");
        String json = response.toJson();
        Client client = createMockClientFromResponse(json);
        ClassicPlatformFundApi api = new ClassicPlatformFundApi(client);

        assertEquals(json, api.payoutAccountHolder(request).toJson());
        verify(client.getHttpClient()).request(
                "https://cal-test.adyen.com/cal/services/Fund/v6/payoutAccountHolder",
                jsonRequest,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }
}
