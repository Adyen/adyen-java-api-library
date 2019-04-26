
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Definition: Identification of the stored value account or the stored value card -- Usage: It contains the identifications of the stored value account or the stored value card, and the associated product sold by the Sale System for stored value requests.
 *
 * <p>Java class for StoredValueAccountID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueAccountID">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>TextString">
 *       &lt;attribute name="StoredValueAccount" use="required" type="{}StoredValueAccountType" />
 *       &lt;attribute name="StoredValueProvider" type="{}StoredValueProvider" />
 *       &lt;attribute name="OwnerName" type="{}OwnerName" />
 *       &lt;attribute name="ExpiryDate" type="{}ExpiryDate" />
 *       &lt;attribute name="EntryMode" use="required" type="{}EntryMode" />
 *       &lt;attribute name="Identification" use="required" type="{}IdentificationType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueAccountID", propOrder = {
    "value"
})
public class StoredValueAccountID {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "StoredValueAccount", required = true)
    protected StoredValueAccountType storedValueAccount;
    @XmlAttribute(name = "StoredValueProvider")
    protected String storedValueProvider;
    @XmlAttribute(name = "OwnerName")
    protected String ownerName;
    @XmlAttribute(name = "ExpiryDate")
    protected String expiryDate;
    @XmlAttribute(name = "EntryMode", required = true)
    protected List<EntryModeType> entryMode;
    @XmlAttribute(name = "Identification", required = true)
    protected IdentificationType identification;

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
     * Gets the value of the storedValueAccount property.
     *
     * @return
     *     possible object is
     *     {@link StoredValueAccountType }
     *
     */
    public StoredValueAccountType getStoredValueAccount() {
        return storedValueAccount;
    }

    /**
     * Sets the value of the storedValueAccount property.
     *
     * @param value
     *     allowed object is
     *     {@link StoredValueAccountType }
     *
     */
    public void setStoredValueAccount(StoredValueAccountType value) {
        this.storedValueAccount = value;
    }

    /**
     * Gets the value of the storedValueProvider property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStoredValueProvider() {
        return storedValueProvider;
    }

    /**
     * Sets the value of the storedValueProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStoredValueProvider(String value) {
        this.storedValueProvider = value;
    }

    /**
     * Gets the value of the ownerName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the value of the ownerName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOwnerName(String value) {
        this.ownerName = value;
    }

    /**
     * Gets the value of the expiryDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
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

}
