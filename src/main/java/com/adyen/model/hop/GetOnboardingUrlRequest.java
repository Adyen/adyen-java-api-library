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

package com.adyen.model.hop;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * GetOnboardingUrlRequest
 */

public class GetOnboardingUrlRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("editMode")
    private Boolean editMode = null;

    @SerializedName("platformName")
    private String platformName = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    public GetOnboardingUrlRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The account holder code you provided when you created the account holder.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public GetOnboardingUrlRequest editMode(Boolean editMode) {
        this.editMode = editMode;
        return this;
    }

    /**
     * Allows editing checks even if all the checks have passed.
     *
     * @return editMode
     **/
    public Boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(Boolean editMode) {
        this.editMode = editMode;
    }

    public GetOnboardingUrlRequest platformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    /**
     * The platform name which will show up in the welcome page.
     *
     * @return platformName
     **/
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public GetOnboardingUrlRequest returnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * The URL where the sub-merchant will be redirected back to after they complete the onboarding, or if their session times out. Maximum length of 500 characters. If you don&#x27;t provide this, the sub-merchant will be redirected back to the default return URL configured in your platform account.
     *
     * @return returnUrl
     **/
    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetOnboardingUrlRequest getOnboardingUrlRequest = (GetOnboardingUrlRequest) o;
        return Objects.equals(this.accountHolderCode, getOnboardingUrlRequest.accountHolderCode) &&
                Objects.equals(this.editMode, getOnboardingUrlRequest.editMode) &&
                Objects.equals(this.platformName, getOnboardingUrlRequest.platformName) &&
                Objects.equals(this.returnUrl, getOnboardingUrlRequest.returnUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, editMode, platformName, returnUrl);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetOnboardingUrlRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    editMode: ").append(toIndentedString(editMode)).append("\n");
        sb.append("    platformName: ").append(toIndentedString(platformName)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("}");
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
