
package com.adyen.model.nexo;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to an Input request. -- Usage: It conveys the target input logical device, the type of input command, and possible minimum and maximum length of the input. In addition, if the requestor might require to receive an Event Notification if a card is inserted in a card
 * 
 * <p>Java class for InputDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DefaultInputString" type="{}DefaultInputStringType" minOccurs="0"/>
 *         &lt;element name="StringMask" type="{}StringMaskType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Device" use="required" type="{}DeviceTypeCode" />
 *       &lt;attribute name="InfoQualify" use="required" type="{}InfoQualifyTypeCode" />
 *       &lt;attribute name="InputCommand" use="required" type="{}InputCommandTypeCode" />
 *       &lt;attribute name="NotifyCardInputFlag" type="{}NotifyCardInputFlagType" default="false" />
 *       &lt;attribute name="MaxInputTime" type="{}MaxInputTimeType" />
 *       &lt;attribute name="ImmediateResponseFlag" type="{}ImmediateResponseFlagType" default="false" />
 *       &lt;attribute name="MinLength" type="{}MinLengthType" />
 *       &lt;attribute name="MaxLength" type="{}MaxLengthType" />
 *       &lt;attribute name="MaxDecimalLength" type="{}MaxDecimalLengthType" />
 *       &lt;attribute name="WaitUserValidationFlag" type="{}WaitUserValidationFlagType" default="true" />
 *       &lt;attribute name="FromRightToLeftFlag" type="{}FromRightToLeftFlagType" default="false" />
 *       &lt;attribute name="MaskCharactersFlag" type="{}MaskCharactersFlagType" default="false" />
 *       &lt;attribute name="BeepKeyFlag" type="{}BeepKeyFlagType" default="false" />
 *       &lt;attribute name="GlobalCorrectionFlag" type="{}GlobalCorrectionFlagType" default="false" />
 *       &lt;attribute name="DisableCancelFlag" type="{}DisableCancelFlagType" default="false" />
 *       &lt;attribute name="DisableCorrectFlag" type="{}DisableCorrectFlagType" default="false" />
 *       &lt;attribute name="DisableValidFlag" type="{}DisableValidFlagType" default="false" />
 *       &lt;attribute name="MenuBackFlag" type="{}MenuBackFlagType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputDataType", propOrder = {
    "defaultInputString",
    "stringMask"
})
public class InputDataType {

    @XmlElement(name = "DefaultInputString")
    protected String defaultInputString;
    @XmlElement(name = "StringMask")
    protected String stringMask;
    @XmlAttribute(name = "Device", required = true)
    protected String device;
    @XmlAttribute(name = "InfoQualify", required = true)
    protected String infoQualify;
    @XmlAttribute(name = "InputCommand", required = true)
    protected String inputCommand;
    @XmlAttribute(name = "NotifyCardInputFlag")
    protected Boolean notifyCardInputFlag;
    @XmlAttribute(name = "MaxInputTime")
    protected BigInteger maxInputTime;
    @XmlAttribute(name = "ImmediateResponseFlag")
    protected Boolean immediateResponseFlag;
    @XmlAttribute(name = "MinLength")
    protected BigInteger minLength;
    @XmlAttribute(name = "MaxLength")
    protected BigInteger maxLength;
    @XmlAttribute(name = "MaxDecimalLength")
    protected BigInteger maxDecimalLength;
    @XmlAttribute(name = "WaitUserValidationFlag")
    protected Boolean waitUserValidationFlag;
    @XmlAttribute(name = "FromRightToLeftFlag")
    protected Boolean fromRightToLeftFlag;
    @XmlAttribute(name = "MaskCharactersFlag")
    protected Boolean maskCharactersFlag;
    @XmlAttribute(name = "BeepKeyFlag")
    protected Boolean beepKeyFlag;
    @XmlAttribute(name = "GlobalCorrectionFlag")
    protected Boolean globalCorrectionFlag;
    @XmlAttribute(name = "DisableCancelFlag")
    protected Boolean disableCancelFlag;
    @XmlAttribute(name = "DisableCorrectFlag")
    protected Boolean disableCorrectFlag;
    @XmlAttribute(name = "DisableValidFlag")
    protected Boolean disableValidFlag;
    @XmlAttribute(name = "MenuBackFlag")
    protected Boolean menuBackFlag;

    /**
     * Gets the value of the defaultInputString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultInputString() {
        return defaultInputString;
    }

    /**
     * Sets the value of the defaultInputString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultInputString(String value) {
        this.defaultInputString = value;
    }

    /**
     * Gets the value of the stringMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringMask() {
        return stringMask;
    }

    /**
     * Sets the value of the stringMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringMask(String value) {
        this.stringMask = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        this.device = value;
    }

    /**
     * Gets the value of the infoQualify property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoQualify() {
        return infoQualify;
    }

    /**
     * Sets the value of the infoQualify property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoQualify(String value) {
        this.infoQualify = value;
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

    /**
     * Gets the value of the notifyCardInputFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isNotifyCardInputFlag() {
        if (notifyCardInputFlag == null) {
            return false;
        } else {
            return notifyCardInputFlag;
        }
    }

    /**
     * Sets the value of the notifyCardInputFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyCardInputFlag(Boolean value) {
        this.notifyCardInputFlag = value;
    }

    /**
     * Gets the value of the maxInputTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxInputTime() {
        return maxInputTime;
    }

    /**
     * Sets the value of the maxInputTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxInputTime(BigInteger value) {
        this.maxInputTime = value;
    }

    /**
     * Gets the value of the immediateResponseFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isImmediateResponseFlag() {
        if (immediateResponseFlag == null) {
            return false;
        } else {
            return immediateResponseFlag;
        }
    }

    /**
     * Sets the value of the immediateResponseFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setImmediateResponseFlag(Boolean value) {
        this.immediateResponseFlag = value;
    }

    /**
     * Gets the value of the minLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the maxDecimalLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxDecimalLength() {
        return maxDecimalLength;
    }

    /**
     * Sets the value of the maxDecimalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxDecimalLength(BigInteger value) {
        this.maxDecimalLength = value;
    }

    /**
     * Gets the value of the waitUserValidationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isWaitUserValidationFlag() {
        if (waitUserValidationFlag == null) {
            return true;
        } else {
            return waitUserValidationFlag;
        }
    }

    /**
     * Sets the value of the waitUserValidationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaitUserValidationFlag(Boolean value) {
        this.waitUserValidationFlag = value;
    }

    /**
     * Gets the value of the fromRightToLeftFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFromRightToLeftFlag() {
        if (fromRightToLeftFlag == null) {
            return false;
        } else {
            return fromRightToLeftFlag;
        }
    }

    /**
     * Sets the value of the fromRightToLeftFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFromRightToLeftFlag(Boolean value) {
        this.fromRightToLeftFlag = value;
    }

    /**
     * Gets the value of the maskCharactersFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMaskCharactersFlag() {
        if (maskCharactersFlag == null) {
            return false;
        } else {
            return maskCharactersFlag;
        }
    }

    /**
     * Sets the value of the maskCharactersFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMaskCharactersFlag(Boolean value) {
        this.maskCharactersFlag = value;
    }

    /**
     * Gets the value of the beepKeyFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBeepKeyFlag() {
        if (beepKeyFlag == null) {
            return false;
        } else {
            return beepKeyFlag;
        }
    }

    /**
     * Sets the value of the beepKeyFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBeepKeyFlag(Boolean value) {
        this.beepKeyFlag = value;
    }

    /**
     * Gets the value of the globalCorrectionFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isGlobalCorrectionFlag() {
        if (globalCorrectionFlag == null) {
            return false;
        } else {
            return globalCorrectionFlag;
        }
    }

    /**
     * Sets the value of the globalCorrectionFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGlobalCorrectionFlag(Boolean value) {
        this.globalCorrectionFlag = value;
    }

    /**
     * Gets the value of the disableCancelFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDisableCancelFlag() {
        if (disableCancelFlag == null) {
            return false;
        } else {
            return disableCancelFlag;
        }
    }

    /**
     * Sets the value of the disableCancelFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableCancelFlag(Boolean value) {
        this.disableCancelFlag = value;
    }

    /**
     * Gets the value of the disableCorrectFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDisableCorrectFlag() {
        if (disableCorrectFlag == null) {
            return false;
        } else {
            return disableCorrectFlag;
        }
    }

    /**
     * Sets the value of the disableCorrectFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableCorrectFlag(Boolean value) {
        this.disableCorrectFlag = value;
    }

    /**
     * Gets the value of the disableValidFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDisableValidFlag() {
        if (disableValidFlag == null) {
            return false;
        } else {
            return disableValidFlag;
        }
    }

    /**
     * Sets the value of the disableValidFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableValidFlag(Boolean value) {
        this.disableValidFlag = value;
    }

    /**
     * Gets the value of the menuBackFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMenuBackFlag() {
        if (menuBackFlag == null) {
            return false;
        } else {
            return menuBackFlag;
        }
    }

    /**
     * Sets the value of the menuBackFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMenuBackFlag(Boolean value) {
        this.menuBackFlag = value;
    }

}
