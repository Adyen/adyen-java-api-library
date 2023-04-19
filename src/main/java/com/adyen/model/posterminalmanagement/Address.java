
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

package com.adyen.model.posterminalmanagement;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Address
 */

public class Address {
    @SerializedName("city")
    private String city = null;

    @SerializedName("countryCode")
    private String countryCode = null;

    @SerializedName("postalCode")
    private String postalCode = null;

    @SerializedName("stateOrProvince")
    private String stateOrProvince = null;

    @SerializedName("streetAddress")
    private String streetAddress = null;

    @SerializedName("streetAddress2")
    private String streetAddress2 = null;

    public Address city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Get city
     *
     * @return city
     **/
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Get countryCode
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Address postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Get postalCode
     *
     * @return postalCode
     **/
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address stateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
        return this;
    }

    /**
     * Get stateOrProvince
     *
     * @return stateOrProvince
     **/
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public Address streetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    /**
     * Get streetAddress
     *
     * @return streetAddress
     **/
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Address streetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
        return this;
    }

    /**
     * Get streetAddress2
     *
     * @return streetAddress2
     **/
    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(this.city, address.city) &&
                Objects.equals(this.countryCode, address.countryCode) &&
                Objects.equals(this.postalCode, address.postalCode) &&
                Objects.equals(this.stateOrProvince, address.stateOrProvince) &&
                Objects.equals(this.streetAddress, address.streetAddress) &&
                Objects.equals(this.streetAddress2, address.streetAddress2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, countryCode, postalCode, stateOrProvince, streetAddress, streetAddress2);
    }


    @Override
    public String toString() {

        String sb = "class Address {\n" +
                "    city: " + toIndentedString(city) + "\n" +
                "    countryCode: " + toIndentedString(countryCode) + "\n" +
                "    postalCode: " + toIndentedString(postalCode) + "\n" +
                "    stateOrProvince: " + toIndentedString(stateOrProvince) + "\n" +
                "    streetAddress: " + toIndentedString(streetAddress) + "\n" +
                "    streetAddress2: " + toIndentedString(streetAddress2) + "\n" +
                "}";
        return sb;
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
