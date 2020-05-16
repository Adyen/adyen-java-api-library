package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for MessageCategoryType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="MessageCategoryType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Abort"/&gt;
 *     &lt;enumeration value="Admin"/&gt;
 *     &lt;enumeration value="BalanceInquiry"/&gt;
 *     &lt;enumeration value="Batch"/&gt;
 *     &lt;enumeration value="CardAcquisition"/&gt;
 *     &lt;enumeration value="CardReaderAPDU"/&gt;
 *     &lt;enumeration value="CardReaderInit"/&gt;
 *     &lt;enumeration value="CardReaderPowerOff"/&gt;
 *     &lt;enumeration value="Diagnosis"/&gt;
 *     &lt;enumeration value="Display"/&gt;
 *     &lt;enumeration value="EnableService"/&gt;
 *     &lt;enumeration value="Event"/&gt;
 *     &lt;enumeration value="GetTotals"/&gt;
 *     &lt;enumeration value="Input"/&gt;
 *     &lt;enumeration value="InputUpdate"/&gt;
 *     &lt;enumeration value="Login"/&gt;
 *     &lt;enumeration value="Logout"/&gt;
 *     &lt;enumeration value="Loyalty"/&gt;
 *     &lt;enumeration value="Payment"/&gt;
 *     &lt;enumeration value="PIN"/&gt;
 *     &lt;enumeration value="Print"/&gt;
 *     &lt;enumeration value="Reconciliation"/&gt;
 *     &lt;enumeration value="Reversal"/&gt;
 *     &lt;enumeration value="Sound"/&gt;
 *     &lt;enumeration value="StoredValue"/&gt;
 *     &lt;enumeration value="TransactionStatus"/&gt;
 *     &lt;enumeration value="Transmit"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MessageCategoryType")
@XmlEnum
public enum MessageCategoryType {


    /**
     * Abort messageType request
     */
    @XmlEnumValue("Abort")
    ABORT("Abort"),

    /**
     * Admin request or response
     */
    @XmlEnumValue("Admin")
    ADMIN("Admin"),

    /**
     * Balance Inquiry request or response
     */
    @XmlEnumValue("BalanceInquiry")
    BALANCE_INQUIRY("BalanceInquiry"),

    /**
     * Batch request or response
     */
    @XmlEnumValue("Batch")
    BATCH("Batch"),

    /**
     * Card Acquisition request or response
     */
    @XmlEnumValue("CardAcquisition")
    CARD_ACQUISITION("CardAcquisition"),

    /**
     * Card Reader APDU request or response
     */
    @XmlEnumValue("CardReaderAPDU")
    CARD_READER_APDU("CardReaderAPDU"),

    /**
     * Card Reader Init request or response
     */
    @XmlEnumValue("CardReaderInit")
    CARD_READER_INIT("CardReaderInit"),

    /**
     * Card Reader Power-Off request or response
     */
    @XmlEnumValue("CardReaderPowerOff")
    CARD_READER_POWER_OFF("CardReaderPowerOff"),

    /**
     * Diagnosis request or response
     */
    @XmlEnumValue("Diagnosis")
    DIAGNOSIS("Diagnosis"),

    /**
     * Display messageType request or response
     */
    @XmlEnumValue("Display")
    DISPLAY("Display"),

    /**
     * Enable Service messageType request or response
     */
    @XmlEnumValue("EnableService")
    ENABLE_SERVICE("EnableService"),

    /**
     * Event Notification messageType
     */
    @XmlEnumValue("Event")
    EVENT("Event"),

    /**
     * GetTotals messageType request or response
     */
    @XmlEnumValue("GetTotals")
    GET_TOTALS("GetTotals"),

    /**
     * Input messageType request or response
     */
    @XmlEnumValue("Input")
    INPUT("Input"),

    /**
     * Input Update messageType
     */
    @XmlEnumValue("InputUpdate")
    INPUT_UPDATE("InputUpdate"),

    /**
     * Login messageType request or response
     */
    @XmlEnumValue("Login")
    LOGIN("Login"),

    /**
     * Logout messageType request or response
     */
    @XmlEnumValue("Logout")
    LOGOUT("Logout"),

    /**
     * Loyalty messageType request or response
     */
    @XmlEnumValue("Loyalty")
    LOYALTY("Loyalty"),

    /**
     * Payment messageType request or response
     */
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),

    /**
     * PIN messageType request or response
     */
    PIN("PIN"),

    /**
     * Print messageType request or response
     */
    @XmlEnumValue("Print")
    PRINT("Print"),

    /**
     * Reconciliation messageType request or response
     */
    @XmlEnumValue("Reconciliation")
    RECONCILIATION("Reconciliation"),

    /**
     * Reversal messageType request or response
     */
    @XmlEnumValue("Reversal")
    REVERSAL("Reversal"),

    /**
     * Sound messageType request or response
     */
    @XmlEnumValue("Sound")
    SOUND("Sound"),

    /**
     * Stored Value messageType request or response
     */
    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),

    /**
     * TransactionStatus messageType request or response
     */
    @XmlEnumValue("TransactionStatus")
    TRANSACTION_STATUS("TransactionStatus"),

    /**
     * Transmit messageType request or response
     */
    @XmlEnumValue("Transmit")
    TRANSMIT("Transmit");
    private final String value;

    MessageCategoryType(String v) {
        value = v;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value message category type.
     *
     * @param v the v
     * @return the message category type
     */
    public static MessageCategoryType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
