
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: State of a POI Terminal. -- Usage: Indicate the availability of the POI Terminal components. The data element is absent if the component is not part of the POI Terminal.
 *
 * <p>Java class for POIStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POIStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CashHandlingDevice" type="{}CashHandlingDevice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GlobalStatus" use="required" type="{}GlobalStatusType" />
 *       &lt;attribute name="SecurityOKFlag" type="{}SecurityOKFlag" />
 *       &lt;attribute name="PEDOKFlag" type="{}PEDOKFlag" />
 *       &lt;attribute name="CardReaderOKFlag" type="{}CardReaderOKFlag" />
 *       &lt;attribute name="PrinterStatus" type="{}PrinterStatusType" />
 *       &lt;attribute name="CommunicationOKFlag" type="{}CommunicationOKFlag" />
 *       &lt;attribute name="FraudPreventionFlag" type="{}FraudPreventionFlag" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POIStatus", propOrder = {
    "cashHandlingDevice"
})
public class POIStatus {

    @XmlElement(name = "CashHandlingDevice")
    protected List<CashHandlingDevice> cashHandlingDevice;
    @XmlAttribute(name = "GlobalStatus", required = true)
    protected GlobalStatusType globalStatus;
    @XmlAttribute(name = "SecurityOKFlag")
    protected Boolean securityOKFlag;
    @XmlAttribute(name = "PEDOKFlag")
    protected Boolean pedokFlag;
    @XmlAttribute(name = "CardReaderOKFlag")
    protected Boolean cardReaderOKFlag;
    @XmlAttribute(name = "PrinterStatus")
    protected PrinterStatusType printerStatus;
    @XmlAttribute(name = "CommunicationOKFlag")
    protected Boolean communicationOKFlag;
    @XmlAttribute(name = "FraudPreventionFlag")
    protected Boolean fraudPreventionFlag;

    /**
     * Gets the value of the cashHandlingDevice property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cashHandlingDevice property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCashHandlingDevice().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CashHandlingDevice }
     *
     *
     */
    public List<CashHandlingDevice> getCashHandlingDevice() {
        if (cashHandlingDevice == null) {
            cashHandlingDevice = new ArrayList<CashHandlingDevice>();
        }
        return this.cashHandlingDevice;
    }

    /**
     * Gets the value of the globalStatus property.
     *
     * @return
     *     possible object is
     *     {@link GlobalStatusType }
     *
     */
    public GlobalStatusType getGlobalStatus() {
        return globalStatus;
    }

    /**
     * Sets the value of the globalStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link GlobalStatusType }
     *
     */
    public void setGlobalStatus(GlobalStatusType value) {
        this.globalStatus = value;
    }

    /**
     * Gets the value of the securityOKFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isSecurityOKFlag() {
        return securityOKFlag;
    }

    /**
     * Sets the value of the securityOKFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSecurityOKFlag(Boolean value) {
        this.securityOKFlag = value;
    }

    /**
     * Gets the value of the pedokFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isPEDOKFlag() {
        return pedokFlag;
    }

    /**
     * Sets the value of the pedokFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPEDOKFlag(Boolean value) {
        this.pedokFlag = value;
    }

    /**
     * Gets the value of the cardReaderOKFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isCardReaderOKFlag() {
        return cardReaderOKFlag;
    }

    /**
     * Sets the value of the cardReaderOKFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCardReaderOKFlag(Boolean value) {
        this.cardReaderOKFlag = value;
    }

    /**
     * Gets the value of the printerStatus property.
     *
     * @return
     *     possible object is
     *     {@link PrinterStatusType }
     *
     */
    public PrinterStatusType getPrinterStatus() {
        return printerStatus;
    }

    /**
     * Sets the value of the printerStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link PrinterStatusType }
     *
     */
    public void setPrinterStatus(PrinterStatusType value) {
        this.printerStatus = value;
    }

    /**
     * Gets the value of the communicationOKFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isCommunicationOKFlag() {
        return communicationOKFlag;
    }

    /**
     * Sets the value of the communicationOKFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCommunicationOKFlag(Boolean value) {
        this.communicationOKFlag = value;
    }

    /**
     * Gets the value of the fraudPreventionFlag property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isFraudPreventionFlag() {
        return fraudPreventionFlag;
    }

    /**
     * Sets the value of the fraudPreventionFlag property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setFraudPreventionFlag(Boolean value) {
        this.fraudPreventionFlag = value;
    }

}
