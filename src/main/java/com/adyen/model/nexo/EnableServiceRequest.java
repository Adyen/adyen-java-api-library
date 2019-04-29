
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Enable Service Request messageType. -- Usage: It conveys the services that will be enabled for the  POI Terminal without the request of the Sale System, and a possible invitation for the Customer to start the services.
 *
 * <p>Java class for EnableServiceRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EnableServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServicesEnabled" type="{}ServicesEnabled" minOccurs="0"/>
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TransactionAction" use="required" type="{}TransactionActionType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnableServiceRequest", propOrder = {
    "servicesEnabled",
    "displayOutput"
})
public class EnableServiceRequest {

    @XmlList
    @XmlElement(name = "ServicesEnabled")
    protected List<ServicesEnabledType> servicesEnabled;
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutput displayOutput;
    @XmlAttribute(name = "TransactionAction", required = true)
    protected TransactionActionType transactionAction;

    /**
     * Gets the value of the servicesEnabled property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicesEnabled property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicesEnabled().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicesEnabledType }
     *
     *
     */
    public List<ServicesEnabledType> getServicesEnabled() {
        if (servicesEnabled == null) {
            servicesEnabled = new ArrayList<ServicesEnabledType>();
        }
        return this.servicesEnabled;
    }

    /**
     * Gets the value of the displayOutput property.
     *
     * @return
     *     possible object is
     *     {@link DisplayOutput }
     *
     */
    public DisplayOutput getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     *
     * @param value
     *     allowed object is
     *     {@link DisplayOutput }
     *
     */
    public void setDisplayOutput(DisplayOutput value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the transactionAction property.
     *
     * @return
     *     possible object is
     *     {@link TransactionActionType }
     *
     */
    public TransactionActionType getTransactionAction() {
        return transactionAction;
    }

    /**
     * Sets the value of the transactionAction property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionActionType }
     *
     */
    public void setTransactionAction(TransactionActionType value) {
        this.transactionAction = value;
    }

}
