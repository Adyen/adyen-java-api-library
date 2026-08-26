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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.documentcollector.DocumentContext;
import com.adyen.model.documentcollector.DocumentUploadResponse;
import com.adyen.service.documentcollector.DocumentsApi;
import java.io.File;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class DocumentCollectorServiceTest extends BaseTest {

  private static final String MERCHANT_ACCOUNT = "YourMerchantAccount";
  private static final File INVOICE = new File("QRMJC25GDZRKDM92.pdf");

  @Test
  public void baseUrlOnTest() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.TEST));

    DocumentsApi documentsApi = new DocumentsApi(client);

    assertEquals("https://document-collector-test.adyen.com/v1", getBaseURL(documentsApi));
  }

  @Test
  public void baseUrlOnLive() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    DocumentsApi documentsApi = new DocumentsApi(client);

    assertEquals("https://document-collector-live.adyen.com/v1", getBaseURL(documentsApi));
  }

  @Test
  public void baseUrlOnCustomUrl() throws NoSuchFieldException, IllegalAccessException {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    DocumentsApi documentsApi = new DocumentsApi(client, "https://internal-proxy.example.com/v1");

    assertEquals("https://internal-proxy.example.com/v1", getBaseURL(documentsApi));
  }

  /** Test success flow for POST /crossBorderInvoices */
  @Test
  public void TestUploadCrossBorderInvoiceSuccessMocked() throws Exception {
    Client client =
        createMockClientFromFile(
            "mocks/documentcollector/upload-cross-border-invoice-success.json");
    DocumentsApi documentsApi = new DocumentsApi(client);

    DocumentUploadResponse response =
        documentsApi.uploadCrossBorderInvoice(
            DocumentContext.PACBINVOICE, INVOICE, MERCHANT_ACCOUNT);

    verify(client.getHttpClient())
        .requestMultipart(
            "https://document-collector-test.adyen.com/v1/crossBorderInvoices",
            createExpectedFormParams(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
    assertEquals("paCbInvoice", response.getContext());
    assertEquals("QRMJC25GDZRKDM92.pdf", response.getFileName());
    assertEquals(MERCHANT_ACCOUNT, response.getMerchantAccount());
    assertEquals("QRMJC25GDZRKDM92", response.getPspReference());
  }

  /** Test that POST /crossBorderInvoices targets the live endpoint on a live client */
  @Test
  public void TestUploadCrossBorderInvoiceOnLiveMocked() throws Exception {
    Client client =
        createMockClientFromFile(
            "mocks/documentcollector/upload-cross-border-invoice-success.json");
    client.getConfig().setEnvironment(Environment.LIVE);
    DocumentsApi documentsApi = new DocumentsApi(client);

    documentsApi.uploadCrossBorderInvoice(DocumentContext.PACBINVOICE, INVOICE, MERCHANT_ACCOUNT);

    verify(client.getHttpClient())
        .requestMultipart(
            "https://document-collector-live.adyen.com/v1/crossBorderInvoices",
            createExpectedFormParams(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  protected Map<String, Object> createExpectedFormParams() {
    Map<String, Object> formParams = new LinkedHashMap<>();
    formParams.put("context", DocumentContext.PACBINVOICE);
    formParams.put("file", INVOICE);
    formParams.put("merchantAccount", MERCHANT_ACCOUNT);

    return formParams;
  }

  private String getBaseURL(DocumentsApi documentsApi)
      throws NoSuchFieldException, IllegalAccessException {
    // get field by reflection (it is protected)
    Field baseURLField = DocumentsApi.class.getDeclaredField("baseURL");
    baseURLField.setAccessible(true);

    return (String) baseURLField.get(documentsApi);
  }
}
