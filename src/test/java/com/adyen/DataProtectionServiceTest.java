/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.dataprotection.SubjectErasureByPspReferenceRequest;
import com.adyen.model.dataprotection.SubjectErasureResponse;
import com.adyen.service.dataprotection.DataProtectionApi;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class DataProtectionServiceTest extends BaseTest {

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.TEST));

    DataProtectionApi dataProtectionApi = new DataProtectionApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = DataProtectionApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(dataProtectionApi);
    assertEquals("https://ca-test.adyen.com/ca/services/DataProtectionService/v1", baseURL);
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    DataProtectionApi dataProtectionApi = new DataProtectionApi(client);
    // get field by reflection (it is protected)
    Field baseURLField = DataProtectionApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);
    String baseURL = (String) baseURLField.get(dataProtectionApi);
    assertEquals("https://ca-live.adyen.com/ca/services/DataProtectionService/v1", baseURL);
  }

  /** Test success flow for POST /requestSubjectErasure */
  @Test
  public void TestRequestSubjectErasureSuccessMocked() throws Exception {
    Client client = createMockClientFromFile("mocks/request-subject-erasure-success.json");
    DataProtectionApi dataProtection = new DataProtectionApi(client);
    SubjectErasureByPspReferenceRequest subjectErasureRequest =
        new SubjectErasureByPspReferenceRequest();

    SubjectErasureResponse subjectErasureResponse =
        dataProtection.requestSubjectErasure(subjectErasureRequest);

    verify(client.getHttpClient())
        .request(
            "https://ca-test.adyen.com/ca/services/DataProtectionService/v1/requestSubjectErasure",
            "{}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
    assertEquals(SubjectErasureResponse.ResultEnum.SUCCESS, subjectErasureResponse.getResult());
  }

  protected SubjectErasureByPspReferenceRequest createSubjectErasureRequest() {
    SubjectErasureByPspReferenceRequest subjectErasureRequest =
        new SubjectErasureByPspReferenceRequest();
    subjectErasureRequest.setForceErasure(false);
    subjectErasureRequest.setMerchantAccount("Test");
    subjectErasureRequest.setPspReference("123456");

    return subjectErasureRequest;
  }

  @Test
  public void TestGetAuthenticationResultErrorNotFound() throws IOException, ApiException {
    Client client = createMockClientFromFile("mocks/request-subject-erasure-not-found.json");
    DataProtectionApi dataProtection = new DataProtectionApi(client);
    SubjectErasureByPspReferenceRequest subjectErasureRequest = createSubjectErasureRequest();

    SubjectErasureResponse subjectErasureResponse =
        dataProtection.requestSubjectErasure(subjectErasureRequest);

    assertEquals(
        SubjectErasureResponse.ResultEnum.PAYMENT_NOT_FOUND, subjectErasureResponse.getResult());
  }
}
