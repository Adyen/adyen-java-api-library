package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for DocumentQualifierType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="DocumentQualifierType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SaleReceipt"/&gt;
 *     &lt;enumeration value="CashierReceipt"/&gt;
 *     &lt;enumeration value="CustomerReceipt"/&gt;
 *     &lt;enumeration value="Document"/&gt;
 *     &lt;enumeration value="Voucher"/&gt;
 *     &lt;enumeration value="Journal"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "DocumentQualifierType")
@XmlEnum
public enum DocumentQualifierType {


    /**
     * Where the POI system print the Sale receipt when requested by the Sale Terminal.
     */
    @XmlEnumValue("SaleReceipt")
    @Schema(description = "Where the POI system print the Sale receipt when requested by the Sale Terminal.")
    SALE_RECEIPT("SaleReceipt"),

    /**
     * Where the Sale system print the Cashier copy of the Payment receipt when requested by the POI Terminal.
     */
    @XmlEnumValue("CashierReceipt")
    @Schema(description = "Where the Sale system print the Cashier copy of the Payment receipt when requested by the POI Terminal.")
    CASHIER_RECEIPT("CashierReceipt"),

    /**
     * Where you print the Customer Payment receipt that could be located on the Sale Terminal or in some cases a restricted Customer Sale ticket on the POI Terminal.
     */
    @XmlEnumValue("CustomerReceipt")
    @Schema(description = "Where you print the Customer Payment receipt that could be located on the Sale Terminal or in some cases a restricted Customer Sale ticket on the POI Terminal.")
    CUSTOMER_RECEIPT("CustomerReceipt"),

    /**
     * When the POI System wants to print specific document (check, dynamic currency conversion ...).  Used by the Sale System when the printer is not located on the
     */
    @XmlEnumValue("Document")
    @Schema(description = "When the POI System wants to print specific document (check, dynamic currency conversion ...).  Used by the Sale System when the printer is not located on the")
    DOCUMENT("Document"),

    /**
     * Coupons, voucher or special ticket generated by the POI or the Sale System and to be printed.
     */
    @XmlEnumValue("Voucher")
    @Schema(description = "Coupons, voucher or special ticket generated by the POI or the Sale System and to be printed.")
    VOUCHER("Voucher"),

    /**
     * When the POI or the Sale System wants to store a messageType on the journal printer or electronic journal of the Sale Terminal (it is sometimes a Sale
     */
    @XmlEnumValue("Journal")
    @Schema(description = "When the POI or the Sale System wants to store a message on the journal printer or electronic journal of the Sale Terminal (it is sometimes a Sale")
    JOURNAL("Journal");
    private final String value;

    DocumentQualifierType(String v) {
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
     * From value document qualifier type.
     *
     * @param v the v
     * @return the document qualifier type
     */
    public static DocumentQualifierType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}