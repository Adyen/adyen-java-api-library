package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ErrorConditionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ErrorConditionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Aborted"/&gt;
 *     &lt;enumeration value="Busy"/&gt;
 *     &lt;enumeration value="Cancel"/&gt;
 *     &lt;enumeration value="DeviceOut"/&gt;
 *     &lt;enumeration value="InsertedCard"/&gt;
 *     &lt;enumeration value="InProgress"/&gt;
 *     &lt;enumeration value="LoggedOut"/&gt;
 *     &lt;enumeration value="MessageFormat"/&gt;
 *     &lt;enumeration value="NotAllowed"/&gt;
 *     &lt;enumeration value="NotFound"/&gt;
 *     &lt;enumeration value="PaymentRestriction"/&gt;
 *     &lt;enumeration value="Refusal"/&gt;
 *     &lt;enumeration value="UnavailableDevice"/&gt;
 *     &lt;enumeration value="UnavailableService"/&gt;
 *     &lt;enumeration value="InvalidCard"/&gt;
 *     &lt;enumeration value="UnreachableHost"/&gt;
 *     &lt;enumeration value="WrongPIN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ErrorConditionType")
@XmlEnum
public enum ErrorConditionType {


    /**
     * The Initiator of the request has sent an Abort messageType request, which was accepted and processed.
     */
    @XmlEnumValue("Aborted")
    @Schema(description = "The Initiator of the request has sent an Abort message request, which was accepted and processed.")
    ABORTED("Aborted"),

    /**
     * The system is busy, try later
     */
    @XmlEnumValue("Busy")
    @Schema(description = "The system is busy, try later")
    BUSY("Busy"),

    /**
     * The user has aborted the transaction on the PED keyboard, for instance during PIN entering.
     */
    @XmlEnumValue("Cancel")
    @Schema(description = "The user has aborted the transaction on the PED keyboard, for instance during PIN entering.")
    CANCEL("Cancel"),

    /**
     * Device out of order
     */
    @XmlEnumValue("DeviceOut")
    @Schema(description = "Device out of order")
    DEVICE_OUT("DeviceOut"),

    /**
     * If the Input Device request a NotifyCardInputFlag and the Customer enters a card in the card reader without answers to the Input command, the POI abort the
     */
    @XmlEnumValue("InsertedCard")
    @Schema(description = "If the Input Device request a NotifyCardInputFlag and the Customer enters a card in the card reader without answers to the Input command, the POI abort the")
    INSERTED_CARD("InsertedCard"),

    /**
     * The transaction is still in progress and then the command cannot be processed
     */
    @XmlEnumValue("InProgress")
    @Schema(description = "The transaction is still in progress and then the command cannot be processed")
    IN_PROGRESS("InProgress"),

    /**
     * Not logged in
     */
    @XmlEnumValue("LoggedOut")
    @Schema(description = "Not logged in")
    LOGGED_OUT("LoggedOut"),

    /**
     * Error on the format of the messageType, AdditionalResponse shall contain the identification of the data, and the reason in clear text.
     */
    @XmlEnumValue("MessageFormat")
    @Schema(description = "Error on the format of the message, AdditionalResponse shall contain the identification of the data, and the reason in clear text.")
    MESSAGE_FORMAT("MessageFormat"),

    /**
     * A service request is sent during a Service dialogue. A combination of services not possible to provide. During the CardReaderInit messageType processing, the user
     */
    @XmlEnumValue("NotAllowed")
    @Schema(description = "A service request is sent during a Service dialogue. A combination of services not possible to provide. During the CardReaderInit message processing, the user")
    NOT_ALLOWED("NotAllowed"),

    /**
     * The transaction is not found (e.g. for a reversal or a repeat)
     */
    @XmlEnumValue("NotFound")
    @Schema(description = "The transaction is not found (e.g. for a reversal or a repeat)")
    NOT_FOUND("NotFound"),

    /**
     * Some sale items are not payable by the card proposed by the Customer.
     */
    @XmlEnumValue("PaymentRestriction")
    @Schema(description = "Some sale items are not payable by the card proposed by the Customer.")
    PAYMENT_RESTRICTION("PaymentRestriction"),

    /**
     * The transaction is refused by the host or the rules associated to the card, and cannot be repeated.
     */
    @XmlEnumValue("Refusal")
    @Schema(description = "The transaction is refused by the host or the rules associated to the card, and cannot be repeated.")
    REFUSAL("Refusal"),

    /**
     * The hardware is not available (absent, not configured...)
     */
    @XmlEnumValue("UnavailableDevice")
    @Schema(description = "The hardware is not available (absent, not configured...)")
    UNAVAILABLE_DEVICE("UnavailableDevice"),

    /**
     * The service is not available (not implemented, not configured, protocol version too old...)
     */
    @XmlEnumValue("UnavailableService")
    @Schema(description = "The service is not available (not implemented, not configured, protocol version too old...)")
    UNAVAILABLE_SERVICE("UnavailableService"),

    /**
     * The card entered by the Customer cannot be processed by the POI because this card is not configured in the system
     */
    @XmlEnumValue("InvalidCard")
    @Schema(description = "The card entered by the Customer cannot be processed by the POI because this card is not configured in the system")
    INVALID_CARD("InvalidCard"),

    /**
     * Acquirer or any host is unreachable or has not answered to an online request, so is considered as temporary unavailable. Depending on the Sale context, the
     */
    @XmlEnumValue("UnreachableHost")
    @Schema(description = "Acquirer or any host is unreachable or has not answered to an online request, so is considered as temporary unavailable. Depending on the Sale context, the")
    UNREACHABLE_HOST("UnreachableHost"),

    /**
     * The user has entered the PIN on the PED keyboard and the verification fails.
     */
    @XmlEnumValue("WrongPIN")
    @Schema(description = "The user has entered the PIN on the PED keyboard and the verification fails.")
    WRONG_PIN("WrongPIN");
    private final String value;

    ErrorConditionType(String v) {
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
     * From value error condition type.
     *
     * @param v the v
     * @return the error condition type
     */
    public static ErrorConditionType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
