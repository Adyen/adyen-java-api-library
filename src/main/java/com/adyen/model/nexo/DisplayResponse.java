package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Display Response messageType. -- Usage: It conveys the result of the display, parallel to the messageType request, except if response not required and absent.
 *
 * <p>Java class for DisplayResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DisplayResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OutputResult" type="{}OutputResult" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayResponse", propOrder = {
        "outputResult"
})
public class DisplayResponse {

    /**
     * The Output result.
     */
    @XmlElement(name = "OutputResult", required = true)
    protected List<OutputResult> outputResult;

    /**
     * Gets the value of the outputResult property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputResult property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputResult().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link OutputResult }
     *
     * @return the output result
     */
    public List<OutputResult> getOutputResult() {
        if (outputResult == null) {
            outputResult = new ArrayList<>();
        }
        return this.outputResult;
    }

}
