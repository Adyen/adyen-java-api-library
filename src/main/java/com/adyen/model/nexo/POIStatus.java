package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: State of a POI Terminal. -- Usage: Indicate the availability of the POI Terminal components. The data element is absent if the component is not part of the POI Terminal.
 *
 * <p>Java class for POIStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POIStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CashHandlingDevice" type="{}CashHandlingDevice" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="GlobalStatus" use="required" type="{}GlobalStatusType" /&gt;
 *       &lt;attribute name="SecurityOKFlag" type="{}SecurityOKFlag" /&gt;
 *       &lt;attribute name="PEDOKFlag" type="{}PEDOKFlag" /&gt;
 *       &lt;attribute name="CardReaderOKFlag" type="{}CardReaderOKFlag" /&gt;
 *       &lt;attribute name="PrinterStatus" type="{}PrinterStatusType" /&gt;
 *       &lt;attribute name="CommunicationOKFlag" type="{}CommunicationOKFlag" /&gt;
 *       &lt;attribute name="FraudPreventionFlag" type="{}FraudPreventionFlag" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POIStatus", propOrder = {
        "cashHandlingDevice"
})
public class POIStatus {

    /**
     * The Cash handling device.
     */
    @XmlElement(name = "CashHandlingDevice")
    @Schema(description = "Status of cash handling device. --Rule: If cash handling devices present.")
    protected List<CashHandlingDevice> cashHandlingDevice;
    /**
     * The Global status.
     */
    @XmlElement(name = "GlobalStatus", required = true)
    @Schema(description = "Global status of a POI Server or POI Terminal.")
    protected GlobalStatusType globalStatus;
    /**
     * The Security ok flag.
     */
    @XmlElement(name = "SecurityOKFlag")
    @Schema(description = "Indicates if the security module of the POI is working and usable. --Rule: If security module present")
    protected Boolean securityOKFlag;
    /**
     * The Pedok flag.
     */
    @XmlElement(name = "PEDOKFlag")
    @Schema(description = "Indicates if the PED is working and usable. --Rule: If PED present")
    protected Boolean pedokFlag;
    /**
     * The Card reader ok flag.
     */
    @XmlElement(name = "CardReaderOKFlag")
    @Schema(description = "Indicates if the card readers are working and usable. --Rule: If card reader device present")
    protected Boolean cardReaderOKFlag;
    /**
     * The Printer status.
     */
    @XmlElement(name = "PrinterStatus")
    @Schema(description = "Indicates if the printer is working and usable. --Rule: If printer device present")
    protected PrinterStatusType printerStatus;
    /**
     * The Communication ok flag.
     */
    @XmlElement(name = "CommunicationOKFlag")
    @Schema(description = "Indicates if the communication infrastructure is working and usable. --Rule: If communication infrastructure present")
    protected Boolean communicationOKFlag;
    /**
     * The Fraud prevention flag.
     */
    @XmlElement(name = "FraudPreventionFlag")
    @Schema(description = "Indicate a suspicion of fraud by the POI System. --Rule: default False")
    protected Boolean fraudPreventionFlag;

    /**
     * Gets the value of the cashHandlingDevice property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cashHandlingDevice property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCashHandlingDevice().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CashHandlingDevice }
     *
     * @return the cash handling device
     */
    public List<CashHandlingDevice> getCashHandlingDevice() {
        if (cashHandlingDevice == null) {
            cashHandlingDevice = new ArrayList<>();
        }
        return this.cashHandlingDevice;
    }

    /**
     * Gets the value of the globalStatus property.
     *
     * @return possible      object is     {@link GlobalStatusType }
     */
    public GlobalStatusType getGlobalStatus() {
        return globalStatus;
    }

    /**
     * Sets the value of the globalStatus property.
     *
     * @param value allowed object is     {@link GlobalStatusType }
     */
    public void setGlobalStatus(GlobalStatusType value) {
        this.globalStatus = value;
    }

    /**
     * Gets the value of the securityOKFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isSecurityOKFlag() {
        return securityOKFlag;
    }

    /**
     * Sets the value of the securityOKFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setSecurityOKFlag(Boolean value) {
        this.securityOKFlag = value;
    }

    /**
     * Gets the value of the pedokFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isPEDOKFlag() {
        return pedokFlag;
    }

    /**
     * Sets the value of the pedokFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setPEDOKFlag(Boolean value) {
        this.pedokFlag = value;
    }

    /**
     * Gets the value of the cardReaderOKFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isCardReaderOKFlag() {
        return cardReaderOKFlag;
    }

    /**
     * Sets the value of the cardReaderOKFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setCardReaderOKFlag(Boolean value) {
        this.cardReaderOKFlag = value;
    }

    /**
     * Gets the value of the printerStatus property.
     *
     * @return possible      object is     {@link PrinterStatusType }
     */
    public PrinterStatusType getPrinterStatus() {
        return printerStatus;
    }

    /**
     * Sets the value of the printerStatus property.
     *
     * @param value allowed object is     {@link PrinterStatusType }
     */
    public void setPrinterStatus(PrinterStatusType value) {
        this.printerStatus = value;
    }

    /**
     * Gets the value of the communicationOKFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isCommunicationOKFlag() {
        return communicationOKFlag;
    }

    /**
     * Sets the value of the communicationOKFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setCommunicationOKFlag(Boolean value) {
        this.communicationOKFlag = value;
    }

    /**
     * Gets the value of the fraudPreventionFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isFraudPreventionFlag() {
        return fraudPreventionFlag;
    }

    /**
     * Sets the value of the fraudPreventionFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setFraudPreventionFlag(Boolean value) {
        this.fraudPreventionFlag = value;
    }

}
