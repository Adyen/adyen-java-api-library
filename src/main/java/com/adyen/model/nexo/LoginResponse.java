
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Login Response message. -- Usage: It conveys Information related to the Login to process
 *
 * <p>Java class for LoginResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoginResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="POISystemData" type="{}POISystemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginResponse", propOrder = {
    "response",
    "poiSystemData"
})
public class LoginResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "POISystemData")
    protected POISystemData poiSystemData;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the poiSystemData property.
     *
     * @return
     *     possible object is
     *     {@link POISystemData }
     *
     */
    public POISystemData getPOISystemData() {
        return poiSystemData;
    }

    /**
     * Sets the value of the poiSystemData property.
     *
     * @param value
     *     allowed object is
     *     {@link POISystemData }
     *
     */
    public void setPOISystemData(POISystemData value) {
        this.poiSystemData = value;
    }

}
