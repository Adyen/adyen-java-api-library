package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for PaymentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="PaymentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Normal"/&gt;
 *     &lt;enumeration value="Refund"/&gt;
 *     &lt;enumeration value="OneTimeReservation"/&gt;
 *     &lt;enumeration value="FirstReservation"/&gt;
 *     &lt;enumeration value="UpdateReservation"/&gt;
 *     &lt;enumeration value="Completion"/&gt;
 *     &lt;enumeration value="CashAdvance"/&gt;
 *     &lt;enumeration value="CashDeposit"/&gt;
 *     &lt;enumeration value="Recurring"/&gt;
 *     &lt;enumeration value="Instalment"/&gt;
 *     &lt;enumeration value="IssuerInstalment"/&gt;
 *     &lt;enumeration value="PaidOut"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "PaymentType")
@XmlEnum
public enum PaymentType {


    /**
     * Normal Payment
     */
    @XmlEnumValue("Normal")
    @Schema(description = "Normal Payment")
    NORMAL("Normal"),

    /**
     * Payment refund
     */
    @XmlEnumValue("Refund")
    @Schema(description = "Payment refund")
    REFUND("Refund"),

    /**
     * One time reservation to be just followed by a completion when the service or good is delivered. This service is sometimes called "Deferred Sale".
     */
    @XmlEnumValue("OneTimeReservation")
    @Schema(description = "One time reservation to be just followed by a completion when the service or good is delivered. This service is sometimes called \"Deferred Sale\".")
    ONE_TIME_RESERVATION("OneTimeReservation"),

    /**
     * First reservation for an amount and period of time. This service is sometimes called "Pre-Authorisation".
     */
    @XmlEnumValue("FirstReservation")
    @Schema(description = "First reservation for an amount and period of time. This service is sometimes called \"Pre-Authorisation\".")
    FIRST_RESERVATION("FirstReservation"),

    /**
     * Adjustment of the amount or period of time of a reservation.
     */
    @XmlEnumValue("UpdateReservation")
    @Schema(description = "Adjustment of the amount or period of time of a reservation. ")
    UPDATE_RESERVATION("UpdateReservation"),

    /**
     * End of the reservation transaction.
     */
    @XmlEnumValue("Completion")
    @Schema(description = "End of the reservation transaction.")
    COMPLETION("Completion"),

    /**
     * Cash advance at the POI System.
     */
    @XmlEnumValue("CashAdvance")
    @Schema(description = "Cash advance at the POI System.")
    CASH_ADVANCE("CashAdvance"),

    /**
     * Cash deposit at the POI System, to credit an account.
     */
    @XmlEnumValue("CashDeposit")
    @Schema(description = "Cash deposit at the POI System, to credit an account.")
    CASH_DEPOSIT("CashDeposit"),

    /**
     * Recurring payment.
     */
    @XmlEnumValue("Recurring")
    @Schema(description = "Recurring payment.")
    RECURRING("Recurring"),

    /**
     * Instalments of payment performed on behalf of the merchant.
     */
    @XmlEnumValue("Instalment")
    @Schema(description = "Instalments of payment performed on behalf of the merchant.")
    INSTALMENT("Instalment"),

    /**
     * Instalments of payment performed by the card issuer.
     */
    @XmlEnumValue("IssuerInstalment")
    @Schema(description = "Instalments of payment performed by the card issuer.")
    ISSUER_INSTALMENT("IssuerInstalment"),

    /**
     * Give money to in return for goods or services rendered to the merchant.
     */
    @XmlEnumValue("PaidOut")
    @Schema(description = "Give money to in return for goods or services rendered to the merchant.")
    PAID_OUT("PaidOut");
    private final String value;

    PaymentType(String v) {
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
     * From value payment type.
     *
     * @param v the v
     * @return the payment type
     */
    public static PaymentType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
