package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for TransactionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Debit"/&gt;
 *     &lt;enumeration value="Credit"/&gt;
 *     &lt;enumeration value="ReverseDebit"/&gt;
 *     &lt;enumeration value="ReverseCredit"/&gt;
 *     &lt;enumeration value="OneTimeReservation"/&gt;
 *     &lt;enumeration value="CompletedDeffered"/&gt;
 *     &lt;enumeration value="FirstReservation"/&gt;
 *     &lt;enumeration value="UpdateReservation"/&gt;
 *     &lt;enumeration value="CompletedReservation"/&gt;
 *     &lt;enumeration value="CashAdvance"/&gt;
 *     &lt;enumeration value="IssuerInstalment"/&gt;
 *     &lt;enumeration value="Declined"/&gt;
 *     &lt;enumeration value="Failed"/&gt;
 *     &lt;enumeration value="Award"/&gt;
 *     &lt;enumeration value="ReverseAward"/&gt;
 *     &lt;enumeration value="Redemption"/&gt;
 *     &lt;enumeration value="ReverseRedemption"/&gt;
 *     &lt;enumeration value="Rebate"/&gt;
 *     &lt;enumeration value="ReverseRebate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TransactionType")
@XmlEnum
public enum TransactionType {


    /**
     * Payment Debit transactions (e.g. if PaymentType is "Normal")
     */
    @XmlEnumValue("Debit")
    DEBIT("Debit"),

    /**
     * Payment Credit transactions (e.g.  if PaymentType is "Refund")
     */
    @XmlEnumValue("Credit")
    CREDIT("Credit"),

    /**
     * Payment Reversal Debit transactions
     */
    @XmlEnumValue("ReverseDebit")
    REVERSE_DEBIT("ReverseDebit"),

    /**
     * Payment Reversal Credit transactions
     */
    @XmlEnumValue("ReverseCredit")
    REVERSE_CREDIT("ReverseCredit"),

    /**
     * Outstanding OneTimeReservation transactions, i.e. between OneTimeReservation and Completion
     */
    @XmlEnumValue("OneTimeReservation")
    ONE_TIME_RESERVATION("OneTimeReservation"),

    /**
     * OneTimeReservation transactions which have been completed by the Completion.
     */
    @XmlEnumValue("CompletedDeffered")
    COMPLETED_DEFFERED("CompletedDeffered"),

    /**
     * Outstanding FirstReservation transactions, i.e. between FirstReservation and UpdateReservation  or Completion
     */
    @XmlEnumValue("FirstReservation")
    FIRST_RESERVATION("FirstReservation"),

    /**
     * Outstanding UpdateReservation transactions, i.e. between UpdateReservation and UpdateReservation or Completion
     */
    @XmlEnumValue("UpdateReservation")
    UPDATE_RESERVATION("UpdateReservation"),

    /**
     * Reservation transactions which have been completed by the Completion.
     */
    @XmlEnumValue("CompletedReservation")
    COMPLETED_RESERVATION("CompletedReservation"),

    /**
     * Cash Advance transactions.
     */
    @XmlEnumValue("CashAdvance")
    CASH_ADVANCE("CashAdvance"),

    /**
     * Issuer instalment transactions.
     */
    @XmlEnumValue("IssuerInstalment")
    ISSUER_INSTALMENT("IssuerInstalment"),

    /**
     * ResultErrorCondition
     */
    @XmlEnumValue("Declined")
    DECLINED("Declined"),

    /**
     * ResultErrorCondition
     */
    @XmlEnumValue("Failed")
    FAILED("Failed"),

    /**
     * Loyalty Award Transaction
     */
    @XmlEnumValue("Award")
    AWARD("Award"),

    /**
     * Loyalty Reversal Award Transaction
     */
    @XmlEnumValue("ReverseAward")
    REVERSE_AWARD("ReverseAward"),

    /**
     * Loyalty Redemption Transaction
     */
    @XmlEnumValue("Redemption")
    REDEMPTION("Redemption"),

    /**
     * Loyalty Reversal Redemption Transaction
     */
    @XmlEnumValue("ReverseRedemption")
    REVERSE_REDEMPTION("ReverseRedemption"),

    /**
     * Loyalty Rebate Transaction
     */
    @XmlEnumValue("Rebate")
    REBATE("Rebate"),

    /**
     * Loyalty Reversal Rebate Transaction
     */
    @XmlEnumValue("ReverseRebate")
    REVERSE_REBATE("ReverseRebate");
    private final String value;

    TransactionType(String v) {
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
     * From value transaction type.
     *
     * @param v the v
     * @return the transaction type
     */
    public static TransactionType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
