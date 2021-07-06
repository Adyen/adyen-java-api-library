package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Enable Service Request messageType. -- Usage: It conveys the services that will be enabled for the  POI Terminal without the request of the Sale System, and a possible invitation for the Customer to start the services.
 *
 * <p>Java class for EnableServiceRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EnableServiceRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServicesEnabled" type="{}ServicesEnabled" minOccurs="0"/&gt;
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TransactionAction" use="required" type="{}TransactionActionType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnableServiceRequest", propOrder = {
        "servicesEnabled",
        "displayOutput"
})
public class EnableServiceRequest {

    /**
     * The Services enabled.
     */
    @XmlList
    @XmlElement(name = "ServicesEnabled")
    @Schema(description = "Services which are enabled before the start-up of a transaction --Rule: Mandatory if TransactionAction is \"StartTransaction\", absent if not.")
    protected List<ServicesEnabledType> servicesEnabled;
    /**
     * The Display output.
     */
    @XmlElement(name = "DisplayOutput")
    @Schema(description = "Information to display and the way to process the display.")
    protected DisplayOutput displayOutput;
    /**
     * The Transaction action.
     */
    @XmlElement(name = "TransactionAction", required = true)
    @Schema(description = "Action to realise on a transaction.")
    protected TransactionActionType transactionAction;

    /**
     * Gets the value of the servicesEnabled property.
     * <p>
     * <p>
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicesEnabled property.
     * <p>
     * <p>
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicesEnabled().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicesEnabledType }
     *
     * @return the services enabled
     */
    public List<ServicesEnabledType> getServicesEnabled() {
        if (servicesEnabled == null) {
            servicesEnabled = new ArrayList<>();
        }
        return this.servicesEnabled;
    }

    /**
     * Gets the value of the displayOutput property.
     *
     * @return possible      object is     {@link DisplayOutput }
     */
    public DisplayOutput getDisplayOutput() {
        return displayOutput;
    }

    /**
     * Sets the value of the displayOutput property.
     *
     * @param value allowed object is     {@link DisplayOutput }
     */
    public void setDisplayOutput(DisplayOutput value) {
        this.displayOutput = value;
    }

    /**
     * Gets the value of the transactionAction property.
     *
     * @return possible      object is     {@link TransactionActionType }
     */
    public TransactionActionType getTransactionAction() {
        return transactionAction;
    }

    /**
     * Sets the value of the transactionAction property.
     *
     * @param value allowed object is     {@link TransactionActionType }
     */
    public void setTransactionAction(TransactionActionType value) {
        this.transactionAction = value;
    }

}
