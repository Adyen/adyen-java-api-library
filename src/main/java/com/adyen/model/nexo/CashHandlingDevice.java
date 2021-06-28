package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Status of cash handling device. -- Usage: Indicate the status and the remaining coins and bill in a cash handling device.
 *
 * <p>Java class for CashHandlingDevice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CashHandlingDevice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CoinsOrBills" type="{}CoinsOrBills" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CashHandlingOKFlag" use="required" type="{}CashHandlingOKFlag" /&gt;
 *       &lt;attribute name="Currency" use="required" type="{}ISOCurrency3A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashHandlingDevice", propOrder = {
        "coinsOrBills"
})
public class CashHandlingDevice {

    /**
     * The Coins or bills.
     */
    @XmlElement(name = "CoinsOrBills", required = true)
    @Schema(description = "Number of coins or bills of a given value.")
    protected List<CoinsOrBills> coinsOrBills;
    /**
     * The Cash handling ok flag.
     */
    @XmlElement(name = "CashHandlingOKFlag", required = true)
    @Schema(description = "Indicates if the cash handling device is working and usable.")
    protected boolean cashHandlingOKFlag;
    /**
     * The Currency.
     */
    @XmlElement(name = "Currency", required = true)
    @Schema(description = "Currency of a monetary amount.")
    protected String currency;

    /**
     * Gets the value of the coinsOrBills property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coinsOrBills property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoinsOrBills().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoinsOrBills }
     *
     * @return the coins or bills
     */
    public List<CoinsOrBills> getCoinsOrBills() {
        if (coinsOrBills == null) {
            coinsOrBills = new ArrayList<>();
        }
        return this.coinsOrBills;
    }

    /**
     * Gets the value of the cashHandlingOKFlag property.
     *
     * @return the boolean
     */
    public boolean isCashHandlingOKFlag() {
        return cashHandlingOKFlag;
    }

    /**
     * Sets the value of the cashHandlingOKFlag property.
     *
     * @param value the value
     */
    public void setCashHandlingOKFlag(boolean value) {
        this.cashHandlingOKFlag = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
