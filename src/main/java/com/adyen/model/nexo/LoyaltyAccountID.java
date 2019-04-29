
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Definition: Identification of a Loyalty account. -- Usage: In the Payment or the Loyalty Request messageType, it allows to identify the loyalty account by the Sale Terminal instead of the POI Terminal (e.g. because the account identification is a bar-code read by the Cashier on a scanner device). In
 *
 * <p>Java class for LoyaltyAccountID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAccountID">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>TextString">
 *       &lt;attribute name="EntryMode" use="required" type="{}EntryMode" />
 *       &lt;attribute name="Identification" use="required" type="{}IdentificationType" />
 *       &lt;attribute name="IdentificationSupport" type="{}IdentificationSupportType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountID", propOrder = {
    "value"
})
public class LoyaltyAccountID {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "EntryMode", required = true)
    protected List<EntryModeType> entryMode;
    @XmlAttribute(name = "Identification", required = true)
    protected IdentificationType identification;
    @XmlAttribute(name = "IdentificationSupport")
    protected IdentificationSupportType identificationSupport;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the entryMode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryModeType }
     *
     *
     */
    public List<EntryModeType> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<EntryModeType>();
        }
        return this.entryMode;
    }

    /**
     * Gets the value of the identification property.
     *
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *
     */
    public IdentificationType getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     *
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *
     */
    public void setIdentification(IdentificationType value) {
        this.identification = value;
    }

    /**
     * Gets the value of the identificationSupport property.
     *
     * @return
     *     possible object is
     *     {@link IdentificationSupportType }
     *
     */
    public IdentificationSupportType getIdentificationSupport() {
        return identificationSupport;
    }

    /**
     * Sets the value of the identificationSupport property.
     *
     * @param value
     *     allowed object is
     *     {@link IdentificationSupportType }
     *
     */
    public void setIdentificationSupport(IdentificationSupportType value) {
        this.identificationSupport = value;
    }

}
