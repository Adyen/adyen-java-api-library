
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Sale information intended for the Issuer. -- Usage: The POI System receives this information and sends it to the Acquirer for the Issuer without any change.
 * 
 * <p>Java class for SaleToIssuerDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SaleToIssuerDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatementReference" type="{}StatementReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleToIssuerDataType", propOrder = {
    "statementReference"
})
public class SaleToIssuerDataType {

    @XmlElement(name = "StatementReference")
    protected String statementReference;

    /**
     * Gets the value of the statementReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementReference() {
        return statementReference;
    }

    /**
     * Sets the value of the statementReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementReference(String value) {
        this.statementReference = value;
    }

}
