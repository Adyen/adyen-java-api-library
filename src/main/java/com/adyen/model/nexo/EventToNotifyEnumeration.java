
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventToNotifyEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventToNotifyEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BeginMaintenance"/>
 *     &lt;enumeration value="EndMaintenance"/>
 *     &lt;enumeration value="Shutdown"/>
 *     &lt;enumeration value="Initialised"/>
 *     &lt;enumeration value="OutOfOrder"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Abort"/>
 *     &lt;enumeration value="SaleWakeUp"/>
 *     &lt;enumeration value="SaleAdmin"/>
 *     &lt;enumeration value="CustomerLanguage"/>
 *     &lt;enumeration value="KeyPressed"/>
 *     &lt;enumeration value="SecurityAlarm"/>
 *     &lt;enumeration value="StopAssistance"/>
 *     &lt;enumeration value="CardInserted"/>
 *     &lt;enumeration value="CardRemoved"/>
 *     &lt;enumeration value="Reject"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EventToNotifyEnumeration")
@XmlEnum
public enum EventToNotifyEnumeration {


    /**
     * Begin of POI Maintenance
     * 
     */
    @XmlEnumValue("BeginMaintenance")
    BEGIN_MAINTENANCE("BeginMaintenance"),

    /**
     * End of POI Maintenance
     * 
     */
    @XmlEnumValue("EndMaintenance")
    END_MAINTENANCE("EndMaintenance"),

    /**
     * The POI Terminal or the POI System is shutting down
     * 
     */
    @XmlEnumValue("Shutdown")
    SHUTDOWN("Shutdown"),

    /**
     * The POI Terminal or the POI System is now ready to work
     * 
     */
    @XmlEnumValue("Initialised")
    INITIALISED("Initialised"),

    /**
     * The POI Terminal or the POI System cannot work
     * 
     */
    @XmlEnumValue("OutOfOrder")
    OUT_OF_ORDER("OutOfOrder"),

    /**
     * An Abort request has been sent to abort a message which is already completed.
     * 
     */
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),

    /**
     * One or several device request has been sent by the POI during the processing of a service requested by the Sale System. The processing is cancelled by the
     * 
     */
    @XmlEnumValue("Abort")
    ABORT("Abort"),

    /**
     * A POI terminal requests the payment of the transaction identified by the content of EventDetails in the Event notification.
     * 
     */
    @XmlEnumValue("SaleWakeUp")
    SALE_WAKE_UP("SaleWakeUp"),

    /**
     * The POI has performed, or want to perform an automatic administrative process, e.g. the reports at the end of day.
     * 
     */
    @XmlEnumValue("SaleAdmin")
    SALE_ADMIN("SaleAdmin"),

    /**
     * The customer has selected a different language on the POI.
     * 
     */
    @XmlEnumValue("CustomerLanguage")
    CUSTOMER_LANGUAGE("CustomerLanguage"),

    /**
     * The customer has pressed a specific key on the POI.
     * 
     */
    @XmlEnumValue("KeyPressed")
    KEY_PRESSED("KeyPressed"),

    /**
     * Problem of security
     * 
     */
    @XmlEnumValue("SecurityAlarm")
    SECURITY_ALARM("SecurityAlarm"),

    /**
     * When the Customer assistance is stopped, because the Customer has completed its input.
     * 
     */
    @XmlEnumValue("StopAssistance")
    STOP_ASSISTANCE("StopAssistance"),

    /**
     * A card is inserted in the card reader (see Input request and NotifyCardInputFlag)
     * 
     */
    @XmlEnumValue("CardInserted")
    CARD_INSERTED("CardInserted"),

    /**
     * A card is removed from the card reader.
     * 
     */
    @XmlEnumValue("CardRemoved")
    CARD_REMOVED("CardRemoved"),

    /**
     * A message request is rejected. An error explanation and the message in error have to be put in the EventDetails data element.
     * 
     */
    @XmlEnumValue("Reject")
    REJECT("Reject");
    private final String value;

    EventToNotifyEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventToNotifyEnumeration fromValue(String v) {
        for (EventToNotifyEnumeration c: EventToNotifyEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
