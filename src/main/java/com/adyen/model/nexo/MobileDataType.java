
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the mobile for the payment transaction. -- Usage: Mobile phone is used as a payment instrument for the transaction.
 * 
 * <p>Java class for MobileDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MobileDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MobileCountryCode" type="{}MobileCountryCodeType" minOccurs="0"/>
 *         &lt;element name="Geolocation" type="{}GeolocationType" minOccurs="0"/>
 *         &lt;element name="ProtectedMobileData" type="{}ContentInformationType" minOccurs="0"/>
 *         &lt;element name="SensitiveMobileData" type="{}SensitiveMobileDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MobileNetworkCode" type="{}MobileNetworkCodeType" />
 *       &lt;attribute name="MaskedMSISDN" type="{}MaskedMSISDNType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileDataType", propOrder = {
    "mobileCountryCode",
    "geolocation",
    "protectedMobileData",
    "sensitiveMobileData"
})
public class MobileDataType {

    @XmlElement(name = "MobileCountryCode")
    protected String mobileCountryCode;
    @XmlElement(name = "Geolocation")
    protected GeolocationType geolocation;
    @XmlElement(name = "ProtectedMobileData")
    protected ContentInformationType protectedMobileData;
    @XmlElement(name = "SensitiveMobileData")
    protected SensitiveMobileDataType sensitiveMobileData;
    @XmlAttribute(name = "MobileNetworkCode")
    protected String mobileNetworkCode;
    @XmlAttribute(name = "MaskedMSISDN")
    protected String maskedMSISDN;

    /**
     * Gets the value of the mobileCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileCountryCode() {
        return mobileCountryCode;
    }

    /**
     * Sets the value of the mobileCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileCountryCode(String value) {
        this.mobileCountryCode = value;
    }

    /**
     * Gets the value of the geolocation property.
     * 
     * @return
     *     possible object is
     *     {@link GeolocationType }
     *     
     */
    public GeolocationType getGeolocation() {
        return geolocation;
    }

    /**
     * Sets the value of the geolocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeolocationType }
     *     
     */
    public void setGeolocation(GeolocationType value) {
        this.geolocation = value;
    }

    /**
     * Gets the value of the protectedMobileData property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInformationType }
     *     
     */
    public ContentInformationType getProtectedMobileData() {
        return protectedMobileData;
    }

    /**
     * Sets the value of the protectedMobileData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInformationType }
     *     
     */
    public void setProtectedMobileData(ContentInformationType value) {
        this.protectedMobileData = value;
    }

    /**
     * Gets the value of the sensitiveMobileData property.
     * 
     * @return
     *     possible object is
     *     {@link SensitiveMobileDataType }
     *     
     */
    public SensitiveMobileDataType getSensitiveMobileData() {
        return sensitiveMobileData;
    }

    /**
     * Sets the value of the sensitiveMobileData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitiveMobileDataType }
     *     
     */
    public void setSensitiveMobileData(SensitiveMobileDataType value) {
        this.sensitiveMobileData = value;
    }

    /**
     * Gets the value of the mobileNetworkCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    /**
     * Sets the value of the mobileNetworkCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileNetworkCode(String value) {
        this.mobileNetworkCode = value;
    }

    /**
     * Gets the value of the maskedMSISDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskedMSISDN() {
        return maskedMSISDN;
    }

    /**
     * Sets the value of the maskedMSISDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskedMSISDN(String value) {
        this.maskedMSISDN = value;
    }

}
