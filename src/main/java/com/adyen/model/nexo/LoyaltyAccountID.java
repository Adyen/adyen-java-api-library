package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Identification of a Loyalty account. -- Usage: In the Payment or the Loyalty Request message, it allows to identify the loyalty account by the Sale Terminal instead of the POI Terminal (e.g. because the account identification is a bar-code read by the Cashier on a scanner device). In
 *
 * <p>Java class for LoyaltyAccountID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyAccountID"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="LoyaltyID" use="required" type="{}LoyaltyID" /&gt;
 *       &lt;attribute name="EntryMode" use="required" type="{}EntryMode" /&gt;
 *       &lt;attribute name="IdentificationType" use="required" type="{}IdentificationType" /&gt;
 *       &lt;attribute name="IdentificationSupport" type="{}IdentificationSupportType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyAccountID")
public class LoyaltyAccountID {

    @XmlAttribute(name = "LoyaltyID", required = true)
    protected String loyaltyID;
    @XmlAttribute(name = "EntryMode", required = true)
    protected List<EntryModeType> entryMode;
    @XmlAttribute(name = "IdentificationType", required = true)
    protected IdentificationType identificationType;
    @XmlAttribute(name = "IdentificationSupport")
    protected IdentificationSupportType identificationSupport;

    /**
     * Gets the value of the loyaltyID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLoyaltyID() {
        return loyaltyID;
    }

    /**
     * Sets the value of the loyaltyID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLoyaltyID(String value) {
        this.loyaltyID = value;
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
     */
    public List<EntryModeType> getEntryMode() {
        if (entryMode == null) {
            entryMode = new ArrayList<>();
        }
        return this.entryMode;
    }

    /**
     * Gets the value of the identificationType property.
     *
     * @return possible object is
     * {@link IdentificationType }
     */
    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    /**
     * Sets the value of the identificationType property.
     *
     * @param value allowed object is
     *              {@link IdentificationType }
     */
    public void setIdentificationType(IdentificationType value) {
        this.identificationType = value;
    }

    /**
     * Gets the value of the identificationSupport property.
     *
     * @return possible object is
     * {@link IdentificationSupportType }
     */
    public IdentificationSupportType getIdentificationSupport() {
        return identificationSupport;
    }

    /**
     * Sets the value of the identificationSupport property.
     *
     * @param value allowed object is
     *              {@link IdentificationSupportType }
     */
    public void setIdentificationSupport(IdentificationSupportType value) {
        this.identificationSupport = value;
    }

}
