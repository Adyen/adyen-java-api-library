package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for EventToNotifyType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="EventToNotifyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BeginMaintenance"/&gt;
 *     &lt;enumeration value="EndMaintenance"/&gt;
 *     &lt;enumeration value="Shutdown"/&gt;
 *     &lt;enumeration value="Initialised"/&gt;
 *     &lt;enumeration value="OutOfOrder"/&gt;
 *     &lt;enumeration value="Completed"/&gt;
 *     &lt;enumeration value="Abort"/&gt;
 *     &lt;enumeration value="SaleWakeUp"/&gt;
 *     &lt;enumeration value="SaleAdmin"/&gt;
 *     &lt;enumeration value="CustomerLanguage"/&gt;
 *     &lt;enumeration value="KeyPressed"/&gt;
 *     &lt;enumeration value="SecurityAlarm"/&gt;
 *     &lt;enumeration value="StopAssistance"/&gt;
 *     &lt;enumeration value="CardInserted"/&gt;
 *     &lt;enumeration value="CardRemoved"/&gt;
 *     &lt;enumeration value="Reject"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "EventToNotifyType")
@XmlEnum
public enum EventToNotifyType {


    /**
     * Begin of POI Maintenance
     */
    @XmlEnumValue("BeginMaintenance")
    BEGIN_MAINTENANCE("BeginMaintenance"),

    /**
     * End of POI Maintenance
     */
    @XmlEnumValue("EndMaintenance")
    END_MAINTENANCE("EndMaintenance"),

    /**
     * The POI Terminal or the POI System is shutting down
     */
    @XmlEnumValue("Shutdown")
    SHUTDOWN("Shutdown"),

    /**
     * The POI Terminal or the POI System is now ready to work
     */
    @XmlEnumValue("Initialised")
    INITIALISED("Initialised"),

    /**
     * The POI Terminal or the POI System cannot work
     */
    @XmlEnumValue("OutOfOrder")
    OUT_OF_ORDER("OutOfOrder"),

    /**
     * An Abort request has been sent to abort a messageType which is already completed.
     */
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),

    /**
     * One or several device request has been sent by the POI during the processing of a service requested by the Sale System. The processing is cancelled by the
     */
    @XmlEnumValue("Abort")
    ABORT("Abort"),

    /**
     * A POI terminal requests the payment of the transaction identified by the content of EventDetails in the Event notification.
     */
    @XmlEnumValue("SaleWakeUp")
    SALE_WAKE_UP("SaleWakeUp"),

    /**
     * The POI has performed, or want to perform an automatic administrative process, e.g. the reports at the end of day.
     */
    @XmlEnumValue("SaleAdmin")
    SALE_ADMIN("SaleAdmin"),

    /**
     * The customer has selected a different language on the POI.
     */
    @XmlEnumValue("CustomerLanguage")
    CUSTOMER_LANGUAGE("CustomerLanguage"),

    /**
     * The customer has pressed a specific key on the POI.
     */
    @XmlEnumValue("KeyPressed")
    KEY_PRESSED("KeyPressed"),

    /**
     * Problem of security
     */
    @XmlEnumValue("SecurityAlarm")
    SECURITY_ALARM("SecurityAlarm"),

    /**
     * When the Customer assistance is stopped, because the Customer has completed its input.
     */
    @XmlEnumValue("StopAssistance")
    STOP_ASSISTANCE("StopAssistance"),

    /**
     * A card is inserted in the card reader (see Input request and NotifyCardInputFlag)
     */
    @XmlEnumValue("CardInserted")
    CARD_INSERTED("CardInserted"),

    /**
     * A card is removed from the card reader.
     */
    @XmlEnumValue("CardRemoved")
    CARD_REMOVED("CardRemoved"),

    /**
     * A messageType request is rejected. An error explanation and the messageType in error have to be put in the EventDetails data element.
     */
    @XmlEnumValue("Reject")
    REJECT("Reject");
    private final String value;

    EventToNotifyType(String v) {
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
     * From value event to notify type.
     *
     * @param v the v
     * @return the event to notify type
     */
    public static EventToNotifyType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
