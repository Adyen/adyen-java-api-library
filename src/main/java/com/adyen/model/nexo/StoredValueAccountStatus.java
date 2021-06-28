package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Data related to the result of the stored value card transaction. -- Usage: It contains: - the identification of the stored value accounts or the stored value cards  - the identification of the transaction by the stored value host - the balance of the stored value account if relevant
 *
 * <p>Java class for StoredValueAccountStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueAccountStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StoredValueAccountID" type="{}StoredValueAccountID"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CurrentBalance" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueAccountStatus", propOrder = {
        "storedValueAccountID"
})
public class StoredValueAccountStatus {

    /**
     * The Stored value account id.
     */
    @XmlElement(name = "StoredValueAccountID", required = true)
    @Schema(description = "Identification of the stored value account or the stored value card")
    protected StoredValueAccountID storedValueAccountID;
    /**
     * The Current balance.
     */
    @XmlElement(name = "CurrentBalance")
    @Schema(description = "Balance of an account. --Rule: if relevant and known")
    protected BigDecimal currentBalance;

    /**
     * Gets the value of the storedValueAccountID property.
     *
     * @return possible      object is     {@link StoredValueAccountID }
     */
    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    /**
     * Sets the value of the storedValueAccountID property.
     *
     * @param value allowed object is     {@link StoredValueAccountID }
     */
    public void setStoredValueAccountID(StoredValueAccountID value) {
        this.storedValueAccountID = value;
    }

    /**
     * Gets the value of the currentBalance property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setCurrentBalance(BigDecimal value) {
        this.currentBalance = value;
    }

}
