
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
 * Definition: Content of the Enable Service Request message. -- Usage: It conveys the services that will be enabled for the  POI Terminal without the request of the Sale System, and a possible invitation for the Customer to start the services.
 * 
 * <p>Java class for EnableServiceRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnableServiceRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServicesEnabled" type="{}ServicesEnabledType" minOccurs="0"/>
 *         &lt;element name="DisplayOutput" type="{}DisplayOutputType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TransactionAction" use="required" type="{}TransactionActionTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnableServiceRequestType", propOrder = {
    "servicesEnabled",
    "displayOutput"
})
public class EnableServiceRequestType {

    @XmlList
    @XmlElement(name = "ServicesEnabled")
    protected List<String> servicesEnabled;
    @XmlElement(name = "DisplayOutput")
    protected DisplayOutputType displayOutput;
    @XmlAttribute(name = "TransactionAction", required = true)
    protected String transactionAction;

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
     * {@link String }
     * 
     * 
     */
    public List<String> getServicesEnabled() {
        if (servicesEnabled == null) {
            servicesEnabled = new ArrayList<String>();
        }
        return this.servicesEnabled;
    }

    /**
     * Gets the value of the displayOutput property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayOutputType }
     *     
     */
    public DisplayOutputType getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayOutputType }
     *     
     */
    public void setDisplayOutput(DisplayOutputType value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the transactionAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionAction() {
        return transactionAction;
    }

    /**
     * Sets the value of the transactionAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionAction(String value) {
        this.transactionAction = value;
    }

}
