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
 * Definition: Information related to the software and hardware feature of the Sale Terminal. -- Usage: In the Login Request, if a Sale Terminal is involved in the login. In other messages, when a logical device is out of order (SaleCapabilites), or when the other data have changed since or were not in the Login.
 *
 * <p>Java class for SaleTerminalData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleTerminalData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SaleCapabilities" type="{}SaleCapabilities" minOccurs="0"/&gt;
 *         &lt;element name="SaleProfile" type="{}SaleProfile" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TerminalEnvironment" type="{}TerminalEnvironmentType" /&gt;
 *       &lt;attribute name="TotalsGroupID" type="{}TotalsGroupID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleTerminalData", propOrder = {
        "saleCapabilities",
        "saleProfile"
})
public class SaleTerminalData {

    /**
     * The Sale capabilities.
     */
    @XmlList
    @XmlElement(name = "SaleCapabilities")
    @Schema(description = "Hardware capabilities of the Sale Terminal.")
    protected List<SaleCapabilitiesType> saleCapabilities;
    /**
     * The Sale profile.
     */
    @XmlElement(name = "SaleProfile")
    @Schema(description = "Functional profile of the Sale Terminal. --Rule: If at least one element is present")
    protected SaleProfile saleProfile;
    /**
     * The Terminal environment.
     */
    @XmlElement(name = "TerminalEnvironment")
    @Schema(description = "Environment of the Terminal.")
    protected TerminalEnvironmentType terminalEnvironment;
    /**
     * The Totals group id.
     */
    @XmlElement(name = "TotalsGroupID")
    @Schema(description = "Identification of a group of transaction on a POI Terminal, having the same Sale features. --Rule: If present, default value for all transaction.")
    protected String totalsGroupID;

    /**
     * Gets the value of the saleCapabilities property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleCapabilities property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleCapabilities().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SaleCapabilitiesType }
     *
     * @return the sale capabilities
     */
    public List<SaleCapabilitiesType> getSaleCapabilities() {
        if (saleCapabilities == null) {
            saleCapabilities = new ArrayList<>();
        }
        return this.saleCapabilities;
    }

    /**
     * Gets the value of the saleProfile property.
     *
     * @return possible      object is     {@link SaleProfile }
     */
    public SaleProfile getSaleProfile() {
        return saleProfile;
    }

    /**
     * Sets the value of the saleProfile property.
     *
     * @param value allowed object is     {@link SaleProfile }
     */
    public void setSaleProfile(SaleProfile value) {
        this.saleProfile = value;
    }

    /**
     * Gets the value of the terminalEnvironment property.
     *
     * @return possible      object is     {@link TerminalEnvironmentType }
     */
    public TerminalEnvironmentType getTerminalEnvironment() {
        return terminalEnvironment;
    }

    /**
     * Sets the value of the terminalEnvironment property.
     *
     * @param value allowed object is     {@link TerminalEnvironmentType }
     */
    public void setTerminalEnvironment(TerminalEnvironmentType value) {
        this.terminalEnvironment = value;
    }

    /**
     * Gets the value of the totalsGroupID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    /**
     * Sets the value of the totalsGroupID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTotalsGroupID(String value) {
        this.totalsGroupID = value;
    }

}
