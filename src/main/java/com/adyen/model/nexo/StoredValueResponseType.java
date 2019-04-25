
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Stored Value Response message. -- Usage: It conveys Information related to the Stored Value transaction processed by the POI System.
 * 
 * <p>Java class for StoredValueResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoredValueResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}ResponseType"/>
 *         &lt;element name="SaleData" type="{}SaleDataType"/>
 *         &lt;element name="POIData" type="{}POIDataType"/>
 *         &lt;element name="StoredValueResult" type="{}StoredValueResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueResponseType", propOrder = {
    "response",
    "saleData",
    "poiData",
    "storedValueResult"
})
public class StoredValueResponseType {

    @XmlElement(name = "Response", required = true)
    protected ResponseType response;
    @XmlElement(name = "SaleData", required = true)
    protected SaleDataType saleData;
    @XmlElement(name = "POIData", required = true)
    protected POIDataType poiData;
    @XmlElement(name = "StoredValueResult")
    protected List<StoredValueResultType> storedValueResult;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the saleData property.
     * 
     * @return
     *     possible object is
     *     {@link SaleDataType }
     *     
     */
    public SaleDataType getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleDataType }
     *     
     */
    public void setSaleData(SaleDataType value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the poiData property.
     * 
     * @return
     *     possible object is
     *     {@link POIDataType }
     *     
     */
    public POIDataType getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     * 
     * @param value
     *     allowed object is
     *     {@link POIDataType }
     *     
     */
    public void setPOIData(POIDataType value) {
        this.poiData = value;
    }

    /**
     * Gets the value of the storedValueResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storedValueResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStoredValueResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StoredValueResultType }
     * 
     * 
     */
    public List<StoredValueResultType> getStoredValueResult() {
        if (storedValueResult == null) {
            storedValueResult = new ArrayList<StoredValueResultType>();
        }
        return this.storedValueResult;
    }

}
