package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Certificate issuer name (see X.501-88) -- Reference: RFC 3880: Internet X.509 Public Key Infrastructure Certificate and Certificate -- Usage: The Issuer field identifies the entity that has signed and issued the certificate.  It contains hierarchical name composed of attributes, such as country, organization, organizational-unit, common name.
 *
 * <p>Java class for Issuer complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Issuer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RelativeDistinguishedName" type="{}RelativeDistinguishedName" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Issuer", propOrder = {
        "relativeDistinguishedName"
})
public class Issuer {

    /**
     * The Relative distinguished name.
     */
    @XmlElement(name = "RelativeDistinguishedName", required = true)
    protected List<RelativeDistinguishedName> relativeDistinguishedName;

    /**
     * Gets the value of the relativeDistinguishedName property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relativeDistinguishedName property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelativeDistinguishedName().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelativeDistinguishedName }
     *
     * @return the relative distinguished name
     */
    public List<RelativeDistinguishedName> getRelativeDistinguishedName() {
        if (relativeDistinguishedName == null) {
            relativeDistinguishedName = new ArrayList<>();
        }
        return this.relativeDistinguishedName;
    }

}
