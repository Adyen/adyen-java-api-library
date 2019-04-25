
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorConditionEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErrorConditionEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aborted"/>
 *     &lt;enumeration value="Busy"/>
 *     &lt;enumeration value="Cancel"/>
 *     &lt;enumeration value="DeviceOut"/>
 *     &lt;enumeration value="InsertedCard"/>
 *     &lt;enumeration value="InProgress"/>
 *     &lt;enumeration value="LoggedOut"/>
 *     &lt;enumeration value="MessageFormat"/>
 *     &lt;enumeration value="NotAllowed"/>
 *     &lt;enumeration value="NotFound"/>
 *     &lt;enumeration value="PaymentRestriction"/>
 *     &lt;enumeration value="Refusal"/>
 *     &lt;enumeration value="UnavailableDevice"/>
 *     &lt;enumeration value="UnavailableService"/>
 *     &lt;enumeration value="InvalidCard"/>
 *     &lt;enumeration value="UnreachableHost"/>
 *     &lt;enumeration value="WrongPIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ErrorConditionEnumeration")
@XmlEnum
public enum ErrorConditionEnumeration {


    /**
     * The Initiator of the request has sent an Abort message request, which was accepted and processed.
     * 
     */
    @XmlEnumValue("Aborted")
    ABORTED("Aborted"),

    /**
     * The system is busy, try later
     * 
     */
    @XmlEnumValue("Busy")
    BUSY("Busy"),

    /**
     * The user has aborted the transaction on the PED keyboard, for instance during PIN entering.
     * 
     */
    @XmlEnumValue("Cancel")
    CANCEL("Cancel"),

    /**
     * Device out of order
     * 
     */
    @XmlEnumValue("DeviceOut")
    DEVICE_OUT("DeviceOut"),

    /**
     * If the Input Device request a NotifyCardInputFlag and the Customer enters a card in the card reader without answers to the Input command, the POI abort the
     * 
     */
    @XmlEnumValue("InsertedCard")
    INSERTED_CARD("InsertedCard"),

    /**
     * The transaction is still in progress and then the command cannot be processed
     * 
     */
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),

    /**
     * Not logged in
     * 
     */
    @XmlEnumValue("LoggedOut")
    LOGGED_OUT("LoggedOut"),

    /**
     * Error on the format of the message, AdditionalResponse shall contain the identification of the data, and the reason in clear text.
     * 
     */
    @XmlEnumValue("MessageFormat")
    MESSAGE_FORMAT("MessageFormat"),

    /**
     * A service request is sent during a Service dialogue. A combination of services not possible to provide. During the CardReaderInit message processing, the user
     * 
     */
    @XmlEnumValue("NotAllowed")
    NOT_ALLOWED("NotAllowed"),

    /**
     * The transaction is not found (e.g. for a reversal or a repeat)
     * 
     */
    @XmlEnumValue("NotFound")
    NOT_FOUND("NotFound"),

    /**
     * Some sale items are not payable by the card proposed by the Customer.
     * 
     */
    @XmlEnumValue("PaymentRestriction")
    PAYMENT_RESTRICTION("PaymentRestriction"),

    /**
     * The transaction is refused by the host or the rules associated to the card, and cannot be repeated.
     * 
     */
    @XmlEnumValue("Refusal")
    REFUSAL("Refusal"),

    /**
     * The hardware is not available (absent, not configured...)
     * 
     */
    @XmlEnumValue("UnavailableDevice")
    UNAVAILABLE_DEVICE("UnavailableDevice"),

    /**
     * The service is not available (not implemented, not configured, protocol version too old...)
     * 
     */
    @XmlEnumValue("UnavailableService")
    UNAVAILABLE_SERVICE("UnavailableService"),

    /**
     * The card entered by the Customer cannot be processed by the POI because this card is not configured in the system
     * 
     */
    @XmlEnumValue("InvalidCard")
    INVALID_CARD("InvalidCard"),

    /**
     * Acquirer or any host is unreachable or has not answered to an online request, so is considered as temporary unavailable. Depending on the Sale context, the
     * 
     */
    @XmlEnumValue("UnreachableHost")
    UNREACHABLE_HOST("UnreachableHost"),

    /**
     * The user has entered the PIN on the PED keyboard and the verification fails.
     * 
     */
    @XmlEnumValue("WrongPIN")
    WRONG_PIN("WrongPIN");
    private final String value;

    ErrorConditionEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErrorConditionEnumeration fromValue(String v) {
        for (ErrorConditionEnumeration c: ErrorConditionEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
