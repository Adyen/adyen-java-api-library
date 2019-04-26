
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReconciliationType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReconciliationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SaleReconciliation"/>
 *     &lt;enumeration value="AcquirerSynchronisation"/>
 *     &lt;enumeration value="AcquirerReconciliation"/>
 *     &lt;enumeration value="PreviousReconciliation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "ReconciliationType")
@XmlEnum
public enum ReconciliationType {


    /**
     * Reconciliation with closure of the current period, without any Acquirers synchronisation.
     *
     */
    @XmlEnumValue("SaleReconciliation")
    SALE_RECONCILIATION("SaleReconciliation"),

    /**
     * Reconciliation and closure of the current period, with synchronisation of the reconciliation between the POI and Acquirers.
     *
     */
    @XmlEnumValue("AcquirerSynchronisation")
    ACQUIRER_SYNCHRONISATION("AcquirerSynchronisation"),

    /**
     * Reconciliation between the POI and one or several Acquirers only. There is no reconciliation between the Sale System and the POI System.
     *
     */
    @XmlEnumValue("AcquirerReconciliation")
    ACQUIRER_RECONCILIATION("AcquirerReconciliation"),

    /**
     * Request result of a previous reconciliation.
     *
     */
    @XmlEnumValue("PreviousReconciliation")
    PREVIOUS_RECONCILIATION("PreviousReconciliation");
    private final String value;

    ReconciliationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReconciliationType fromValue(String v) {
        for (ReconciliationType c: ReconciliationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
