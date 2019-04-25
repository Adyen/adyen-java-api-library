
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
 * Definition: Functional profile of the Sale Terminal. -- Usage: Sent in the Login Request to identify the functions that might be requested by the Sale Terminal during the session.  The value of this data element contains:  One of the generic profile: Basic, Standard or Extended,   A list (possibly
 * 
 * <p>Java class for SaleProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SaleProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceProfiles" type="{}ServiceProfilesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GenericProfile" type="{}GenericProfileTypeCode" default="Standard" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleProfileType", propOrder = {
    "serviceProfiles"
})
public class SaleProfileType {

    @XmlList
    @XmlElement(name = "ServiceProfiles")
    protected List<String> serviceProfiles;
    @XmlAttribute(name = "GenericProfile")
    protected String genericProfile;

    /**
     * Gets the value of the serviceProfiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceProfiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceProfiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceProfiles() {
        if (serviceProfiles == null) {
            serviceProfiles = new ArrayList<String>();
        }
        return this.serviceProfiles;
    }

    /**
     * Gets the value of the genericProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericProfile() {
        if (genericProfile == null) {
            return "Standard";
        } else {
            return genericProfile;
        }
    }

    /**
     * Sets the value of the genericProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericProfile(String value) {
        this.genericProfile = value;
    }

}
