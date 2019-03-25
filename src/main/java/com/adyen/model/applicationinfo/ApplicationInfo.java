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
package com.adyen.model.applicationinfo;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;

public class ApplicationInfo {
    @SerializedName("adyenLibrary")
    private CommonField adyenLibrary ;

    @SerializedName("adyenPaymentSource")
    private CommonField adyenPaymentSource = null;

    @SerializedName("externalPlatform")
    private ExternalPlatform externalPlatform = null;

    public ApplicationInfo() {
        adyenLibrary = new CommonField();
        adyenLibrary.setName(LIB_NAME);
        adyenLibrary.setVersion(LIB_VERSION);
    }

    @SerializedName("merchantApplication")
    private CommonField merchantApplication = null;

    @SerializedName("merchantDevice")
    private MerchantDevice merchantDevice = null;

    @SerializedName("paymentDetailsSource")
    private CommonField paymentDetailsSource = null;

    @SerializedName("shopperInteractionDevice")
    private ShopperInteractionDevice shopperInteractionDevice = null;

    public CommonField getPaymentDetailsSource() {
        return paymentDetailsSource;
    }

    public void setPaymentDetailsSource(CommonField paymentDetailsSource) {
        this.paymentDetailsSource = paymentDetailsSource;
    }


    public CommonField getAdyenLibrary() {
        return adyenLibrary;
    }

    public void setAdyenLibrary(CommonField adyenLibrary) {
        this.adyenLibrary = adyenLibrary;
    }

    public CommonField getAdyenPaymentSource() {
        return adyenPaymentSource;
    }

    public void setAdyenPaymentSource(CommonField adyenPaymentSource) {
        this.adyenPaymentSource = adyenPaymentSource;
    }

    public CommonField getMerchantApplication() {
        return merchantApplication;
    }

    public void setMerchantApplication(CommonField merchantApplication) {
        this.merchantApplication = merchantApplication;
    }

    public MerchantDevice getMerchantDevice() {
        return merchantDevice;
    }

    public void setMerchantDevice(MerchantDevice merchantDevice) {
        this.merchantDevice = merchantDevice;
    }

    public ExternalPlatform getExternalPlatform() {
        return externalPlatform;
    }

    public void setExternalPlatform(ExternalPlatform externalPlatform) {
        this.externalPlatform = externalPlatform;
    }

    public ShopperInteractionDevice getShopperInteractionDevice() {
        return shopperInteractionDevice;
    }

    public void setShopperInteractionDevice(ShopperInteractionDevice shopperInteractionDevice) {
        this.shopperInteractionDevice = shopperInteractionDevice;
    }

    @Override
    public String toString() {
        return "ApplicationInfo{"
                + "adyenLibrary="
                + adyenLibrary
                + ", adyenPaymentSource="
                + adyenPaymentSource
                + ", merchantApplication="
                + merchantApplication
                + ", merchantDevice="
                + merchantDevice
                + ", externalPlatform="
                + externalPlatform
                + ", shopperInteractionDevice="
                + shopperInteractionDevice
                + '}';
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) o;
        return Objects.equals(this.adyenLibrary, applicationInfo.adyenLibrary)
                && Objects.equals(this.adyenPaymentSource, applicationInfo.adyenPaymentSource)
                && Objects.equals(this.externalPlatform,
                                  applicationInfo.externalPlatform)
                && Objects.equals(this.merchantApplication, applicationInfo.merchantApplication)
                && Objects.equals(this.merchantDevice, applicationInfo.merchantDevice)
                && Objects.equals(this.paymentDetailsSource, applicationInfo.paymentDetailsSource)
                && Objects.equals(this.shopperInteractionDevice, applicationInfo.shopperInteractionDevice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adyenLibrary, adyenPaymentSource, externalPlatform, merchantApplication, merchantDevice, paymentDetailsSource, shopperInteractionDevice);
    }

}
