
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: State of a Host. -- Usage: Indicate the reachability of the host by the POI Terminal.
 * 
 * <p>Java class for HostStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="AcquirerID" use="required" type="{}AcquirerIDType" />
 *       &lt;attribute name="IsReachableFlag" type="{}IsReachableFlagType" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostStatusType")
public class HostStatusType {

    @XmlAttribute(name = "AcquirerID", required = true)
    protected String acquirerID;
    @XmlAttribute(name = "IsReachableFlag")
    protected Boolean isReachableFlag;

    /**
     * Gets the value of the acquirerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerID() {
        return acquirerID;
    }

    /**
     * Sets the value of the acquirerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerID(String value) {
        this.acquirerID = value;
    }

    /**
     * Gets the value of the isReachableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsReachableFlag() {
        if (isReachableFlag == null) {
            return true;
        } else {
            return isReachableFlag;
        }
    }

    /**
     * Sets the value of the isReachableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsReachableFlag(Boolean value) {
        this.isReachableFlag = value;
    }

}
