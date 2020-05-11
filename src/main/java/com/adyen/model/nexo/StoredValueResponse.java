package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Stored Value Response messageType. -- Usage: It conveys Information related to the Stored Value transaction processed by the POI System.
 *
 * <p>Java class for StoredValueResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="SaleData" type="{}SaleData"/&gt;
 *         &lt;element name="POIData" type="{}POIData"/&gt;
 *         &lt;element name="StoredValueResult" type="{}StoredValueResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueResponse", propOrder = {
        "response",
        "saleData",
        "poiData",
        "storedValueResult"
})
public class StoredValueResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    protected Response response;
    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    /**
     * The Poi data.
     */
    @XmlElement(name = "POIData", required = true)
    protected POIData poiData;
    /**
     * The Stored value result.
     */
    @XmlElement(name = "StoredValueResult")
    protected List<StoredValueResult> storedValueResult;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the saleData property.
     *
     * @return possible      object is     {@link SaleData }
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value allowed object is     {@link SaleData }
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the poiData property.
     *
     * @return possible      object is     {@link POIData }
     */
    public POIData getPOIData() {
        return poiData;
    }

    /**
     * Sets the value of the poiData property.
     *
     * @param value allowed object is     {@link POIData }
     */
    public void setPOIData(POIData value) {
        this.poiData = value;
    }

    /**
     * Gets the value of the storedValueResult property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storedValueResult property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStoredValueResult().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link StoredValueResult }
     *
     * @return the stored value result
     */
    public List<StoredValueResult> getStoredValueResult() {
        if (storedValueResult == null) {
            storedValueResult = new ArrayList<>();
        }
        return this.storedValueResult;
    }

}
