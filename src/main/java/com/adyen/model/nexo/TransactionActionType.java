
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionActionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="StartTransaction"/>
 *     &lt;enumeration value="AbortTransaction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "TransactionActionType")
@XmlEnum
public enum TransactionActionType {


    /**
     * Start a transaction by a swipe ahead mechanism, with the services which are enabled.
     *
     */
    @XmlEnumValue("StartTransaction")
    START_TRANSACTION("StartTransaction"),

    /**
     * Abort a transaction started either by a CardAcquisition or EnableService with TransactionAction to "StartTransaction", not followed by a service request from
     *
     */
    @XmlEnumValue("AbortTransaction")
    ABORT_TRANSACTION("AbortTransaction");
    private final String value;

    TransactionActionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionActionType fromValue(String v) {
        for (TransactionActionType c: TransactionActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
