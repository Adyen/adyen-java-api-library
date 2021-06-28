package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Definition: Information related to an Input request. -- Usage: It conveys the target input logical device, the type of input command, and possible minimum and maximum length of the input. In addition, if the requestor might require to receive an Event Notification if a card is inserted in a card
 *
 * <p>Java class for InputData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DefaultInputString" type="{}DefaultInputString" minOccurs="0"/&gt;
 *         &lt;element name="StringMask" type="{}StringMask" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Device" use="required" type="{}DeviceType" /&gt;
 *       &lt;attribute name="InfoQualify" use="required" type="{}InfoQualifyType" /&gt;
 *       &lt;attribute name="InputCommand" use="required" type="{}InputCommandType" /&gt;
 *       &lt;attribute name="NotifyCardInputFlag" type="{}NotifyCardInputFlag" default="false" /&gt;
 *       &lt;attribute name="MaxInputTime" type="{}MaxInputTime" /&gt;
 *       &lt;attribute name="ImmediateResponseFlag" type="{}ImmediateResponseFlag" default="false" /&gt;
 *       &lt;attribute name="MinLength" type="{}MinLength" /&gt;
 *       &lt;attribute name="MaxLength" type="{}MaxLength" /&gt;
 *       &lt;attribute name="MaxDecimalLength" type="{}MaxDecimalLength" /&gt;
 *       &lt;attribute name="WaitUserValidationFlag" type="{}WaitUserValidationFlag" default="true" /&gt;
 *       &lt;attribute name="FromRightToLeftFlag" type="{}FromRightToLeftFlag" default="false" /&gt;
 *       &lt;attribute name="MaskCharactersFlag" type="{}MaskCharactersFlag" default="false" /&gt;
 *       &lt;attribute name="BeepKeyFlag" type="{}BeepKeyFlag" default="false" /&gt;
 *       &lt;attribute name="GlobalCorrectionFlag" type="{}GlobalCorrectionFlag" default="false" /&gt;
 *       &lt;attribute name="DisableCancelFlag" type="{}DisableCancelFlag" default="false" /&gt;
 *       &lt;attribute name="DisableCorrectFlag" type="{}DisableCorrectFlag" default="false" /&gt;
 *       &lt;attribute name="DisableValidFlag" type="{}DisableValidFlag" default="false" /&gt;
 *       &lt;attribute name="MenuBackFlag" type="{}MenuBackFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputData", propOrder = {
        "defaultInputString",
        "stringMask"
})
public class InputData {

    /**
     * The Default input string.
     */
    @XmlElement(name = "DefaultInputString")
    @Schema(description = "Default string value for an input command. --Rule: Not allowed if InputCommand is not TextString, DigitString or DecimalString")
    protected String defaultInputString;
    /**
     * The String mask.
     */
    @XmlElement(name = "StringMask")
    @Schema(description = "String mask to get information requiring a specific format. --Rule: Not allowed if InputCommand is not TextString, DigitString or DecimalString")
    protected String stringMask;
    /**
     * The Device.
     */
    @XmlElement(name = "Device", required = true)
    @Schema(description = "Logical device located on a Sale Terminal or a POI Terminal, in term of class of information to output (display, print --Rule: CashierInput , CustomerInput, CustomerAssistance")
    protected DeviceType device;
    /**
     * The Info qualify.
     */
    @XmlElement(name = "InfoQualify", required = true)
    @Schema(description = "Qualification of the information to sent to an output logical device, to display or print to the Cashier or the --Rule: Input, CustomerAssistance")
    protected InfoQualifyType infoQualify;
    /**
     * The Input command.
     */
    @XmlElement(name = "InputCommand", required = true)
    @Schema(description = "Type of requested input")
    protected InputCommandType inputCommand;
    /**
     * The Notify card input flag.
     */
    @XmlElement(name = "NotifyCardInputFlag")
    @Schema(description = "Request Notification of card entered in the POI card reader.")
    protected Boolean notifyCardInputFlag;
    /**
     * The Max input time.
     */
    @XmlElement(name = "MaxInputTime")
    @Schema(description = "Maximum input time in seconds --Rule: If time limit for responding")
    protected BigInteger maxInputTime;
    /**
     * The Immediate response flag.
     */
    @XmlElement(name = "ImmediateResponseFlag")
    @Schema(description = "Request Immediate response to the message without waiting for the completion of the command. --Rule: Optional if InputCommand is \"GetAnyKey\".")
    protected Boolean immediateResponseFlag;
    /**
     * The Min length.
     */
    @XmlElement(name = "MinLength")
    @Schema(description = "Minimum input length --Rule: Not allowed if InputCommand is not TextString or DigitString")
    protected BigInteger minLength;
    /**
     * The Max length.
     */
    @XmlElement(name = "MaxLength")
    @Schema(description = "Maximum input length --Rule: Not allowed if InputCommand is not TextString or DigitString")
    protected BigInteger maxLength;
    /**
     * The Max decimal length.
     */
    @XmlElement(name = "MaxDecimalLength")
    @Schema(description = "Maximum input length of the decimal part (without decimal point) --Rule: Not allowed if InputCommand is not DecimalString Greater than MinLength, lower than MaxLength.")
    protected BigInteger maxDecimalLength;
    /**
     * The Wait user validation flag.
     */
    @XmlElement(name = "WaitUserValidationFlag")
    @Schema(description = "Indicates that the user must confirm the entered characters, when the maximum allowed length is reached. --Rule: Optional if MaxLength or MaxDecimalLength present ")
    protected Boolean waitUserValidationFlag;
    /**
     * The From right to left flag.
     */
    @XmlElement(name = "FromRightToLeftFlag")
    @Schema(description = "Indicate if the entered character has to be displayed from the right to the left of the display field. --Rule: Not allowed if InputCommand is not TextString, DigitString or DecimalString")
    protected Boolean fromRightToLeftFlag;
    /**
     * The Mask characters flag.
     */
    @XmlElement(name = "MaskCharactersFlag")
    @Schema(description = "Indicates to mask the characters entered by the user (i.e. replacing in the display of the input, the entered character --Rule: Not allowed if InputCommand is not TextString, DigitString or Password")
    protected Boolean maskCharactersFlag;
    /**
     * The Beep key flag.
     */
    @XmlElement(name = "BeepKeyFlag")
    @Schema(description = "Indicates, when the user press a key, if a beep has to be generated (value True).")
    protected Boolean beepKeyFlag;
    /**
     * The Global correction flag.
     */
    @XmlElement(name = "GlobalCorrectionFlag")
    @Schema(description = "Indicates, when the user press the Correct function key in an input entry, if all the entered characters are removed --Rule: Not allowed if InputCommand is not TextString, DigitString, Password or DecimalString")
    protected Boolean globalCorrectionFlag;
    /**
     * The Disable cancel flag.
     */
    @XmlElement(name = "DisableCancelFlag")
    @Schema(description = "Indicates if the Cancel function key has to be desactived (value True). --Rule: Not allowed if InputCommand is not GetConfirmation, SiteManager, or GetMenuEntry")
    protected Boolean disableCancelFlag;
    /**
     * The Disable correct flag.
     */
    @XmlElement(name = "DisableCorrectFlag")
    @Schema(description = "Indicates if the Correct function key has to be desactived (value True). --Rule: Not allowed if InputCommand is not GetConfirmation, SiteManager, or GetMenuEntry")
    protected Boolean disableCorrectFlag;
    /**
     * The Disable valid flag.
     */
    @XmlElement(name = "DisableValidFlag")
    @Schema(description = "Indicates if the Valid function key has to be desactived (value True). --Rule: Not allowed if InputCommand is not GetConfirmation, SiteManager, or GetMenuEntry")
    protected Boolean disableValidFlag;
    /**
     * The Menu back flag.
     */
    @XmlElement(name = "MenuBackFlag")
    @Schema(description = "If it has the value True, it indicates that the \"Back\" function key (respectively \"Home\" function key) may be used to --Rule: Allowed for the GetMenuEntry value of InputCommand.")
    protected Boolean menuBackFlag;

    /**
     * Gets the value of the defaultInputString property.
     *
     * @return possible      object is     {@link String }
     */
    public String getDefaultInputString() {
        return defaultInputString;
    }

    /**
     * Sets the value of the defaultInputString property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setDefaultInputString(String value) {
        this.defaultInputString = value;
    }

    /**
     * Gets the value of the stringMask property.
     *
     * @return possible      object is     {@link String }
     */
    public String getStringMask() {
        return stringMask;
    }

    /**
     * Sets the value of the stringMask property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setStringMask(String value) {
        this.stringMask = value;
    }

    /**
     * Gets the value of the device property.
     *
     * @return possible      object is     {@link DeviceType }
     */
    public DeviceType getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value allowed object is     {@link DeviceType }
     */
    public void setDevice(DeviceType value) {
        this.device = value;
    }

    /**
     * Gets the value of the infoQualify property.
     *
     * @return possible      object is     {@link InfoQualifyType }
     */
    public InfoQualifyType getInfoQualify() {
        return infoQualify;
    }

    /**
     * Sets the value of the infoQualify property.
     *
     * @param value allowed object is     {@link InfoQualifyType }
     */
    public void setInfoQualify(InfoQualifyType value) {
        this.infoQualify = value;
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

    /**
     * Gets the value of the notifyCardInputFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setNotifyCardInputFlag(Boolean value) {
        this.notifyCardInputFlag = value;
    }

    /**
     * Gets the value of the maxInputTime property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxInputTime() {
        return maxInputTime;
    }

    /**
     * Sets the value of the maxInputTime property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxInputTime(BigInteger value) {
        this.maxInputTime = value;
    }

    /**
     * Gets the value of the immediateResponseFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setImmediateResponseFlag(Boolean value) {
        this.immediateResponseFlag = value;
    }

    /**
     * Gets the value of the minLength property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMinLength(BigInteger value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxLength(BigInteger value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the maxDecimalLength property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getMaxDecimalLength() {
        return maxDecimalLength;
    }

    /**
     * Sets the value of the maxDecimalLength property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setMaxDecimalLength(BigInteger value) {
        this.maxDecimalLength = value;
    }

    /**
     * Gets the value of the waitUserValidationFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setWaitUserValidationFlag(Boolean value) {
        this.waitUserValidationFlag = value;
    }

    /**
     * Gets the value of the fromRightToLeftFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setFromRightToLeftFlag(Boolean value) {
        this.fromRightToLeftFlag = value;
    }

    /**
     * Gets the value of the maskCharactersFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setMaskCharactersFlag(Boolean value) {
        this.maskCharactersFlag = value;
    }

    /**
     * Gets the value of the beepKeyFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setBeepKeyFlag(Boolean value) {
        this.beepKeyFlag = value;
    }

    /**
     * Gets the value of the globalCorrectionFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setGlobalCorrectionFlag(Boolean value) {
        this.globalCorrectionFlag = value;
    }

    /**
     * Gets the value of the disableCancelFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setDisableCancelFlag(Boolean value) {
        this.disableCancelFlag = value;
    }

    /**
     * Gets the value of the disableCorrectFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setDisableCorrectFlag(Boolean value) {
        this.disableCorrectFlag = value;
    }

    /**
     * Gets the value of the disableValidFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setDisableValidFlag(Boolean value) {
        this.disableValidFlag = value;
    }

    /**
     * Gets the value of the menuBackFlag property.
     *
     * @return possible      object is     {@link Boolean }
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
     * @param value allowed object is     {@link Boolean }
     */
    public void setMenuBackFlag(Boolean value) {
        this.menuBackFlag = value;
    }

}
