
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
 * Definition: Functional profile of the POI Terminal. -- Usage: Sent in the Login Response to identify the profiles the POI Terminal support during the session. The value of this data element contains:  One of the generic profile: Basic, Standard or Extended,   A list (possibly empty) of services
 *
 * <p>Java class for POIProfile complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POIProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceProfiles" type="{}ServiceProfiles" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="GenericProfile" type="{}GenericProfileType" default="Standard" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POIProfile", propOrder = {
    "serviceProfiles"
})
public class POIProfile {

    @XmlList
    @XmlElement(name = "ServiceProfiles")
    protected List<ServiceProfilesType> serviceProfiles;
    @XmlAttribute(name = "GenericProfile")
    protected GenericProfileType genericProfile;

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
     * {@link ServiceProfilesType }
     *
     *
     */
    public List<ServiceProfilesType> getServiceProfiles() {
        if (serviceProfiles == null) {
            serviceProfiles = new ArrayList<ServiceProfilesType>();
        }
        return this.serviceProfiles;
    }

    /**
     * Gets the value of the genericProfile property.
     *
     * @return
     *     possible object is
     *     {@link GenericProfileType }
     *
     */
    public GenericProfileType getGenericProfile() {
        if (genericProfile == null) {
            return GenericProfileType.STANDARD;
        } else {
            return genericProfile;
        }
    }

    /**
     * Sets the value of the genericProfile property.
     *
     * @param value
     *     allowed object is
     *     {@link GenericProfileType }
     *
     */
    public void setGenericProfile(GenericProfileType value) {
        this.genericProfile = value;
    }

}
