
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Debit"/>
 *     &lt;enumeration value="Credit"/>
 *     &lt;enumeration value="ReverseDebit"/>
 *     &lt;enumeration value="ReverseCredit"/>
 *     &lt;enumeration value="OneTimeReservation"/>
 *     &lt;enumeration value="CompletedDeffered"/>
 *     &lt;enumeration value="FirstReservation"/>
 *     &lt;enumeration value="UpdateReservation"/>
 *     &lt;enumeration value="CompletedReservation"/>
 *     &lt;enumeration value="CashAdvance"/>
 *     &lt;enumeration value="IssuerInstalment"/>
 *     &lt;enumeration value="Declined"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Award"/>
 *     &lt;enumeration value="ReverseAward"/>
 *     &lt;enumeration value="Redemption"/>
 *     &lt;enumeration value="ReverseRedemption"/>
 *     &lt;enumeration value="Rebate"/>
 *     &lt;enumeration value="ReverseRebate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionTypeEnumeration")
@XmlEnum
public enum TransactionTypeEnumeration {


    /**
     * Payment Debit transactions (e.g. if PaymentType is "Normal")
     * 
     */
    @XmlEnumValue("Debit")
    DEBIT("Debit"),

    /**
     * Payment Credit transactions (e.g.  if PaymentType is "Refund")
     * 
     */
    @XmlEnumValue("Credit")
    CREDIT("Credit"),

    /**
     * Payment Reversal Debit transactions
     * 
     */
    @XmlEnumValue("ReverseDebit")
    REVERSE_DEBIT("ReverseDebit"),

    /**
     * Payment Reversal Credit transactions
     * 
     */
    @XmlEnumValue("ReverseCredit")
    REVERSE_CREDIT("ReverseCredit"),

    /**
     * Outstanding OneTimeReservation transactions, i.e. between OneTimeReservation and Completion
     * 
     */
    @XmlEnumValue("OneTimeReservation")
    ONE_TIME_RESERVATION("OneTimeReservation"),

    /**
     * OneTimeReservation transactions which have been completed by the Completion.
     * 
     */
    @XmlEnumValue("CompletedDeffered")
    COMPLETED_DEFFERED("CompletedDeffered"),

    /**
     * Outstanding FirstReservation transactions, i.e. between FirstReservation and UpdateReservation  or Completion
     * 
     */
    @XmlEnumValue("FirstReservation")
    FIRST_RESERVATION("FirstReservation"),

    /**
     * Outstanding UpdateReservation transactions, i.e. between UpdateReservation and UpdateReservation or Completion
     * 
     */
    @XmlEnumValue("UpdateReservation")
    UPDATE_RESERVATION("UpdateReservation"),

    /**
     * Reservation transactions which have been completed by the Completion.
     * 
     */
    @XmlEnumValue("CompletedReservation")
    COMPLETED_RESERVATION("CompletedReservation"),

    /**
     * Cash Advance transactions.
     * 
     */
    @XmlEnumValue("CashAdvance")
    CASH_ADVANCE("CashAdvance"),

    /**
     * Issuer instalment transactions.
     * 
     */
    @XmlEnumValue("IssuerInstalment")
    ISSUER_INSTALMENT("IssuerInstalment"),

    /**
     * ResultErrorCondition
     * 
     */
    @XmlEnumValue("Declined")
    DECLINED("Declined"),

    /**
     * ResultErrorCondition
     * 
     */
    @XmlEnumValue("Failed")
    FAILED("Failed"),

    /**
     * Loyalty Award Transaction
     * 
     */
    @XmlEnumValue("Award")
    AWARD("Award"),

    /**
     * Loyalty Reversal Award Transaction
     * 
     */
    @XmlEnumValue("ReverseAward")
    REVERSE_AWARD("ReverseAward"),

    /**
     * Loyalty Redemption Transaction
     * 
     */
    @XmlEnumValue("Redemption")
    REDEMPTION("Redemption"),

    /**
     * Loyalty Reversal Redemption Transaction
     * 
     */
    @XmlEnumValue("ReverseRedemption")
    REVERSE_REDEMPTION("ReverseRedemption"),

    /**
     * Loyalty Rebate Transaction
     * 
     */
    @XmlEnumValue("Rebate")
    REBATE("Rebate"),

    /**
     * Loyalty Reversal Rebate Transaction
     * 
     */
    @XmlEnumValue("ReverseRebate")
    REVERSE_REBATE("ReverseRebate");
    private final String value;

    TransactionTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionTypeEnumeration fromValue(String v) {
        for (TransactionTypeEnumeration c: TransactionTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
