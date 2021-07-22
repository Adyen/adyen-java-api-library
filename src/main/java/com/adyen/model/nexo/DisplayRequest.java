package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Display Request messageType. -- Usage: It conveys the data to display and the way to process the display. It contains the complete content to display. It might contain an operation (the DisplayOutput element) per Display Device type.
 *
 * <p>Java class for DisplayRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DisplayRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DisplayOutput" type="{}DisplayOutput" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayRequest", propOrder = {
        "displayOutput"
})
public class DisplayRequest {

    /**
     * The Display output.
     */
    @XmlElement(name = "DisplayOutput", required = true)
    @Schema(description = "Information to display and the way to process the display. --Rule: Complete display content for output devices. At most one DisplayOutput per  Device/ InfoQualify pair")
    protected List<DisplayOutput> displayOutput;

    /**
     * Gets the value of the displayOutput property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayOutput property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayOutput().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayOutput }
     *
     * @return the display output
     */
    public List<DisplayOutput> getDisplayOutput() {
        if (displayOutput == null) {
            displayOutput = new ArrayList<>();
        }
        return this.displayOutput;
    }

}
