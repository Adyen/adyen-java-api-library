package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ReconciliationType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ReconciliationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SaleReconciliation"/&gt;
 *     &lt;enumeration value="AcquirerSynchronisation"/&gt;
 *     &lt;enumeration value="AcquirerReconciliation"/&gt;
 *     &lt;enumeration value="PreviousReconciliation"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ReconciliationType")
@XmlEnum
public enum ReconciliationType {


    /**
     * Reconciliation with closure of the current period, without any Acquirers synchronisation.
     */
    @XmlEnumValue("SaleReconciliation")
    SALE_RECONCILIATION("SaleReconciliation"),

    /**
     * Reconciliation and closure of the current period, with synchronisation of the reconciliation between the POI and Acquirers.
     */
    @XmlEnumValue("AcquirerSynchronisation")
    ACQUIRER_SYNCHRONISATION("AcquirerSynchronisation"),

    /**
     * Reconciliation between the POI and one or several Acquirers only. There is no reconciliation between the Sale System and the POI System.
     */
    @XmlEnumValue("AcquirerReconciliation")
    ACQUIRER_RECONCILIATION("AcquirerReconciliation"),

    /**
     * Request result of a previous reconciliation.
     */
    @XmlEnumValue("PreviousReconciliation")
    PREVIOUS_RECONCILIATION("PreviousReconciliation");
    private final String value;

    ReconciliationType(String v) {
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
     * From value reconciliation type.
     *
     * @param v the v
     * @return the reconciliation type
     */
    public static ReconciliationType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
