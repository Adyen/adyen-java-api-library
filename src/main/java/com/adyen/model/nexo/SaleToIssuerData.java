package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Sale information intended for the Issuer. -- Usage: The POI System receives this information and sends it to the Acquirer for the Issuer without any change.
 *
 * <p>Java class for SaleToIssuerData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SaleToIssuerData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StatementReference" type="{}StatementReference" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleToIssuerData", propOrder = {
        "statementReference"
})
public class SaleToIssuerData {

    /**
     * The Statement reference.
     */
    @XmlElement(name = "StatementReference")
    @Schema(description = "Label to print on the bank statement. --Rule: Information to print on the bank statement")
    protected String statementReference;

    /**
     * Gets the value of the statementReference property.
     *
     * @return possible      object is     {@link String }
     */
    public String getStatementReference() {
        return statementReference;
    }

    /**
     * Sets the value of the statementReference property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setStatementReference(String value) {
        this.statementReference = value;
    }

}
