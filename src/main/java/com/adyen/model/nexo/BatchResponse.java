
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Batch Response messageType. -- Usage: It conveys either the response of transactions to perform sent in the batch request, or a collection of results of performed Payment, Loyalty and Reversal transactions in a batch messageType or file.
 *
 * <p>Java class for BatchResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BatchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="PerformedTransaction" type="{}PerformedTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchResponse", propOrder = {
    "response",
    "performedTransaction"
})
public class BatchResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "PerformedTransaction")
    protected List<PerformedTransaction> performedTransaction;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the performedTransaction property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the performedTransaction property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerformedTransaction().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerformedTransaction }
     *
     *
     */
    public List<PerformedTransaction> getPerformedTransaction() {
        if (performedTransaction == null) {
            performedTransaction = new ArrayList<PerformedTransaction>();
        }
        return this.performedTransaction;
    }

}
