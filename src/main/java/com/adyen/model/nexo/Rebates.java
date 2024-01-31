package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Rebate form to an award;
 *
 * <p>Java class for Rebates complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Rebates"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TotalRebate" type="{}SimpleAmountType" minOccurs="0"/&gt;
 *         &lt;element name="RebateLabel" type="{}RebateLabel" minOccurs="0"/&gt;
 *         &lt;element name="SaleItemRebate" type="{}SaleItemRebate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rebates", propOrder = {
        "totalRebate",
        "rebateLabel",
        "saleItemRebate"
})
public class Rebates {

    /**
     * The Total rebate.
     */
    @XmlElement(name = "TotalRebate")
    @Schema(description = "The global awarded amount that is not attached to an item. --Rule: If rebate on the total amount for this loyalty program")
    protected BigDecimal totalRebate;
    /**
     * The Rebate label.
     */
    @XmlElement(name = "RebateLabel")
    @Schema(description = "Short text to qualify a rebate on an line item. --Rule: If provided by the Acquirer")
    protected String rebateLabel;
    /**
     * The Sale item rebate.
     */
    @XmlElement(name = "SaleItemRebate")
    @Schema(description = "The awarded amount that is attached to an item as a rebate. --Rule: only items with rebate (identified by ItemID)")
    protected List<SaleItemRebate> saleItemRebate;

    /**
     * Gets the value of the totalRebate property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getTotalRebate() {
        return totalRebate;
    }

    /**
     * Sets the value of the totalRebate property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setTotalRebate(BigDecimal value) {
        this.totalRebate = value;
    }

    /**
     * Gets the value of the rebateLabel property.
     *
     * @return possible      object is     {@link String }
     */
    public String getRebateLabel() {
        return rebateLabel;
    }

    /**
     * Sets the value of the rebateLabel property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setRebateLabel(String value) {
        this.rebateLabel = value;
    }

    /**
     * Gets the value of the saleItemRebate property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleItemRebate property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleItemRebate().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SaleItemRebate }
     *
     * @return the sale item rebate
     */
    public List<SaleItemRebate> getSaleItemRebate() {
        if (saleItemRebate == null) {
            saleItemRebate = new ArrayList<>();
        }
        return this.saleItemRebate;
    }

}
