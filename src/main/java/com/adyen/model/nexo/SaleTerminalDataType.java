
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
 * Definition: Information related to the software and hardware feature of the Sale Terminal. -- Usage: In the Login Request, if a Sale Terminal is involved in the login. In other messages, when a logical device is out of order (SaleCapabilites), or when the other data have changed since or were not in the Login.
 * 
 * <p>Java class for SaleTerminalDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SaleTerminalDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleCapabilities" type="{}SaleCapabilitiesType" minOccurs="0"/>
 *         &lt;element name="SaleProfile" type="{}SaleProfileType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TerminalEnvironment" type="{}TerminalEnvironmentTypeCode" />
 *       &lt;attribute name="TotalsGroupID" type="{}TotalsGroupIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleTerminalDataType", propOrder = {
    "saleCapabilities",
    "saleProfile"
})
public class SaleTerminalDataType {

    @XmlList
    @XmlElement(name = "SaleCapabilities")
    protected List<String> saleCapabilities;
    @XmlElement(name = "SaleProfile")
    protected SaleProfileType saleProfile;
    @XmlAttribute(name = "TerminalEnvironment")
    protected String terminalEnvironment;
    @XmlAttribute(name = "TotalsGroupID")
    protected String totalsGroupID;

    /**
     * Gets the value of the saleCapabilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleCapabilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleCapabilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSaleCapabilities() {
        if (saleCapabilities == null) {
            saleCapabilities = new ArrayList<String>();
        }
        return this.saleCapabilities;
    }

    /**
     * Gets the value of the saleProfile property.
     * 
     * @return
     *     possible object is
     *     {@link SaleProfileType }
     *     
     */
    public SaleProfileType getSaleProfile() {
        return saleProfile;
    }

    /**
     * Sets the value of the saleProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleProfileType }
     *     
     */
    public void setSaleProfile(SaleProfileType value) {
        this.saleProfile = value;
    }

    /**
     * Gets the value of the terminalEnvironment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalEnvironment() {
        return terminalEnvironment;
    }

    /**
     * Sets the value of the terminalEnvironment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalEnvironment(String value) {
        this.terminalEnvironment = value;
    }

    /**
     * Gets the value of the totalsGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    /**
     * Sets the value of the totalsGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalsGroupID(String value) {
        this.totalsGroupID = value;
    }

}
