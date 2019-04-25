
package com.adyen.model.nexo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data entered by the user, related to the input command. -- Usage: Choice of a data which contains data entered by the user on the requested device, depending on the requested InputCommand:GetConfirmation: the input is in ConfirmedFlag.GetAnyKey: there is no input.GetFunctionKey: the input is in
 * 
 * <p>Java class for InputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfirmedFlag" type="{}ConfirmedFlagType" minOccurs="0"/>
 *         &lt;element name="FunctionKey" type="{}FunctionKeyType" minOccurs="0"/>
 *         &lt;element name="TextInput" type="{}TextInputType" minOccurs="0"/>
 *         &lt;element name="DigitInput" type="{}DigitInputType" minOccurs="0"/>
 *         &lt;element name="Password" type="{}ContentInformationType" minOccurs="0"/>
 *         &lt;element name="MenuEntryNumber" type="{}MenuEntryNumberType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="InputCommand" use="required" type="{}InputCommandTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputType", propOrder = {
    "confirmedFlag",
    "functionKey",
    "textInput",
    "digitInput",
    "password",
    "menuEntryNumber"
})
public class InputType {

    @XmlElement(name = "ConfirmedFlag")
    protected Boolean confirmedFlag;
    @XmlElement(name = "FunctionKey")
    protected String functionKey;
    @XmlElement(name = "TextInput")
    protected String textInput;
    @XmlElement(name = "DigitInput")
    protected String digitInput;
    @XmlElement(name = "Password")
    protected ContentInformationType password;
    @XmlElement(name = "MenuEntryNumber")
    protected BigInteger menuEntryNumber;
    @XmlAttribute(name = "InputCommand", required = true)
    protected String inputCommand;

    /**
     * Gets the value of the confirmedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfirmedFlag() {
        return confirmedFlag;
    }

    /**
     * Sets the value of the confirmedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConfirmedFlag(Boolean value) {
        this.confirmedFlag = value;
    }

    /**
     * Gets the value of the functionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionKey() {
        return functionKey;
    }

    /**
     * Sets the value of the functionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionKey(String value) {
        this.functionKey = value;
    }

    /**
     * Gets the value of the textInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextInput() {
        return textInput;
    }

    /**
     * Sets the value of the textInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextInput(String value) {
        this.textInput = value;
    }

    /**
     * Gets the value of the digitInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigitInput() {
        return digitInput;
    }

    /**
     * Sets the value of the digitInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigitInput(String value) {
        this.digitInput = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link ContentInformationType }
     *     
     */
    public ContentInformationType getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentInformationType }
     *     
     */
    public void setPassword(ContentInformationType value) {
        this.password = value;
    }

    /**
     * Gets the value of the menuEntryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMenuEntryNumber() {
        return menuEntryNumber;
    }

    /**
     * Sets the value of the menuEntryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMenuEntryNumber(BigInteger value) {
        this.menuEntryNumber = value;
    }

    /**
     * Gets the value of the inputCommand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputCommand() {
        return inputCommand;
    }

    /**
     * Sets the value of the inputCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputCommand(String value) {
        this.inputCommand = value;
    }

}
