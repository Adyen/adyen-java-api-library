
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MenuEntryTagEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MenuEntryTagEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Selectable"/>
 *     &lt;enumeration value="NonSelectable"/>
 *     &lt;enumeration value="SubMenu"/>
 *     &lt;enumeration value="NonSelectableSubMenu"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MenuEntryTagEnumeration")
@XmlEnum
public enum MenuEntryTagEnumeration {


    /**
     * The Cashier may select this entryof the menu
     * 
     */
    @XmlEnumValue("Selectable")
    SELECTABLE("Selectable"),

    /**
     * The Cashier cannot select this entryof the menu
     * 
     */
    @XmlEnumValue("NonSelectable")
    NON_SELECTABLE("NonSelectable"),

    /**
     * The selection of this entry produces the display of a sub-menu (by the sending of another Input Request message containing the entries of this sub-menu).
     * 
     */
    @XmlEnumValue("SubMenu")
    SUB_MENU("SubMenu"),

    /**
     * The menu entry is a submenu, but cannot be selected.
     * 
     */
    @XmlEnumValue("NonSelectableSubMenu")
    NON_SELECTABLE_SUB_MENU("NonSelectableSubMenu");
    private final String value;

    MenuEntryTagEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MenuEntryTagEnumeration fromValue(String v) {
        for (MenuEntryTagEnumeration c: MenuEntryTagEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
