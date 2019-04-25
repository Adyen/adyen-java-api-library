
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Display Response message. -- Usage: It conveys the result of the display, parallel to the message request, except if response not required and absent.
 * 
 * <p>Java class for DisplayResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisplayResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutputResult" type="{}OutputResultType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayResponseType", propOrder = {
    "outputResult"
})
public class DisplayResponseType {

    @XmlElement(name = "OutputResult", required = true)
    protected List<OutputResultType> outputResult;

    /**
     * Gets the value of the outputResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputResultType }
     * 
     * 
     */
    public List<OutputResultType> getOutputResult() {
        if (outputResult == null) {
            outputResult = new ArrayList<OutputResultType>();
        }
        return this.outputResult;
    }

}
