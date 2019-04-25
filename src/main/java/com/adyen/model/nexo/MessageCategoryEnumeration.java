
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageCategoryEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageCategoryEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Abort"/>
 *     &lt;enumeration value="Admin"/>
 *     &lt;enumeration value="BalanceInquiry"/>
 *     &lt;enumeration value="Batch"/>
 *     &lt;enumeration value="CardAcquisition"/>
 *     &lt;enumeration value="CardReaderAPDU"/>
 *     &lt;enumeration value="CardReaderInit"/>
 *     &lt;enumeration value="CardReaderPowerOff"/>
 *     &lt;enumeration value="Diagnosis"/>
 *     &lt;enumeration value="Display"/>
 *     &lt;enumeration value="EnableService"/>
 *     &lt;enumeration value="Event"/>
 *     &lt;enumeration value="GetTotals"/>
 *     &lt;enumeration value="Input"/>
 *     &lt;enumeration value="InputUpdate"/>
 *     &lt;enumeration value="Login"/>
 *     &lt;enumeration value="Logout"/>
 *     &lt;enumeration value="Loyalty"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="PIN"/>
 *     &lt;enumeration value="Print"/>
 *     &lt;enumeration value="Reconciliation"/>
 *     &lt;enumeration value="Reversal"/>
 *     &lt;enumeration value="Sound"/>
 *     &lt;enumeration value="StoredValue"/>
 *     &lt;enumeration value="TransactionStatus"/>
 *     &lt;enumeration value="Transmit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MessageCategoryEnumeration")
@XmlEnum
public enum MessageCategoryEnumeration {


    /**
     * Abort message request
     * 
     */
    @XmlEnumValue("Abort")
    ABORT("Abort"),

    /**
     * Admin request or response
     * 
     */
    @XmlEnumValue("Admin")
    ADMIN("Admin"),

    /**
     * Balance Inquiry request or response
     * 
     */
    @XmlEnumValue("BalanceInquiry")
    BALANCE_INQUIRY("BalanceInquiry"),

    /**
     * Batch request or response
     * 
     */
    @XmlEnumValue("Batch")
    BATCH("Batch"),

    /**
     * Card Acquisition request or response
     * 
     */
    @XmlEnumValue("CardAcquisition")
    CARD_ACQUISITION("CardAcquisition"),

    /**
     * Card Reader APDU request or response
     * 
     */
    @XmlEnumValue("CardReaderAPDU")
    CARD_READER_APDU("CardReaderAPDU"),

    /**
     * Card Reader Init request or response
     * 
     */
    @XmlEnumValue("CardReaderInit")
    CARD_READER_INIT("CardReaderInit"),

    /**
     * Card Reader Power-Off request or response
     * 
     */
    @XmlEnumValue("CardReaderPowerOff")
    CARD_READER_POWER_OFF("CardReaderPowerOff"),

    /**
     * Diagnosis request or response
     * 
     */
    @XmlEnumValue("Diagnosis")
    DIAGNOSIS("Diagnosis"),

    /**
     * Display message request or response
     * 
     */
    @XmlEnumValue("Display")
    DISPLAY("Display"),

    /**
     * Enable Service message request or response
     * 
     */
    @XmlEnumValue("EnableService")
    ENABLE_SERVICE("EnableService"),

    /**
     * Event Notification message
     * 
     */
    @XmlEnumValue("Event")
    EVENT("Event"),

    /**
     * GetTotals message request or response
     * 
     */
    @XmlEnumValue("GetTotals")
    GET_TOTALS("GetTotals"),

    /**
     * Input message request or response
     * 
     */
    @XmlEnumValue("Input")
    INPUT("Input"),

    /**
     * Input Update message
     * 
     */
    @XmlEnumValue("InputUpdate")
    INPUT_UPDATE("InputUpdate"),

    /**
     * Login message request or response
     * 
     */
    @XmlEnumValue("Login")
    LOGIN("Login"),

    /**
     * Logout message request or response
     * 
     */
    @XmlEnumValue("Logout")
    LOGOUT("Logout"),

    /**
     * Loyalty message request or response
     * 
     */
    @XmlEnumValue("Loyalty")
    LOYALTY("Loyalty"),

    /**
     * Payment message request or response
     * 
     */
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),

    /**
     * PIN message request or response
     * 
     */
    PIN("PIN"),

    /**
     * Print message request or response
     * 
     */
    @XmlEnumValue("Print")
    PRINT("Print"),

    /**
     * Reconciliation message request or response
     * 
     */
    @XmlEnumValue("Reconciliation")
    RECONCILIATION("Reconciliation"),

    /**
     * Reversal message request or response
     * 
     */
    @XmlEnumValue("Reversal")
    REVERSAL("Reversal"),

    /**
     * Sound message request or response
     * 
     */
    @XmlEnumValue("Sound")
    SOUND("Sound"),

    /**
     * Stored Value message request or response
     * 
     */
    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),

    /**
     * TransactionStatus message request or response
     * 
     */
    @XmlEnumValue("TransactionStatus")
    TRANSACTION_STATUS("TransactionStatus"),

    /**
     * Transmit message request or response
     * 
     */
    @XmlEnumValue("Transmit")
    TRANSMIT("Transmit");
    private final String value;

    MessageCategoryEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageCategoryEnumeration fromValue(String v) {
        for (MessageCategoryEnumeration c: MessageCategoryEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
