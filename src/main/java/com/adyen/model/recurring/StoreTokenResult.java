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

import com.google.gson.annotations.SerializedName;

/**
 * StoreTokenResult - This type contains data that can be returned in response to either prepareStoreToken or storeToken calls.
 */
public class StoreTokenResult {

	@SerializedName("alias")
	private String alias;

	@SerializedName("aliasType")
	private String aliasType;

	@SerializedName("pspEchoData")
	private String pspEchoData;

	@SerializedName("pspReference")
	private String pspReference;

	@SerializedName("recurringDetailReference")
	private String recurringDetailReference;

	@SerializedName("redirectType")
	private String redirectType;

	@SerializedName("redirectUrl")
	private String redirectUrl;

	@SerializedName("result")
	private String result;

	/**
	 * The alias of the credit card number. It is a unique alphanumeric identifier for the card.
	 *
	 * @return alias
	 */
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public StoreTokenResult alias(String alias) {
		this.alias = alias;
		return this;
	}

	/**
	 * The alias type of the credit card number. Allowed values: Default and BinLetterRandomLastFour. The alias type depends on your account configuration.
	 *
	 * @return aliasType
	 */
	public String getAliasType() {
		return aliasType;
	}

	public void setAliasType(String aliasType) {
		this.aliasType = aliasType;
	}

	public StoreTokenResult aliasType(String aliasType) {
		this.aliasType = aliasType;
		return this;
	}

	/**
	 * A data blob that must be submitted in the storeToken request.
	 *
	 * @return pspEchoData
	 */
	public String getPspEchoData() {
		return pspEchoData;
	}

	public void setPspEchoData(String pspEchoData) {
		this.pspEchoData = pspEchoData;
	}

	public StoreTokenResult pspEchoData(String pspEchoData) {
		this.pspEchoData = pspEchoData;
		return this;
	}

	/**
	 * A reference to uniquely identify the request.
	 *
	 * @return pspReference
	 */
	public String getPspReference() {
		return pspReference;
	}

	public void setPspReference(String pspReference) {
		this.pspReference = pspReference;
	}

	public StoreTokenResult pspReference(String pspReference) {
		this.pspReference = pspReference;
		return this;
	}

	/**
	 * The reference that uniquely identifies the recurring detail.
	 *
	 * @return recurringDetailReference
	 */
	public String getRecurringDetailReference() {
		return recurringDetailReference;
	}

	public void setRecurringDetailReference(String recurringDetailReference) {
		this.recurringDetailReference = recurringDetailReference;
	}

	public StoreTokenResult recurringDetailReference(String recurringDetailReference) {
		this.recurringDetailReference = recurringDetailReference;
		return this;
	}

	public String getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(String redirectType) {
		this.redirectType = redirectType;
	}

	public StoreTokenResult redirectType(String redirectType) {
		this.redirectType = redirectType;
		return this;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public StoreTokenResult redirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
		return this;
	}

	/**
	 *
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public StoreTokenResult result(String result) {
		this.result = result;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("pspReference=").append(pspReference);
		sb.append(", recurringDetailReference=").append(recurringDetailReference);
		sb.append(", result=").append(result);
		sb.append(", alias=").append(alias);
		sb.append(", aliasType=").append(aliasType);
		sb.append(", redirectUrl=").append(redirectUrl);
		sb.append(", redirectType=").append(redirectType);
		sb.append("]");
		return sb.toString();
	}

}
