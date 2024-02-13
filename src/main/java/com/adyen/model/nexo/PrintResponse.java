package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * &lt;complexType name="PrintResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DocumentQualifier" use="required" type="{}DocumentQualifierType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintResponse", propOrder = {
        "response"
})
public class PrintResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    @Schema(description = "Result of a message request processing.")
    protected Response response;
    /**
     * The Document qualifier.
     */
    @XmlElement(name = "DocumentQualifier", required = true)
    @Schema(description = "Qualification of the document to print to the Cashier or the Customer. --Rule: Copy")
    protected DocumentQualifierType documentQualifier;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the documentQualifier property.
     *
     * @return possible      object is     {@link DocumentQualifierType }
     */
    public DocumentQualifierType getDocumentQualifier() {
        return documentQualifier;
    }

    /**
     * Sets the value of the documentQualifier property.
     *
     * @param value allowed object is     {@link DocumentQualifierType }
     */
    public void setDocumentQualifier(DocumentQualifierType value) {
        this.documentQualifier = value;
    }

}
