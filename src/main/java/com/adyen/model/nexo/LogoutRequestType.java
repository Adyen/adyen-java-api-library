
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Logout Request message. -- Usage: Empty
 * 
 * <p>Java class for LogoutRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogoutRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="MaintenanceAllowed" type="{}MaintenanceAllowedType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogoutRequestType")
public class LogoutRequestType {

    @XmlAttribute(name = "MaintenanceAllowed")
    protected Boolean maintenanceAllowed;

    /**
     * Gets the value of the maintenanceAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMaintenanceAllowed() {
        if (maintenanceAllowed == null) {
            return false;
        } else {
            return maintenanceAllowed;
        }
    }

    /**
     * Sets the value of the maintenanceAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaintenanceAllowed(Boolean value) {
        this.maintenanceAllowed = value;
    }

}
