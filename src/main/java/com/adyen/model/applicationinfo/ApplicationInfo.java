package com.adyen.model.applicationinfo;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class ApplicationInfo {
    @SerializedName("adyenLibrary")
    private final AdyenLibraryInfo adyenLibrary;

    @SerializedName("adyenPaymentSource")
    private CommonField adyenPaymentSource = null;

    @SerializedName("externalPlatform")
    private ExternalPlatform externalPlatform = null;

    @SerializedName("merchantApplication")
    private CommonField merchantApplication = null;

    @SerializedName("merchantDevice")
    private MerchantDevice merchantDevice = null;

    @SerializedName("paymentDetailsSource")
    private CommonField paymentDetailsSource = null;

    @SerializedName("shopperInteractionDevice")
    private ShopperInteractionDevice shopperInteractionDevice = null;

    public ApplicationInfo() {
        adyenLibrary = new AdyenLibraryInfo();
    }

    public AdyenLibraryInfo getAdyenLibrary() {
        return adyenLibrary;
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
        return "ApplicationInfo{" +
                "adyenLibrary=" + adyenLibrary +
                ", adyenPaymentSource=" + adyenPaymentSource +
                ", externalPlatform=" + externalPlatform +
                ", merchantApplication=" + merchantApplication +
                ", merchantDevice=" + merchantDevice +
                ", paymentDetailsSource=" + paymentDetailsSource +
                ", shopperInteractionDevice=" + shopperInteractionDevice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationInfo that = (ApplicationInfo) o;
        return Objects.equals(adyenLibrary, that.adyenLibrary) &&
                Objects.equals(adyenPaymentSource, that.adyenPaymentSource) &&
                Objects.equals(externalPlatform, that.externalPlatform) &&
                Objects.equals(merchantApplication, that.merchantApplication) &&
                Objects.equals(merchantDevice, that.merchantDevice) &&
                Objects.equals(paymentDetailsSource, that.paymentDetailsSource) &&
                Objects.equals(shopperInteractionDevice, that.shopperInteractionDevice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adyenLibrary, adyenPaymentSource, externalPlatform, merchantApplication, merchantDevice, paymentDetailsSource, shopperInteractionDevice);
    }
}
