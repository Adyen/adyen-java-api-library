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
package com.adyen.model;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Address
 */
public class Address {
    @SerializedName("city")
    private String city = null;

    @SerializedName("country")
    private String country = null;

    @SerializedName("houseNumberOrName")
    private String houseNumberOrName = null;

    @SerializedName("postalCode")
    private String postalCode = null;

    @SerializedName("stateOrProvince")
    private String stateOrProvince = null;

    @SerializedName("street")
    private String street = null;

    public Address city(String city) {
        this.city = city;
        return this;
    }

    /**
     * the city
     *
     * @return city
     **/
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address country(String country) {
        this.country = country;
        return this;
    }

    /**
     * the two letter country code (ISO 3166-1)
     *
     * @return country
     **/
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address houseNumberOrName(String houseNumberOrName) {
        this.houseNumberOrName = houseNumberOrName;
        return this;
    }

    /**
     * the house number or name
     *
     * @return houseNumberOrName
     **/
    public String getHouseNumberOrName() {
        return houseNumberOrName;
    }

    public void setHouseNumberOrName(String houseNumberOrName) {
        this.houseNumberOrName = houseNumberOrName;
    }

    public Address postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * the postal / zip code
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
     * the state or province
     *
     * @return stateOrProvince
     **/
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    /**
     * the street name
     *
     * @return street
     **/
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(this.city, address.city)
                && Objects.equals(this.country, address.country)
                && Objects.equals(this.houseNumberOrName, address.houseNumberOrName)
                && Objects.equals(this.postalCode, address.postalCode)
                && Objects.equals(this.stateOrProvince, address.stateOrProvince)
                && Objects.equals(this.street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, houseNumberOrName, postalCode, stateOrProvince, street);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Address {").append(TextConstants.LINE_BREAK);

        sb.append("    city: ").append(Util.toIndentedString(city)).append(TextConstants.LINE_BREAK);
        sb.append("    country: ").append(Util.toIndentedString(country)).append(TextConstants.LINE_BREAK);
        sb.append("    houseNumberOrName: ").append(Util.toIndentedString(houseNumberOrName)).append(TextConstants.LINE_BREAK);
        sb.append("    postalCode: ").append(Util.toIndentedString(postalCode)).append(TextConstants.LINE_BREAK);
        sb.append("    stateOrProvince: ").append(Util.toIndentedString(stateOrProvince)).append(TextConstants.LINE_BREAK);
        sb.append("    street: ").append(Util.toIndentedString(street)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

