
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Rebate form to an award;
 * 
 * <p>Java class for RebatesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RebatesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalRebate" type="{}SimpleAmountType" minOccurs="0"/>
 *         &lt;element name="RebateLabel" type="{}RebateLabelType" minOccurs="0"/>
 *         &lt;element name="SaleItemRebate" type="{}SaleItemRebateType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RebatesType", propOrder = {
    "totalRebate",
    "rebateLabel",
    "saleItemRebate"
})
public class RebatesType {

    @XmlElement(name = "TotalRebate")
    protected BigDecimal totalRebate;
    @XmlElement(name = "RebateLabel")
    protected String rebateLabel;
    @XmlElement(name = "SaleItemRebate")
    protected List<SaleItemRebateType> saleItemRebate;

    /**
     * Gets the value of the totalRebate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalRebate() {
        return totalRebate;
    }

    /**
     * Sets the value of the totalRebate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalRebate(BigDecimal value) {
        this.totalRebate = value;
    }

    /**
     * Gets the value of the rebateLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRebateLabel() {
        return rebateLabel;
    }

    /**
     * Sets the value of the rebateLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRebateLabel(String value) {
        this.rebateLabel = value;
    }

    /**
     * Gets the value of the saleItemRebate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleItemRebate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleItemRebate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SaleItemRebateType }
     * 
     * 
     */
    public List<SaleItemRebateType> getSaleItemRebate() {
        if (saleItemRebate == null) {
            saleItemRebate = new ArrayList<SaleItemRebateType>();
        }
        return this.saleItemRebate;
    }

}
