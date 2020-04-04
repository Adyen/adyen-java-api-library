package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Identification of the stored value account or the stored value card -- Usage: It contains the identifications of the stored value account or the stored value card, and the associated product sold by the Sale System for stored value requests.
 *
 * <p>Java class for StoredValueAccountID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueAccountID"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="TextString"&gt;
 *       &lt;attribute name="StoredValueAccount" use="required" type="{}StoredValueAccountType" /&gt;
 *       &lt;attribute name="StoredValueProvider" type="{}StoredValueProvider" /&gt;
 *       &lt;attribute name="OwnerName" type="{}OwnerName" /&gt;
 *       &lt;attribute name="ExpiryDate" type="{}ExpiryDate" /&gt;
 *       &lt;attribute name="EntryMode" use="required" type="{}EntryMode" /&gt;
 *       &lt;attribute name="Identification" use="required" type="{}IdentificationType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueAccountID", propOrder = {
        "value"
})
public class StoredValueAccountID {

    /**
     * The Value.
     */
    @XmlValue
    protected String value;
    /**
     * The Stored value account.
     */
    @XmlAttribute(name = "StoredValueAccountType", required = true)
    protected StoredValueAccountType storedValueAccountType;
    /**
     * The Stored value provider.
     */
    @XmlAttribute(name = "StoredValueProvider")
    protected String storedValueProvider;
    /**
     * The Owner name.
     */
    @XmlAttribute(name = "OwnerName")
    protected String ownerName;
    /**
     * The Expiry date.
     */
    @XmlAttribute(name = "ExpiryDate")
    protected String expiryDate;
    /**
     * The Entry mode.
     */
    @XmlAttribute(name = "EntryMode", required = true)
    protected List<EntryModeType> entryMode;
    /**
     * The Identification.
     */
    @XmlAttribute(name = "IdentificationType", required = true)
    protected IdentificationType identificationType;

    /**
     * Gets the value of the value property.
     *
     * @return possible      object is     {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the storedValueAccountType property.
     *
     * @return possible      object is     {@link StoredValueAccountType }
     */
    public StoredValueAccountType getStoredValueAccountType() {
        return storedValueAccountType;
    }

    /**
     * Sets the value of the storedValueAccountType property.
     *
     * @param value allowed object is     {@link StoredValueAccountType }
     */
    public void setStoredValueAccountType(StoredValueAccountType value) {
        this.storedValueAccountType = value;
    }

    /**
     * Gets the value of the storedValueProvider property.
     *
     * @return possible      object is     {@link String }
     */
    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    /**
     * Sets the value of the storedValueProvider property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setStoredValueProvider(String value) {
        this.storedValueProvider = value;
    }

    /**
     * Gets the value of the ownerName property.
     *
     * @return possible      object is     {@link String }
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the expiryDate property.
     *
     * @return possible      object is     {@link String }
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the entryMode property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryMode property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryMode().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link EntryModeType }
     *
     * @return the entry mode
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
     * @return possible      object is     {@link IdentificationType }
     */
    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    /**
     * Sets the value of the identificationType property.
     *
     * @param value allowed object is     {@link IdentificationType }
     */
    public void setIdentificationType(IdentificationType value) {
        this.identificationType = value;
    }

}
