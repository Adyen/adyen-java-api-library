/**
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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.recurring;

import com.adyen.model.Card;
import com.adyen.model.recurring.Recurring;
import com.google.gson.annotations.SerializedName;

/**
 * StoreTokenRequest - This type contains data that should be passed in either prepareStoreToken or storeToken calls.
 */
public class StoreTokenRequest {

	@SerializedName("card")
	private Card card;

	@SerializedName("merchantAccount")
	private String merchantAccount;

	@SerializedName("pspEchoData")
	private String pspEchoData;

	@SerializedName("recurring")
	private Recurring recurring;

	@SerializedName("selectedBrand")
	private String selectedBrand;

	@SerializedName("shopperEmail")
	private String shopperEmail;

	@SerializedName("shopperIP")
	private String shopperIP;

	@SerializedName("shopperReference")
	private String shopperReference;

	@SerializedName("shopperStatement")
	private String shopperStatement;

	/**
	 * A container for card data.
	 *
	 * @return card
	 */
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public StoreTokenRequest card(Card card) {
		this.card = card;
		return this;
	}

	/**
	 * The merchant account identifier you want to process the (transaction) request with.
	 *
	 * @return merchantAccount
	 */
	public String getMerchantAccount() {
		return merchantAccount;
	}

	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}

	public StoreTokenRequest merchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
		return this;
	}

	/**
	 * The pspEchoData value received in the prepareStoreToken response.
	 *
	 * @return pspEchoData
	 */
	public String getPspEchoData() {
		return pspEchoData;
	}

	public void setPspEchoData(String pspEchoData) {
		this.pspEchoData = pspEchoData;
	}

	public StoreTokenRequest pspEchoData(String pspEchoData) {
		this.pspEchoData = pspEchoData;
		return this;
	}

	/**
	 * A container for the type of recurring contract to be retrieved. The recurring.contract must be set to "RECURRING".
	 *
	 * @return recurring
	 */
	public Recurring getRecurring() {
		return recurring;
	}

	public void setRecurring(Recurring recurring) {
		this.recurring = recurring;
	}

	public StoreTokenRequest recurring(Recurring recurring) {
		this.recurring = recurring;
		return this;
	}

	/**
	 * Some payment methods require defining a value for this field to specify how to process the transaction.
	 *
	 * @return selectedBrand
	 */
	public String getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public StoreTokenRequest selectedBrand(String selectedBrand) {
		this.selectedBrand = selectedBrand;
		return this;
	}

	/**
	 * The shopper's email address.
	 *
	 * @return shopperEmail
	 */
	public String getShopperEmail() {
		return shopperEmail;
	}

	public void setShopperEmail(String shopperEmail) {
		this.shopperEmail = shopperEmail;
	}

	public StoreTokenRequest shopperEmail(String shopperEmail) {
		this.shopperEmail = shopperEmail;
		return this;
	}

	/**
	 * The shopper's IP address.
	 *
	 * @return shopperIP
	 */
	public String getShopperIP() {
		return shopperIP;
	}

	public void setShopperIP(String shopperIP) {
		this.shopperIP = shopperIP;
	}

	public StoreTokenRequest shopperIP(String shopperIP) {
		this.shopperIP = shopperIP;
		return this;
	}

	/**
	 * The shopper's reference for the payment transaction.
	 *
	 * @return shopperReference
	 */
	public String getShopperReference() {
		return shopperReference;
	}

	public void setShopperReference(String shopperReference) {
		this.shopperReference = shopperReference;
	}

	public StoreTokenRequest shopperReference(String shopperReference) {
		this.shopperReference = shopperReference;
		return this;
	}

	/**
	 * The text to appear on a shopper's statement.
	 *
	 * @return shopperStatement
	 */
	public String getShopperStatement() {
		return shopperStatement;
	}

	public void setShopperStatement(String shopperStatement) {
		this.shopperStatement = shopperStatement;
	}

	public StoreTokenRequest shopperStatement(String shopperStatement) {
		this.shopperStatement = shopperStatement;
		return this;
	}

	public StoreTokenRequest setCardData(String cardNumber, String cardHolder, String expiryMonth, String expiryYear, String cvc) {
		Card card = new Card();
		card.setExpiryMonth(expiryMonth);
		card.setExpiryYear(expiryYear);
		card.setHolderName(cardHolder);
		card.setNumber(cardNumber);
		card.setCvc(cvc);

		this.setCard(card);
		return this;
	}

	public StoreTokenRequest setContractToRecurring() {
		setRecurring(new Recurring().contract(Recurring.ContractEnum.RECURRING));
		return this;
	}

	public StoreTokenRequest setContractToOneClick() {
		setRecurring(new Recurring().contract(Recurring.ContractEnum.ONECLICK));
		return this;
	}

	public StoreTokenRequest setContractToOneClickRecurring() {
		setRecurring(new Recurring().contract(Recurring.ContractEnum.ONECLICK_RECURRING));
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[merchantAccount=").append(merchantAccount);
		sb.append(", shopperReference=").append(shopperReference);
		sb.append(", shopperEmail=").append(shopperEmail);
		sb.append(", hasCard=").append(card != null);
		sb.append(", selectedBrand=").append(selectedBrand);
		sb.append(", shopperStatement=").append(shopperStatement);
		sb.append("]");
		return sb.toString();
	}

}
