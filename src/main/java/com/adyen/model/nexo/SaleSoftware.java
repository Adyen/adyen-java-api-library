package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to the software of the Sale System which manages the Sale to POI protocol. -- Usage: Allows in a session to identify the product features of a Sale System.
 *
 * <p>Java class for SaleSoftware complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleSoftware"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ManufacturerID" use="required" type="{}ManufacturerID" /&gt;
 *       &lt;attribute name="ApplicationName" use="required" type="{}ApplicationName" /&gt;
 *       &lt;attribute name="SoftwareVersion" use="required" type="{}SoftwareVersion" /&gt;
 *       &lt;attribute name="CertificationCode" use="required" type="{}CertificationCode" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleSoftware")
public class SaleSoftware {

    /**
     * The Manufacturer id.
     */
    @XmlAttribute(name = "ManufacturerID", required = true)
    protected String manufacturerID;
    /**
     * The Application name.
     */
    @XmlAttribute(name = "ApplicationName", required = true)
    protected String applicationName;
    /**
     * The Software version.
     */
    @XmlAttribute(name = "SoftwareVersion", required = true)
    protected String softwareVersion;
    /**
     * The Certification code.
     */
    @XmlAttribute(name = "CertificationCode", required = true)
    protected String certificationCode;

    /**
     * Gets the value of the manufacturerID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getManufacturerID() {
        return manufacturerID;
    }

    /**
     * Sets the value of the manufacturerID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setManufacturerID(String value) {
        this.manufacturerID = value;
    }

    /**
     * Gets the value of the applicationName property.
     *
     * @return possible      object is     {@link String }
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the softwareVersion property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * Sets the value of the softwareVersion property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSoftwareVersion(String value) {
        this.softwareVersion = value;
    }

    /**
     * Gets the value of the certificationCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCertificationCode() {
        return certificationCode;
    }

    /**
     * Sets the value of the certificationCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCertificationCode(String value) {
        this.certificationCode = value;
    }

}
