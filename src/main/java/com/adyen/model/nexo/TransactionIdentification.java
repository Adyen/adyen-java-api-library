package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Definition: Identification of a transaction for the Sale System or the POI System.
 *
 * <p>Java class for TransactionIdentification complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionIdentification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="TransactionID" use="required" type="{}TransactionID" /&gt;
 *       &lt;attribute name="TimeStamp" use="required" type="{}TimeStamp" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionIdentification")
public class TransactionIdentification {

    /**
     * The Transaction id.
     */
    @XmlElement(name = "TransactionID", required = true)
    @Schema(description = "Unique identification of a transaction")
    protected String transactionID;
    /**
     * The Time stamp.
     */
    @XmlElement(name = "TimeStamp", required = true)
    @Schema(description = "Date and time of a transaction for the Sale System, the POI System or the Acquirer.")
    protected XMLGregorianCalendar timeStamp;

    /**
     * Gets the value of the transactionID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the timeStamp property.
     *
     * @return possible      object is     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     *
     * @param value allowed object is     {@link XMLGregorianCalendar }
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

}
