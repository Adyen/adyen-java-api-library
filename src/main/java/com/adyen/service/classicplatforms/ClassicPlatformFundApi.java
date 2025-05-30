/*
 * Fund API
 * This API is used for the classic integration. If you are just starting your implementation, refer to our [new integration guide](https://docs.adyen.com/marketplaces-and-platforms) instead.  The Fund API provides endpoints for managing the funds in the accounts on your platform. These management operations include, for example, the transfer of funds from one account to another, the payout of funds to an account holder, and the retrieval of balances in an account.  For more information, refer to our [documentation](https://docs.adyen.com/marketplaces-and-platforms/classic/). ## Authentication Your Adyen contact will provide your API credential and an API key. To connect to the API, add an `X-API-Key` header with the API key as the value, for example:   ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: YOUR_API_KEY\" \\ ... ```  Alternatively, you can use the username and password to connect to the API using basic authentication. For example:  ``` curl -U \"ws@MarketPlace.YOUR_PLATFORM_ACCOUNT\":\"YOUR_WS_PASSWORD\" \\ -H \"Content-Type: application/json\" \\ ... ``` When going live, you need to generate new web service user credentials to access the [live endpoints](https://docs.adyen.com/development-resources/live-endpoints).  ## Versioning The Fund API supports [versioning](https://docs.adyen.com/development-resources/versioning) using a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://cal-test.adyen.com/cal/services/Fund/v6/accountHolderBalance ```
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.classicplatforms;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.marketpayfund.AccountHolderBalanceRequest;
import com.adyen.model.marketpayfund.AccountHolderBalanceResponse;
import com.adyen.model.marketpayfund.AccountHolderTransactionListRequest;
import com.adyen.model.marketpayfund.AccountHolderTransactionListResponse;
import com.adyen.model.marketpayfund.DebitAccountHolderRequest;
import com.adyen.model.marketpayfund.DebitAccountHolderResponse;
import com.adyen.model.marketpayfund.PayoutAccountHolderRequest;
import com.adyen.model.marketpayfund.PayoutAccountHolderResponse;
import com.adyen.model.marketpayfund.RefundFundsTransferRequest;
import com.adyen.model.marketpayfund.RefundFundsTransferResponse;
import com.adyen.model.marketpayfund.RefundNotPaidOutTransfersRequest;
import com.adyen.model.marketpayfund.RefundNotPaidOutTransfersResponse;
import com.adyen.model.marketpayfund.SetupBeneficiaryRequest;
import com.adyen.model.marketpayfund.SetupBeneficiaryResponse;
import com.adyen.model.marketpayfund.TransferFundsRequest;
import com.adyen.model.marketpayfund.TransferFundsResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;

public class ClassicPlatformFundApi extends Service {

  public static final String API_VERSION = "6";

  protected String baseURL;

  /**
   * General constructor in {@link com.adyen.service package}.
   *
   * @param client {@link Client } (required)
   */
  public ClassicPlatformFundApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://cal-test.adyen.com/cal/services/Fund/v6");
  }

  /**
   * General constructor in {@link com.adyen.service package}. Please use this constructor only if
   * you would like to pass along your own url for routing or testing purposes. The latest API
   * version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public ClassicPlatformFundApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Get the balances of an account holder
   *
   * @param accountHolderBalanceRequest {@link AccountHolderBalanceRequest } (required)
   * @return {@link AccountHolderBalanceResponse }
   * @throws ApiException if fails to make API call
   */
  public AccountHolderBalanceResponse accountHolderBalance(
      AccountHolderBalanceRequest accountHolderBalanceRequest) throws ApiException, IOException {
    return accountHolderBalance(accountHolderBalanceRequest, null);
  }

  /**
   * Get the balances of an account holder
   *
   * @param accountHolderBalanceRequest {@link AccountHolderBalanceRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link AccountHolderBalanceResponse }
   * @throws ApiException if fails to make API call
   */
  public AccountHolderBalanceResponse accountHolderBalance(
      AccountHolderBalanceRequest accountHolderBalanceRequest, RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = accountHolderBalanceRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/accountHolderBalance", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return AccountHolderBalanceResponse.fromJson(jsonResult);
  }

  /**
   * Get a list of transactions
   *
   * @param accountHolderTransactionListRequest {@link AccountHolderTransactionListRequest }
   *     (required)
   * @return {@link AccountHolderTransactionListResponse }
   * @throws ApiException if fails to make API call
   */
  public AccountHolderTransactionListResponse accountHolderTransactionList(
      AccountHolderTransactionListRequest accountHolderTransactionListRequest)
      throws ApiException, IOException {
    return accountHolderTransactionList(accountHolderTransactionListRequest, null);
  }

  /**
   * Get a list of transactions
   *
   * @param accountHolderTransactionListRequest {@link AccountHolderTransactionListRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link AccountHolderTransactionListResponse }
   * @throws ApiException if fails to make API call
   */
  public AccountHolderTransactionListResponse accountHolderTransactionList(
      AccountHolderTransactionListRequest accountHolderTransactionListRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = accountHolderTransactionListRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/accountHolderTransactionList", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return AccountHolderTransactionListResponse.fromJson(jsonResult);
  }

  /**
   * Send a direct debit request
   *
   * @param debitAccountHolderRequest {@link DebitAccountHolderRequest } (required)
   * @return {@link DebitAccountHolderResponse }
   * @throws ApiException if fails to make API call
   */
  public DebitAccountHolderResponse debitAccountHolder(
      DebitAccountHolderRequest debitAccountHolderRequest) throws ApiException, IOException {
    return debitAccountHolder(debitAccountHolderRequest, null);
  }

  /**
   * Send a direct debit request
   *
   * @param debitAccountHolderRequest {@link DebitAccountHolderRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link DebitAccountHolderResponse }
   * @throws ApiException if fails to make API call
   */
  public DebitAccountHolderResponse debitAccountHolder(
      DebitAccountHolderRequest debitAccountHolderRequest, RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = debitAccountHolderRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/debitAccountHolder", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return DebitAccountHolderResponse.fromJson(jsonResult);
  }

  /**
   * Pay out from an account to the account holder
   *
   * @param payoutAccountHolderRequest {@link PayoutAccountHolderRequest } (required)
   * @return {@link PayoutAccountHolderResponse }
   * @throws ApiException if fails to make API call
   */
  public PayoutAccountHolderResponse payoutAccountHolder(
      PayoutAccountHolderRequest payoutAccountHolderRequest) throws ApiException, IOException {
    return payoutAccountHolder(payoutAccountHolderRequest, null);
  }

  /**
   * Pay out from an account to the account holder
   *
   * @param payoutAccountHolderRequest {@link PayoutAccountHolderRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link PayoutAccountHolderResponse }
   * @throws ApiException if fails to make API call
   */
  public PayoutAccountHolderResponse payoutAccountHolder(
      PayoutAccountHolderRequest payoutAccountHolderRequest, RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = payoutAccountHolderRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/payoutAccountHolder", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return PayoutAccountHolderResponse.fromJson(jsonResult);
  }

  /**
   * Refund a funds transfer
   *
   * @param refundFundsTransferRequest {@link RefundFundsTransferRequest } (required)
   * @return {@link RefundFundsTransferResponse }
   * @throws ApiException if fails to make API call
   */
  public RefundFundsTransferResponse refundFundsTransfer(
      RefundFundsTransferRequest refundFundsTransferRequest) throws ApiException, IOException {
    return refundFundsTransfer(refundFundsTransferRequest, null);
  }

  /**
   * Refund a funds transfer
   *
   * @param refundFundsTransferRequest {@link RefundFundsTransferRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link RefundFundsTransferResponse }
   * @throws ApiException if fails to make API call
   */
  public RefundFundsTransferResponse refundFundsTransfer(
      RefundFundsTransferRequest refundFundsTransferRequest, RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = refundFundsTransferRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/refundFundsTransfer", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return RefundFundsTransferResponse.fromJson(jsonResult);
  }

  /**
   * Refund all transactions of an account since the most recent payout
   *
   * @param refundNotPaidOutTransfersRequest {@link RefundNotPaidOutTransfersRequest } (required)
   * @return {@link RefundNotPaidOutTransfersResponse }
   * @throws ApiException if fails to make API call
   */
  public RefundNotPaidOutTransfersResponse refundNotPaidOutTransfers(
      RefundNotPaidOutTransfersRequest refundNotPaidOutTransfersRequest)
      throws ApiException, IOException {
    return refundNotPaidOutTransfers(refundNotPaidOutTransfersRequest, null);
  }

  /**
   * Refund all transactions of an account since the most recent payout
   *
   * @param refundNotPaidOutTransfersRequest {@link RefundNotPaidOutTransfersRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link RefundNotPaidOutTransfersResponse }
   * @throws ApiException if fails to make API call
   */
  public RefundNotPaidOutTransfersResponse refundNotPaidOutTransfers(
      RefundNotPaidOutTransfersRequest refundNotPaidOutTransfersRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = refundNotPaidOutTransfersRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/refundNotPaidOutTransfers", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return RefundNotPaidOutTransfersResponse.fromJson(jsonResult);
  }

  /**
   * Designate a beneficiary account and transfer the benefactor&#39;s current balance
   *
   * @param setupBeneficiaryRequest {@link SetupBeneficiaryRequest } (required)
   * @return {@link SetupBeneficiaryResponse }
   * @throws ApiException if fails to make API call
   */
  public SetupBeneficiaryResponse setupBeneficiary(SetupBeneficiaryRequest setupBeneficiaryRequest)
      throws ApiException, IOException {
    return setupBeneficiary(setupBeneficiaryRequest, null);
  }

  /**
   * Designate a beneficiary account and transfer the benefactor&#39;s current balance
   *
   * @param setupBeneficiaryRequest {@link SetupBeneficiaryRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SetupBeneficiaryResponse }
   * @throws ApiException if fails to make API call
   */
  public SetupBeneficiaryResponse setupBeneficiary(
      SetupBeneficiaryRequest setupBeneficiaryRequest, RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = setupBeneficiaryRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/setupBeneficiary", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return SetupBeneficiaryResponse.fromJson(jsonResult);
  }

  /**
   * Transfer funds between platform accounts
   *
   * @param transferFundsRequest {@link TransferFundsRequest } (required)
   * @return {@link TransferFundsResponse }
   * @throws ApiException if fails to make API call
   */
  public TransferFundsResponse transferFunds(TransferFundsRequest transferFundsRequest)
      throws ApiException, IOException {
    return transferFunds(transferFundsRequest, null);
  }

  /**
   * Transfer funds between platform accounts
   *
   * @param transferFundsRequest {@link TransferFundsRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link TransferFundsResponse }
   * @throws ApiException if fails to make API call
   */
  public TransferFundsResponse transferFunds(
      TransferFundsRequest transferFundsRequest, RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = transferFundsRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/transferFunds", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return TransferFundsResponse.fromJson(jsonResult);
  }
}
