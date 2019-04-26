
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Status of cash handling device. -- Usage: Indicate the status and the remaining coins and bill in a cash handling device.
 *
 * <p>Java class for CashHandlingDevice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CashHandlingDevice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CoinsOrBills" type="{}CoinsOrBills" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CashHandlingOKFlag" use="required" type="{}CashHandlingOKFlag" />
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashHandlingDevice", propOrder = {
    "coinsOrBills"
})
public class CashHandlingDevice {

    @XmlElement(name = "CoinsOrBills", required = true)
    protected List<CoinsOrBills> coinsOrBills;
    @XmlAttribute(name = "CashHandlingOKFlag", required = true)
    protected boolean cashHandlingOKFlag;
    @XmlAttribute(name = "Currency", required = true)
    protected String currency;

    /**
     * Gets the value of the coinsOrBills property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coinsOrBills property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoinsOrBills().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoinsOrBills }
     *
     *
     */
    public List<CoinsOrBills> getCoinsOrBills() {
        if (coinsOrBills == null) {
            coinsOrBills = new ArrayList<CoinsOrBills>();
        }
        return this.coinsOrBills;
    }

    /**
     * Gets the value of the cashHandlingOKFlag property.
     *
     */
    public boolean isCashHandlingOKFlag() {
        return cashHandlingOKFlag;
    }

    /**
     * Sets the value of the cashHandlingOKFlag property.
     *
     */
    public void setCashHandlingOKFlag(boolean value) {
        this.cashHandlingOKFlag = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
