
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Stored Value Response messageType. -- Usage: It conveys Information related to the Stored Value transaction processed by the POI System.
 *
 * <p>Java class for StoredValueResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Response" type="{}Response"/>
 *         &lt;element name="SaleData" type="{}SaleData"/>
 *         &lt;element name="POIData" type="{}POIData"/>
 *         &lt;element name="StoredValueResult" type="{}StoredValueResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueResponse", propOrder = {
    "response",
    "saleData",
    "poiData",
    "storedValueResult"
})
public class StoredValueResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;
    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    @XmlElement(name = "POIData", required = true)
    protected POIData poiData;
    @XmlElement(name = "StoredValueResult")
    protected List<StoredValueResult> storedValueResult;

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link Response }
     *
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link Response }
     *
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the saleData property.
     *
     * @return
     *     possible object is
     *     {@link SaleData }
     *
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value
     *     allowed object is
     *     {@link SaleData }
     *
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the poiData property.
     *
     * @return
     *     possible object is
     *     {@link POIData }
     *
     */
    public POIData getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     *
     * @param value
     *     allowed object is
     *     {@link POIData }
     *
     */
    public void setPOIData(POIData value) {
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
     * {@link StoredValueResult }
     *
     *
     */
    public List<StoredValueResult> getStoredValueResult() {
        if (storedValueResult == null) {
            storedValueResult = new ArrayList<StoredValueResult>();
        }
        return this.storedValueResult;
    }

}
