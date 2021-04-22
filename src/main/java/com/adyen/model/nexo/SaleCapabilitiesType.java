package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for SaleCapabilitiesType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="SaleCapabilitiesType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CashierStatus"/&gt;
 *     &lt;enumeration value="CashierError"/&gt;
 *     &lt;enumeration value="CashierDisplay"/&gt;
 *     &lt;enumeration value="POIReplication"/&gt;
 *     &lt;enumeration value="CashierInput"/&gt;
 *     &lt;enumeration value="CustomerAssistance"/&gt;
 *     &lt;enumeration value="CustomerDisplay"/&gt;
 *     &lt;enumeration value="CustomerError"/&gt;
 *     &lt;enumeration value="CustomerInput"/&gt;
 *     &lt;enumeration value="PrinterReceipt"/&gt;
 *     &lt;enumeration value="PrinterDocument"/&gt;
 *     &lt;enumeration value="PrinterVoucher"/&gt;
 *     &lt;enumeration value="MagStripe"/&gt;
 *     &lt;enumeration value="ICC"/&gt;
 *     &lt;enumeration value="EMVContactless"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "SaleCapabilitiesType")
@XmlEnum
public enum SaleCapabilitiesType {


    /**
     * To display to the Cashier a new state on which the POI is entering. For instance, during a payment, the POI could display to the Cashier that POI request an
     */
    @XmlEnumValue("CashierStatus")
    @Schema(description = "To display to the Cashier a new state on which the POI is entering. For instance, during a payment, the POI could display to the Cashier that POI request an")
    CASHIER_STATUS("CashierStatus"),

    /**
     * To display to the Cashier information related to an error situation occurring on the POI.
     */
    @XmlEnumValue("CashierError")
    @Schema(description = "To display to the Cashier information related to an error situation occurring on the POI.")
    CASHIER_ERROR("CashierError"),

    /**
     * Standard Cashier display interface (to ask question, or to show information).
     */
    @XmlEnumValue("CashierDisplay")
    @Schema(description = "Standard Cashier display interface (to ask question, or to show information).")
    CASHIER_DISPLAY("CashierDisplay"),

    /**
     * Information displayed on the Cardholder POI interface, replicated on the Cashier interface.
     */
    @XmlEnumValue("POIReplication")
    @Schema(description = "Information displayed on the Cardholder POI interface, replicated on the Cashier interface.")
    POI_REPLICATION("POIReplication"),

    /**
     * Any kind of keyboard allowing all or part of the commands of the Input messageType request from the Sale System to the POI System (InputCommand data element). The
     */
    @XmlEnumValue("CashierInput")
    @Schema(description = "Any kind of keyboard allowing all or part of the commands of the Input message request from the Sale System to the POI System (InputCommand data element). The")
    CASHIER_INPUT("CashierInput"),

    /**
     * Input of the Cardholder POI interface which can be entered by the Cashier to assist the Customer.
     */
    @XmlEnumValue("CustomerAssistance")
    @Schema(description = "Input of the Cardholder POI interface which can be entered by the Cashier to assist the Customer.")
    CUSTOMER_ASSISTANCE("CustomerAssistance"),

    /**
     * Standard Customer display interface used by the POI System to ask question, or to show information to the Customer inside a Service dialogue.
     */
    @XmlEnumValue("CustomerDisplay")
    @Schema(description = "Standard Customer display interface used by the POI System to ask question, or to show information to the Customer inside a Service dialogue.")
    CUSTOMER_DISPLAY("CustomerDisplay"),

    /**
     * To display to the Customer information is related to an error situation occurring on the Sale Terminal during a Sale transaction.
     */
    @XmlEnumValue("CustomerError")
    @Schema(description = "To display to the Customer information is related to an error situation occurring on the Sale Terminal during a Sale transaction.")
    CUSTOMER_ERROR("CustomerError"),

    /**
     * Any kind of keyboard allowing all or part of the commands of the Input messageType request from the Sale System to the POI System (InputCommand data element). The
     */
    @XmlEnumValue("CustomerInput")
    @Schema(description = "Any kind of keyboard allowing all or part of the commands of the Input message request from the Sale System to the POI System (InputCommand data element). The")
    CUSTOMER_INPUT("CustomerInput"),

    /**
     * Printer for the Payment receipt.
     */
    @XmlEnumValue("PrinterReceipt")
    @Schema(description = "Printer for the Payment receipt.")
    PRINTER_RECEIPT("PrinterReceipt"),

    /**
     * When the POI System wants to print specific document (check, dynamic currency conversion ...).
     */
    @XmlEnumValue("PrinterDocument")
    @Schema(description = "When the POI System wants to print specific document (check, dynamic currency conversion ...). ")
    PRINTER_DOCUMENT("PrinterDocument"),

    /**
     * Coupons, voucher or special ticket generated by the POI and to be printed.
     */
    @XmlEnumValue("PrinterVoucher")
    @Schema(description = "Coupons, voucher or special ticket generated by the POI and to be printed.")
    PRINTER_VOUCHER("PrinterVoucher"),

    /**
     * Magnetic stripe card reader
     */
    @XmlEnumValue("MagStripe")
    @Schema(description = "Magnetic stripe card reader")
    MAG_STRIPE("MagStripe"),

    /**
     * Contact  ICC card reader
     */
    ICC("ICC"),

    /**
     * Contactless card reader with EMV applications
     */
    @XmlEnumValue("EMVContactless")
    @Schema(description = "Contactless card reader with EMV applications")
    EMV_CONTACTLESS("EMVContactless");
    private final String value;

    SaleCapabilitiesType(String v) {
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
     * From value sale capabilities type.
     *
     * @param v the v
     * @return the sale capabilities type
     */
    public static SaleCapabilitiesType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
