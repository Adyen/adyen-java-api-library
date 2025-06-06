/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.checkout;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.DonationCampaignsRequest;
import com.adyen.model.checkout.DonationCampaignsResponse;
import com.adyen.model.checkout.DonationPaymentRequest;
import com.adyen.model.checkout.DonationPaymentResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;

public class DonationsApi extends Service {

  public static final String API_VERSION = "71";

  protected String baseURL;

  /**
   * Donations constructor in {@link com.adyen.service.checkout package}.
   *
   * @param client {@link Client } (required)
   */
  public DonationsApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://checkout-test.adyen.com/v71");
  }

  /**
   * Donations constructor in {@link com.adyen.service.checkout package}. Please use this
   * constructor only if you would like to pass along your own url for routing or testing purposes.
   * The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public DonationsApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Get a list of donation campaigns.
   *
   * @param donationCampaignsRequest {@link DonationCampaignsRequest } (required)
   * @return {@link DonationCampaignsResponse }
   * @throws ApiException if fails to make API call
   */
  public DonationCampaignsResponse donationCampaigns(
      DonationCampaignsRequest donationCampaignsRequest) throws ApiException, IOException {
    return donationCampaigns(donationCampaignsRequest, null);
  }

  /**
   * Get a list of donation campaigns.
   *
   * @param donationCampaignsRequest {@link DonationCampaignsRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link DonationCampaignsResponse }
   * @throws ApiException if fails to make API call
   */
  public DonationCampaignsResponse donationCampaigns(
      DonationCampaignsRequest donationCampaignsRequest, RequestOptions requestOptions)
      throws ApiException, IOException {
    String requestBody = donationCampaignsRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/donationCampaigns", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return DonationCampaignsResponse.fromJson(jsonResult);
  }

  /**
   * Start a transaction for donations
   *
   * @param donationPaymentRequest {@link DonationPaymentRequest } (required)
   * @return {@link DonationPaymentResponse }
   * @throws ApiException if fails to make API call
   */
  public DonationPaymentResponse donations(DonationPaymentRequest donationPaymentRequest)
      throws ApiException, IOException {
    return donations(donationPaymentRequest, null);
  }

  /**
   * Start a transaction for donations
   *
   * @param donationPaymentRequest {@link DonationPaymentRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link DonationPaymentResponse }
   * @throws ApiException if fails to make API call
   */
  public DonationPaymentResponse donations(
      DonationPaymentRequest donationPaymentRequest, RequestOptions requestOptions)
      throws ApiException, IOException {
    String requestBody = donationPaymentRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/donations", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return DonationPaymentResponse.fromJson(jsonResult);
  }
}
