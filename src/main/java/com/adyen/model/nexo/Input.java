package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data entered by the user, related to the input command. -- Usage: Choice of a data which contains data entered by the user on the requested device, depending on the requested InputCommand:GetConfirmation: the input is in ConfirmedFlag.GetAnyKey: there is no input.GetFunctionKey: the input is in
 *
 * <p>Java class for Input complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConfirmedFlag" type="{}ConfirmedFlag" minOccurs="0"/&gt;
 *         &lt;element name="FunctionKey" type="{}FunctionKey" minOccurs="0"/&gt;
 *         &lt;element name="TextInput" type="{}TextInput" minOccurs="0"/&gt;
 *         &lt;element name="DigitInput" type="{}DigitInput" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{}ContentInformation" minOccurs="0"/&gt;
 *         &lt;element name="MenuEntryNumber" type="{}MenuEntryNumber" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="InputCommand" use="required" type="{}InputCommandType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Input", propOrder = {
        "confirmedFlag",
        "functionKey",
        "textInput",
        "digitInput",
        "password",
        "menuEntryNumber"
})
public class Input {

    /**
     * The Confirmed flag.
     */
    @XmlElement(name = "ConfirmedFlag")
    protected Boolean confirmedFlag;
    /**
     * The Function key.
     */
    @XmlElement(name = "FunctionKey")
    protected String functionKey;
    /**
     * The Text input.
     */
    @XmlElement(name = "TextInput")
    protected String textInput;
    /**
     * The Digit input.
     */
    @XmlElement(name = "DigitInput")
    protected String digitInput;
    /**
     * The Password.
     */
    @XmlElement(name = "Password")
    protected ContentInformation password;
    /**
     * The Menu entry number.
     */
    @XmlElement(name = "MenuEntryNumber")
    protected Integer[] menuEntryNumber;
    /**
     * The Input command.
     */
    @XmlAttribute(name = "InputCommand", required = true)
    protected InputCommandType inputCommand;

    /**
     * Gets the value of the confirmedFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isConfirmedFlag() {
        return confirmedFlag;
    }

    /**
     * Sets the value of the confirmedFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setConfirmedFlag(Boolean value) {
        this.confirmedFlag = value;
    }

    /**
     * Gets the value of the functionKey property.
     *
     * @return possible      object is     {@link String }
     */
    public String getFunctionKey() {
        return functionKey;
    }

    /**
     * Sets the value of the functionKey property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setFunctionKey(String value) {
        this.functionKey = value;
    }

    /**
     * Gets the value of the textInput property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTextInput() {
        return textInput;
    }

    /**
     * Sets the value of the textInput property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTextInput(String value) {
        this.textInput = value;
    }

    /**
     * Gets the value of the digitInput property.
     *
     * @return possible      object is     {@link String }
     */
    public String getDigitInput() {
        return digitInput;
    }

    /**
     * Sets the value of the digitInput property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setDigitInput(String value) {
        this.digitInput = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible      object is     {@link ContentInformation }
     */
    public ContentInformation getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is     {@link ContentInformation }
     */
    public void setPassword(ContentInformation value) {
        this.password = value;
    }

    /**
     * Gets the value of the menuEntryNumber property.
     *
     * @return possible      object is     {@link Integer[] }
     */
    public Integer[] getMenuEntryNumber() {
        return menuEntryNumber;
    }

    /**
     * Sets the value of the menuEntryNumber property.
     *
     * @param value allowed object is     {@link Integer[] }
     */
    public void setMenuEntryNumber(Integer[] value) {
        this.menuEntryNumber = value;
    }

    /**
     * Gets the value of the inputCommand property.
     *
     * @return possible      object is     {@link InputCommandType }
     */
    public InputCommandType getInputCommand() {
        return inputCommand;
    }

    /**
     * Sets the value of the inputCommand property.
     *
     * @param value allowed object is     {@link InputCommandType }
     */
    public void setInputCommand(InputCommandType value) {
        this.inputCommand = value;
    }

}
