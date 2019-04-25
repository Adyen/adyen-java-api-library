
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Login Response message. -- Usage: It conveys Information related to the Login to process
 * 
 * <p>Java class for LoginResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoginResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="POISystemData" type="{}POISystemDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResponseType", propOrder = {
    "response",
    "poiSystemData"
})
public class LoginResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "POISystemData")
    protected POISystemDataType poiSystemData;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the poiSystemData property.
     * 
     * @return
     *     possible object is
     *     {@link POISystemDataType }
     *     
     */
    public POISystemDataType getPOISystemData() {
        return poiSystemData;
    }

    /**
     * Sets the value of the poiSystemData property.
     * 
     * @param value
     *     allowed object is
     *     {@link POISystemDataType }
     *     
     */
    public void setPOISystemData(POISystemDataType value) {
        this.poiSystemData = value;
    }

}
