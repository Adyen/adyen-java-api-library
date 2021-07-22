package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for InputCommandType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="InputCommandType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GetAnyKey"/&gt;
 *     &lt;enumeration value="GetConfirmation"/&gt;
 *     &lt;enumeration value="SiteManager"/&gt;
 *     &lt;enumeration value="TextString"/&gt;
 *     &lt;enumeration value="DigitString"/&gt;
 *     &lt;enumeration value="DecimalString"/&gt;
 *     &lt;enumeration value="GetFunctionKey"/&gt;
 *     &lt;enumeration value="GetMenuEntry"/&gt;
 *     &lt;enumeration value="Password"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "InputCommandType")
@XmlEnum
public enum InputCommandType {


    /**
     * Wait for a key pressed on the Terminal, to be able to read the messageType displayed on the Terminal.
     */
    @XmlEnumValue("GetAnyKey")
    @Schema(description = "Wait for a key pressed on the Terminal, to be able to read the message displayed on the Terminal.")
    GET_ANY_KEY("GetAnyKey"),

    /**
     * Wait for a confirmation Yes (Y) or No (N) on the Sale Terminal. Wait for a confirmation (Valid or Cancel button) on the POI Terminal. The result of the command
     */
    @XmlEnumValue("GetConfirmation")
    @Schema(description = "Wait for a confirmation Yes (Y) or No (N) on the Sale Terminal. Wait for a confirmation (Valid or Cancel button) on the POI Terminal. The result of the command")
    GET_CONFIRMATION("GetConfirmation"),

    /**
     * Wait for a confirmation Yes (Y) or No (N) of the Site Manager on the Sale Terminal.
     */
    @XmlEnumValue("SiteManager")
    @Schema(description = "Wait for a confirmation Yes (Y) or No (N) of the Site Manager on the Sale Terminal.")
    SITE_MANAGER("SiteManager"),

    /**
     * Wait for a string of alphanumeric characters, the length range could be specified.
     */
    @XmlEnumValue("TextString")
    @Schema(description = "Wait for a string of alphanumeric characters, the length range could be specified.")
    TEXT_STRING("TextString"),

    /**
     * Wait for a string of digit characters, the length range could be specified.
     */
    @XmlEnumValue("DigitString")
    @Schema(description = "Wait for a string of digit characters, the length range could be specified.")
    DIGIT_STRING("DigitString"),

    /**
     * Wait for a string of digit characters with a decimal point, the length range could be specified.
     */
    @XmlEnumValue("DecimalString")
    @Schema(description = "Wait for a string of digit characters with a decimal point, the length range could be specified.")
    DECIMAL_STRING("DecimalString"),

    /**
     * Wait for a function key pressed on the Terminal:  From POI, Valid, Clear, Correct, Generic Function key number. From Sale, Generic Function key.
     */
    @XmlEnumValue("GetFunctionKey")
    @Schema(description = "Wait for a function key pressed on the Terminal:  From POI, Valid, Clear, Correct, Generic Function key number. From Sale, Generic Function key.")
    GET_FUNCTION_KEY("GetFunctionKey"),

    /**
     * To choose an entry among a list of entrys (all of them are not necessary selectable). The OutputFormat has to be MenuEntry.
     */
    @XmlEnumValue("GetMenuEntry")
    @Schema(description = "To choose an entry among a list of entrys (all of them are not necessary selectable). The OutputFormat has to be MenuEntry.")
    GET_MENU_ENTRY("GetMenuEntry"),

    /**
     * Request to enter a password with masked characters while typing the password.
     */
    @XmlEnumValue("Password")
    @Schema(description = "Request to enter a password with masked characters while typing the password.")
    PASSWORD("Password");
    private final String value;

    InputCommandType(String v) {
        value = v;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value input command type.
     *
     * @param v the v
     * @return the input command type
     */
    public static InputCommandType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
