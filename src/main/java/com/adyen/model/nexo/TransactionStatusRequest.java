package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the TransactionStatus Request messageType. -- Usage: It conveys Information requested for status of the last or current Payment, Loyalty or Reversal transaction.
 *
 * <p>Java class for TransactionStatusRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TransactionStatusRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MessageReference" type="{}MessageReference" minOccurs="0"/&gt;
 *         &lt;element name="DocumentQualifier" type="{}DocumentQualifierType" maxOccurs="2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ReceiptReprintFlag" type="{}ReceiptReprintFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionStatusRequest", propOrder = {
        "messageReference",
        "documentQualifier"
})
public class TransactionStatusRequest {

    /**
     * The Message reference.
     */
    @XmlElement(name = "MessageReference")
    @Schema(description = "Identification of a previous POI transaction. --Rule: Present if it contains any data")
    protected MessageReference messageReference;
    /**
     * The Document qualifier.
     */
    @XmlElement(name = "DocumentQualifier")
    @Schema(description = "Qualification of the document to print to the Cashier or the Customer. --Rule: CustomerReceipt or CashierReceipt. Mandatory if ReceiptReprintFlag is True, otherwise absent.")
    @XmlSchemaType(name = "string")
    protected List<DocumentQualifierType> documentQualifier;
    /**
     * The Receipt reprint flag.
     */
    @XmlElement(name = "ReceiptReprintFlag")
    @Schema(description = "Request to reprint the POI receipt(s).")
    protected Boolean receiptReprintFlag;

    /**
     * Gets the value of the messageReference property.
     *
     * @return possible      object is     {@link MessageReference }
     */
    public MessageReference getMessageReference() {
        return messageReference;
    }

    /**
     * Sets the value of the messageReference property.
     *
     * @param value allowed object is     {@link MessageReference }
     */
    public void setMessageReference(MessageReference value) {
        this.messageReference = value;
    }

    /**
     * Gets the value of the documentQualifier property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentQualifier property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentQualifier().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentQualifierType }
     *
     * @return the document qualifier
     */
    public List<DocumentQualifierType> getDocumentQualifier() {
        if (documentQualifier == null) {
            documentQualifier = new ArrayList<>();
        }
        return this.documentQualifier;
    }

    /**
     * Gets the value of the receiptReprintFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isReceiptReprintFlag() {
        if (receiptReprintFlag == null) {
            return false;
        } else {
            return receiptReprintFlag;
        }
    }

    /**
     * Sets the value of the receiptReprintFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setReceiptReprintFlag(Boolean value) {
        this.receiptReprintFlag = value;
    }

}
