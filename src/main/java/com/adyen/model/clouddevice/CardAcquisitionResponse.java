package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

/**
 * Content of the Card Acquisition Response message.
 */
@JsonPropertyOrder({
		"Response",
		"SaleData",
		"POIData",
		"PaymentBrand",
		"PaymentInstrumentData",
		"LoyaltyAccount",
		"CustomerOrder"
})
public class CardAcquisitionResponse {

	@JsonProperty("Response")
	@Schema(description = "Result of a message request processing.")
	protected Response response;

	@JsonProperty("SaleData")
	@Schema(description = "Data related to the Sale System.")
	protected SaleData saleData;

	@JsonProperty("POIData")
	@Schema(description = "Data related to the POI System.")
	protected POIData poiData;

	@JsonProperty("PaymentBrand")
	@Schema(
			description =
					"Type of payment card --Rule: Brands available for payment by the card and not chosen by the Customer")
	protected List<String> paymentBrand;

	@JsonProperty("PaymentInstrumentData")
	@Schema(
			description =
					"Data related to the instrument of payment for the transaction. --Rule: If this type of payment card is configured to send information if the CardAcquisition response")
	protected PaymentInstrumentData paymentInstrumentData;

	@JsonProperty("LoyaltyAccount")
	@Schema(
			description =
					"Data related to a loyalty account processed in the transaction. --Rule: If loyalty card selected by the customer")
	protected List<LoyaltyAccount> loyaltyAccount;

	@JsonProperty("CustomerOrder")
	@Schema(
			description =
					"Customer order attached to a card, recorded in the POI system. --Rule: If the list of customer orders has been requested.")
	protected List<CustomerOrder> customerOrder;

	/**
	 * Gets response.
	 *
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Sets response.
	 *
	 * @param response the response
	 */
	public void setResponse(Response response) {
		this.response = response;
	}

	/**
	 * Gets sale data.
	 *
	 * @return the sale data
	 */
	public SaleData getSaleData() {
		return saleData;
	}

	/**
	 * Sets sale data.
	 *
	 * @param saleData the sale data
	 */
	public void setSaleData(SaleData saleData) {
		this.saleData = saleData;
	}

	/**
	 * Gets poi data.
	 *
	 * @return the poi data
	 */
	public POIData getPOIData() {
		return poiData;
	}

	/**
	 * Sets poi data.
	 *
	 * @param poiData the poi data
	 */
	public void setPOIData(POIData poiData) {
		this.poiData = poiData;
	}

	/**
	 * Gets payment brand.
	 *
	 * @return the payment brand
	 */
	public List<String> getPaymentBrand() {
		if (paymentBrand == null) {
			paymentBrand = new ArrayList<>();
		}
		return this.paymentBrand;
	}

	/**
	 * Sets payment brand.
	 *
	 * @param paymentBrand the payment brand
	 */
	public void setPaymentBrand(List<String> paymentBrand) {
		this.paymentBrand = paymentBrand;
	}

	/**
	 * Gets payment instrument data.
	 *
	 * @return the payment instrument data
	 */
	public PaymentInstrumentData getPaymentInstrumentData() {
		return paymentInstrumentData;
	}

	/**
	 * Sets payment instrument data.
	 *
	 * @param paymentInstrumentData the payment instrument data
	 */
	public void setPaymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
		this.paymentInstrumentData = paymentInstrumentData;
	}

	/**
	 * Gets loyalty account.
	 *
	 * @return the loyalty account
	 */
	public List<LoyaltyAccount> getLoyaltyAccount() {
		if (loyaltyAccount == null) {
			loyaltyAccount = new ArrayList<>();
		}
		return this.loyaltyAccount;
	}

	/**
	 * Sets loyalty account.
	 *
	 * @param loyaltyAccount the loyalty account
	 */
	public void setLoyaltyAccount(List<LoyaltyAccount> loyaltyAccount) {
		this.loyaltyAccount = loyaltyAccount;
	}

	/**
	 * Gets customer order.
	 *
	 * @return the customer order
	 */
	public List<CustomerOrder> getCustomerOrder() {
		if (customerOrder == null) {
			customerOrder = new ArrayList<>();
		}
		return this.customerOrder;
	}

	/**
	 * Sets customer order.
	 *
	 * @param customerOrder the customer order
	 */
	public void setCustomerOrder(List<CustomerOrder> customerOrder) {
		this.customerOrder = customerOrder;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CardAcquisitionResponse {\n");
		sb.append("    response: ").append(toIndentedString(response)).append("\n");
		sb.append("    saleData: ").append(toIndentedString(saleData)).append("\n");
		sb.append("    poiData: ").append(toIndentedString(poiData)).append("\n");
		sb.append("    paymentBrand: ").append(toIndentedString(paymentBrand)).append("\n");
		sb.append("    paymentInstrumentData: ").append(toIndentedString(paymentInstrumentData)).append("\n");
		sb.append("    loyaltyAccount: ").append(toIndentedString(loyaltyAccount)).append("\n");
		sb.append("    customerOrder: ").append(toIndentedString(customerOrder)).append("\n");
		sb.append("}\n");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}