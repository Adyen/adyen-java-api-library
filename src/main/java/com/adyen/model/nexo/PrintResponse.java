
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Print Response messageType. -- Usage: It conveys the result of the print, parallel to the messageType request, except if response not required and absent.
 *
 * <p>Java class for PrintResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PrintResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintResponse", propOrder = {
    "response"
})
public class PrintResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlAttribute(name = "DocumentQualifier", required = true)
    protected DocumentQualifierType documentQualifier;

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
     * Gets the value of the documentQualifier property.
     *
     * @return
     *     possible object is
     *     {@link DocumentQualifierType }
     *
     */
    public DocumentQualifierType getDocumentQualifier() {
        return documentQualifier;
    }

    /**
     * Sets the value of the documentQualifier property.
     *
     * @param value
     *     allowed object is
     *     {@link DocumentQualifierType }
     *
     */
    public void setDocumentQualifier(DocumentQualifierType value) {
        this.documentQualifier = value;
    }

}
