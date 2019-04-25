
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InputCommandEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InputCommandEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GetAnyKey"/>
 *     &lt;enumeration value="GetConfirmation"/>
 *     &lt;enumeration value="SiteManager"/>
 *     &lt;enumeration value="TextString"/>
 *     &lt;enumeration value="DigitString"/>
 *     &lt;enumeration value="DecimalString"/>
 *     &lt;enumeration value="GetFunctionKey"/>
 *     &lt;enumeration value="GetMenuEntry"/>
 *     &lt;enumeration value="Password"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InputCommandEnumeration")
@XmlEnum
public enum InputCommandEnumeration {


    /**
     * Wait for a key pressed on the Terminal, to be able to read the message displayed on the Terminal.
     * 
     */
    @XmlEnumValue("GetAnyKey")
    GET_ANY_KEY("GetAnyKey"),

    /**
     * Wait for a confirmation Yes (Y) or No (N) on the Sale Terminal. Wait for a confirmation (Valid or Cancel button) on the POI Terminal. The result of the command
     * 
     */
    @XmlEnumValue("GetConfirmation")
    GET_CONFIRMATION("GetConfirmation"),

    /**
     * Wait for a confirmation Yes (Y) or No (N) of the Site Manager on the Sale Terminal.
     * 
     */
    @XmlEnumValue("SiteManager")
    SITE_MANAGER("SiteManager"),

    /**
     * Wait for a string of alphanumeric characters, the length range could be specified.
     * 
     */
    @XmlEnumValue("TextString")
    TEXT_STRING("TextString"),

    /**
     * Wait for a string of digit characters, the length range could be specified.
     * 
     */
    @XmlEnumValue("DigitString")
    DIGIT_STRING("DigitString"),

    /**
     * Wait for a string of digit characters with a decimal point, the length range could be specified.
     * 
     */
    @XmlEnumValue("DecimalString")
    DECIMAL_STRING("DecimalString"),

    /**
     * Wait for a function key pressed on the Terminal:  From POI, Valid, Clear, Correct, Generic Function key number. From Sale, Generic Function key.
     * 
     */
    @XmlEnumValue("GetFunctionKey")
    GET_FUNCTION_KEY("GetFunctionKey"),

    /**
     * To choose an entry among a list of entrys (all of them are not necessary selectable). The OutputFormat has to be MenuEntry.
     * 
     */
    @XmlEnumValue("GetMenuEntry")
    GET_MENU_ENTRY("GetMenuEntry"),

    /**
     * Request to enter a password with masked characters while typing the password.
     * 
     */
    @XmlEnumValue("Password")
    PASSWORD("Password");
    private final String value;

    InputCommandEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InputCommandEnumeration fromValue(String v) {
        for (InputCommandEnumeration c: InputCommandEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
