
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Print Request message. -- Usage: It conveys the data to print and the way to process the print. It contains the complete content to print.
 * 
 * <p>Java class for PrintRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrintRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrintOutput" type="{}PrintOutputType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrintRequestType", propOrder = {
    "printOutput"
})
public class PrintRequestType {

    @XmlElement(name = "PrintOutput", required = true)
    protected PrintOutputType printOutput;

    /**
     * Gets the value of the printOutput property.
     * 
     * @return
     *     possible object is
     *     {@link PrintOutputType }
     *     
     */
    public PrintOutputType getPrintOutput() {
        return printOutput;
    }

    /**
     * Sets the value of the printOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintOutputType }
     *     
     */
    public void setPrintOutput(PrintOutputType value) {
        this.printOutput = value;
    }

}
