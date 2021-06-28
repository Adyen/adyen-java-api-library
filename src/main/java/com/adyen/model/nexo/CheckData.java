package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the paper check used for the transaction. -- Usage: Allows the check information to be provided by the Sale System before requesting the payment, or stored by the Sale System after processing of the payment.
 *
 * <p>Java class for CheckData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CheckData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BankID" type="{}BankID" minOccurs="0"/&gt;
 *         &lt;element name="AccountNumber" type="{}AccountNumber" minOccurs="0"/&gt;
 *         &lt;element name="CheckNumber" type="{}CheckNumber" minOccurs="0"/&gt;
 *         &lt;element name="TrackData" type="{}TrackData" minOccurs="0"/&gt;
 *         &lt;element name="CheckCardNumber" type="{}CheckCardNumber" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TypeCode" type="{}CheckTypeCodeType" default="Personal" /&gt;
 *       &lt;attribute name="Country" type="{}ISOCountry3A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckData", propOrder = {
        "bankID",
        "accountNumber",
        "checkNumber",
        "trackData",
        "checkCardNumber"
})
public class CheckData {

    /**
     * The Bank id.
     */
    @XmlElement(name = "BankID")
    @Schema(description = "Identification of the bank. --Rule: Mandatory if TrackData absent")
    protected String bankID;
    /**
     * The Account number.
     */
    @XmlElement(name = "AccountNumber")
    @Schema(description = "Identification of the customer account. --Rule: Mandatory if TrackData absent")
    protected String accountNumber;
    /**
     * The Check number.
     */
    @XmlElement(name = "CheckNumber")
    @Schema(description = "Identification of the bank check. --Rule: Mandatory if TrackData absent")
    protected String checkNumber;
    /**
     * The Track data.
     */
    @XmlElement(name = "TrackData")
    @Schema(description = "Magnetic track or magnetic ink characters line. --Rule: Mandatory if CheckNumber absent")
    protected TrackData trackData;
    /**
     * The Check card number.
     */
    @XmlElement(name = "CheckCardNumber")
    @Schema(description = "Check guarantee card number. --Rule: If provided by the customer")
    protected String checkCardNumber;
    /**
     * The Type code.
     */
    @XmlElement(name = "TypeCode")
    @Schema(description = "Type of bank check.")
    protected CheckTypeCodeType typeCode;
    /**
     * The Country.
     */
    @XmlElement(name = "Country")
    @Schema(description = "Country of the bank check. --Rule: Absent if country of the Sale system")
    protected String country;

    /**
     * Gets the value of the bankID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getBankID() {
        return bankID;
    }

    /**
     * Sets the value of the bankID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setBankID(String value) {
        this.bankID = value;
    }

    /**
     * Gets the value of the accountNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the checkNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the value of the checkNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCheckNumber(String value) {
        this.checkNumber = value;
    }

    /**
     * Gets the value of the trackData property.
     *
     * @return possible      object is     {@link TrackData }
     */
    public TrackData getTrackData() {
        return trackData;
    }

    /**
     * Sets the value of the trackData property.
     *
     * @param value allowed object is     {@link TrackData }
     */
    public void setTrackData(TrackData value) {
        this.trackData = value;
    }

    /**
     * Gets the value of the checkCardNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCheckCardNumber() {
        return checkCardNumber;
    }

    /**
     * Sets the value of the checkCardNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCheckCardNumber(String value) {
        this.checkCardNumber = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible      object is     {@link CheckTypeCodeType }
     */
    public CheckTypeCodeType getTypeCode() {
        if (typeCode == null) {
            return CheckTypeCodeType.PERSONAL;
        } else {
            return typeCode;
        }
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is     {@link CheckTypeCodeType }
     */
    public void setTypeCode(CheckTypeCodeType value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCountry(String value) {
        this.country = value;
    }

}
