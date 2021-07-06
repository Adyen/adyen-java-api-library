package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

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
    @Schema(description = "Abort message request")
    ABORT("Abort"),

    /**
     * Admin request or response
     */
    @XmlEnumValue("Admin")
    @Schema(description = "Admin request or response")
    ADMIN("Admin"),

    /**
     * Balance Inquiry request or response
     */
    @XmlEnumValue("BalanceInquiry")
    @Schema(description = "Balance Inquiry request or response")
    BALANCE_INQUIRY("BalanceInquiry"),

    /**
     * Batch request or response
     */
    @XmlEnumValue("Batch")
    @Schema(description = "Batch request or response")
    BATCH("Batch"),

    /**
     * Card Acquisition request or response
     */
    @XmlEnumValue("CardAcquisition")
    @Schema(description = "Card Acquisition request or response")
    CARD_ACQUISITION("CardAcquisition"),

    /**
     * Card Reader APDU request or response
     */
    @XmlEnumValue("CardReaderAPDU")
    @Schema(description = "Card Reader APDU request or response")
    CARD_READER_APDU("CardReaderAPDU"),

    /**
     * Card Reader Init request or response
     */
    @XmlEnumValue("CardReaderInit")
    @Schema(description = "Card Reader Init request or response")
    CARD_READER_INIT("CardReaderInit"),

    /**
     * Card Reader Power-Off request or response
     */
    @XmlEnumValue("CardReaderPowerOff")
    @Schema(description = "Card Reader Power-Off request or response")
    CARD_READER_POWER_OFF("CardReaderPowerOff"),

    /**
     * Diagnosis request or response
     */
    @XmlEnumValue("Diagnosis")
    @Schema(description = "Diagnosis request or response")
    DIAGNOSIS("Diagnosis"),

    /**
     * Display messageType request or response
     */
    @XmlEnumValue("Display")
    @Schema(description = "Display message request or response")
    DISPLAY("Display"),

    /**
     * Enable Service messageType request or response
     */
    @XmlEnumValue("EnableService")
    @Schema(description = "Enable Service message request or response")
    ENABLE_SERVICE("EnableService"),

    /**
     * Event Notification messageType
     */
    @XmlEnumValue("Event")
    @Schema(description = "Event Notification message")
    EVENT("Event"),

    /**
     * GetTotals messageType request or response
     */
    @XmlEnumValue("GetTotals")
    @Schema(description = "GetTotals message request or response")
    GET_TOTALS("GetTotals"),

    /**
     * Input messageType request or response
     */
    @XmlEnumValue("Input")
    @Schema(description = "Input message request or response")
    INPUT("Input"),

    /**
     * Input Update messageType
     */
    @XmlEnumValue("InputUpdate")
    @Schema(description = "Input Update message")
    INPUT_UPDATE("InputUpdate"),

    /**
     * Login messageType request or response
     */
    @XmlEnumValue("Login")
    @Schema(description = "Login message request or response")
    LOGIN("Login"),

    /**
     * Logout messageType request or response
     */
    @XmlEnumValue("Logout")
    @Schema(description = "Logout message request or response")
    LOGOUT("Logout"),

    /**
     * Loyalty messageType request or response
     */
    @XmlEnumValue("Loyalty")
    @Schema(description = "Loyalty message request or response")
    LOYALTY("Loyalty"),

    /**
     * Payment messageType request or response
     */
    @XmlEnumValue("Payment")
    @Schema(description = "Payment message request or response")
    PAYMENT("Payment"),

    /**
     * PIN messageType request or response
     */
    PIN("PIN"),

    /**
     * Print messageType request or response
     */
    @XmlEnumValue("Print")
    @Schema(description = "Print message request or response")
    PRINT("Print"),

    /**
     * Reconciliation messageType request or response
     */
    @XmlEnumValue("Reconciliation")
    @Schema(description = "Reconciliation message request or response")
    RECONCILIATION("Reconciliation"),

    /**
     * Reversal messageType request or response
     */
    @XmlEnumValue("Reversal")
    @Schema(description = "Reversal message request or response")
    REVERSAL("Reversal"),

    /**
     * Sound messageType request or response
     */
    @XmlEnumValue("Sound")
    @Schema(description = "Sound message request or response")
    SOUND("Sound"),

    /**
     * Stored Value messageType request or response
     */
    @XmlEnumValue("StoredValue")
    @Schema(description = "Stored Value message request or response")
    STORED_VALUE("StoredValue"),

    /**
     * TransactionStatus messageType request or response
     */
    @XmlEnumValue("TransactionStatus")
    @Schema(description = "TransactionStatus message request or response")
    TRANSACTION_STATUS("TransactionStatus"),

    /**
     * Transmit messageType request or response
     */
    @XmlEnumValue("Transmit")
    @Schema(description = "Transmit message request or response")
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
