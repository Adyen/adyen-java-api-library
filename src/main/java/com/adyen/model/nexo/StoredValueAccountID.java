package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
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
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="StoredValueAccountType" use="required" type="{}StoredValueAccountType" /&gt;
 *       &lt;attribute name="StoredValueProvider" type="{}StoredValueProvider" /&gt;
 *       &lt;attribute name="OwnerName" type="{}OwnerName" /&gt;
 *       &lt;attribute name="ExpiryDate" type="{}ExpiryDate" /&gt;
 *       &lt;attribute name="EntryMode" use="required" type="{}EntryMode" /&gt;
 *       &lt;attribute name="IdentificationType" use="required" type="{}IdentificationType" /&gt;
 *       &lt;attribute name="StoredValueID" use="required" type="{}StoredValueID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueAccountID")
public class StoredValueAccountID {

    @XmlAttribute(name = "StoredValueAccountType", required = true)
    protected StoredValueAccountType storedValueAccountType;
    @XmlAttribute(name = "StoredValueProvider")
    protected String storedValueProvider;
    @XmlAttribute(name = "OwnerName")
    protected String ownerName;
    @XmlAttribute(name = "ExpiryDate")
    protected String expiryDate;
    @XmlAttribute(name = "EntryMode", required = true)
    protected List<EntryModeType> entryMode;
    @XmlAttribute(name = "IdentificationType", required = true)
    protected IdentificationType identificationType;
    @XmlAttribute(name = "StoredValueID", required = true)
    protected String storedValueID;

    /**
     * Gets the value of the storedValueAccountType property.
     *
     * @return possible object is
     * {@link StoredValueAccountType }
     */
    public StoredValueAccountType getStoredValueAccountType() {
        return storedValueAccountType;
    }

    /**
     * Sets the value of the storedValueAccountType property.
     *
     * @param value allowed object is
     *              {@link StoredValueAccountType }
     */
    public void setStoredValueAccountType(StoredValueAccountType value) {
        this.storedValueAccountType = value;
    }

    /**
     * Gets the value of the storedValueProvider property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    /**
     * Sets the value of the storedValueProvider property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStoredValueProvider(String value) {
        this.storedValueProvider = value;
    }

    /**
     * Gets the value of the ownerName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the expiryDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
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
     * Gets the value of the storedValueID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStoredValueID() {
        return storedValueID;
    }

    /**
     * Sets the value of the storedValueID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStoredValueID(String value) {
        this.storedValueID = value;
    }

}
