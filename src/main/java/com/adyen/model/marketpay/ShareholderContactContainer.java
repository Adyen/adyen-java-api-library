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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * ShareholderContact Container
 */
public class ShareholderContactContainer {
    @SerializedName("ShareholderContact")
    private ShareholderContact shareholderContact = null;

    /**
     * shareholderContact
     *
     * @return bankAccountDetail
     */
    public ShareholderContact getShareholderContact() {
        return shareholderContact;
    }

    public void setShareholderContact(ShareholderContact shareholderContact) {
        this.shareholderContact = shareholderContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShareholderContactContainer shareholderContactContainer = (ShareholderContactContainer) o;
        return Objects.equals(this.shareholderContact, shareholderContactContainer.shareholderContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shareholderContact);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ShareholderContactContainer {\n");

        sb.append("    shareholderContact: ").append(toIndentedString(shareholderContact)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
