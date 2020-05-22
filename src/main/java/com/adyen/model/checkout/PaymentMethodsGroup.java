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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.adyen.constants.TextConstants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentMethodsGroup
 */
public class PaymentMethodsGroup {

    @SerializedName("groupType")
    private String groupType = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("types")
    private List<String> types = null;

    public PaymentMethodsGroup groupType(String groupType) {
        this.groupType = groupType;
        return this;
    }

    /**
     * The type to submit for any payment method in this group.
     *
     * @return groupType
     **/
    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public PaymentMethodsGroup name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The human-readable name of this group.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentMethodsGroup types(List<String> types) {
        this.types = types;
        return this;
    }

    public PaymentMethodsGroup addTypesItem(String typesItem) {
        if (this.types == null) {
            this.types = new ArrayList<>();
        }
        this.types.add(typesItem);
        return this;
    }

    /**
     * The types of payment methods that belong in this group.
     *
     * @return types
     **/
    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethodsGroup paymentMethodsGroup = (PaymentMethodsGroup) o;
        return Objects.equals(this.groupType, paymentMethodsGroup.groupType) &&
                Objects.equals(this.name, paymentMethodsGroup.name) &&
                Objects.equals(this.types, paymentMethodsGroup.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupType, name, types);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethodsGroup {").append(TextConstants.LINE_BREAK);

        sb.append("    groupType: ").append(toIndentedString(groupType)).append(TextConstants.LINE_BREAK);
        sb.append("    name: ").append(toIndentedString(name)).append(TextConstants.LINE_BREAK);
        sb.append("    types: ").append(toIndentedString(types)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
