
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Definition: Information related to the POI System -- Usage: In the Login message response, the data structure contains information related to the POI System fixed for the session or defined as default value.
 *
 * <p>Java class for POISystemData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POISystemData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateTime" type="{}DateTime"/>
 *         &lt;element name="POISoftware" type="{}POISoftware"/>
 *         &lt;element name="POITerminalData" type="{}POITerminalData" minOccurs="0"/>
 *         &lt;element name="POIStatus" type="{}POIStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POISystemData", propOrder = {
    "dateTime",
    "poiSoftware",
    "poiTerminalData",
    "poiStatus"
})
public class POISystemData {

    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "POISoftware", required = true)
    protected POISoftware poiSoftware;
    @XmlElement(name = "POITerminalData")
    protected POITerminalData poiTerminalData;
    @XmlElement(name = "POIStatus")
    protected POIStatus poiStatus;

    /**
     * Gets the value of the dateTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the poiSoftware property.
     *
     * @return
     *     possible object is
     *     {@link POISoftware }
     *
     */
    public POISoftware getPOISoftware() {
        return poiSoftware;
    }

    /**
     * Sets the value of the poiSoftware property.
     *
     * @param value
     *     allowed object is
     *     {@link POISoftware }
     *
     */
    public void setPOISoftware(POISoftware value) {
        this.poiSoftware = value;
    }

    /**
     * Gets the value of the poiTerminalData property.
     *
     * @return
     *     possible object is
     *     {@link POITerminalData }
     *
     */
    public POITerminalData getPOITerminalData() {
        return poiTerminalData;
    }

    /**
     * Sets the value of the poiTerminalData property.
     *
     * @param value
     *     allowed object is
     *     {@link POITerminalData }
     *
     */
    public void setPOITerminalData(POITerminalData value) {
        this.poiTerminalData = value;
    }

    /**
     * Gets the value of the poiStatus property.
     *
     * @return
     *     possible object is
     *     {@link POIStatus }
     *
     */
    public POIStatus getPOIStatus() {
        return poiStatus;
    }

    /**
     * Sets the value of the poiStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link POIStatus }
     *
     */
    public void setPOIStatus(POIStatus value) {
        this.poiStatus = value;
    }

}
