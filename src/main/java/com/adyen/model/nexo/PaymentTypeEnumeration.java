
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="OneTimeReservation"/>
 *     &lt;enumeration value="FirstReservation"/>
 *     &lt;enumeration value="UpdateReservation"/>
 *     &lt;enumeration value="Completion"/>
 *     &lt;enumeration value="CashAdvance"/>
 *     &lt;enumeration value="CashDeposit"/>
 *     &lt;enumeration value="Recurring"/>
 *     &lt;enumeration value="Instalment"/>
 *     &lt;enumeration value="IssuerInstalment"/>
 *     &lt;enumeration value="PaidOut"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentTypeEnumeration")
@XmlEnum
public enum PaymentTypeEnumeration {


    /**
     * Normal Payment
     * 
     */
    @XmlEnumValue("Normal")
    NORMAL("Normal"),

    /**
     * Payment refund
     * 
     */
    @XmlEnumValue("Refund")
    REFUND("Refund"),

    /**
     * One time reservation to be just followed by a completion when the service or good is delivered. This service is sometimes called "Deferred Sale".
     * 
     */
    @XmlEnumValue("OneTimeReservation")
    ONE_TIME_RESERVATION("OneTimeReservation"),

    /**
     * First reservation for an amount and period of time. This service is sometimes called "Pre-Authorisation".
     * 
     */
    @XmlEnumValue("FirstReservation")
    FIRST_RESERVATION("FirstReservation"),

    /**
     * Adjustment of the amount or period of time of a reservation. 
     * 
     */
    @XmlEnumValue("UpdateReservation")
    UPDATE_RESERVATION("UpdateReservation"),

    /**
     * End of the reservation transaction.
     * 
     */
    @XmlEnumValue("Completion")
    COMPLETION("Completion"),

    /**
     * Cash advance at the POI System.
     * 
     */
    @XmlEnumValue("CashAdvance")
    CASH_ADVANCE("CashAdvance"),

    /**
     * Cash deposit at the POI System, to credit an account.
     * 
     */
    @XmlEnumValue("CashDeposit")
    CASH_DEPOSIT("CashDeposit"),

    /**
     * Recurring payment.
     * 
     */
    @XmlEnumValue("Recurring")
    RECURRING("Recurring"),

    /**
     * Instalments of payment performed on behalf of the merchant.
     * 
     */
    @XmlEnumValue("Instalment")
    INSTALMENT("Instalment"),

    /**
     * Instalments of payment performed by the card issuer.
     * 
     */
    @XmlEnumValue("IssuerInstalment")
    ISSUER_INSTALMENT("IssuerInstalment"),

    /**
     * Give money to in return for goods or services rendered to the merchant.
     * 
     */
    @XmlEnumValue("PaidOut")
    PAID_OUT("PaidOut");
    private final String value;

    PaymentTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentTypeEnumeration fromValue(String v) {
        for (PaymentTypeEnumeration c: PaymentTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
