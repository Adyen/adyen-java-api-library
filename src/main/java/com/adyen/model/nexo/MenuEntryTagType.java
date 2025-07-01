package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for MenuEntryTagType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="MenuEntryTagType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Selectable"/&gt;
 *     &lt;enumeration value="NonSelectable"/&gt;
 *     &lt;enumeration value="SubMenu"/&gt;
 *     &lt;enumeration value="NonSelectableSubMenu"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MenuEntryTagType")
@XmlEnum
public enum MenuEntryTagType {

  /** The Cashier may select this entryof the menu */
  @XmlEnumValue("Selectable")
  @Schema(description = "The Cashier may select this entryof the menu")
  SELECTABLE("Selectable"),

  /** The Cashier cannot select this entryof the menu */
  @XmlEnumValue("NonSelectable")
  @Schema(description = "The Cashier cannot select this entryof the menu")
  NON_SELECTABLE("NonSelectable"),

  /**
   * The selection of this entry produces the display of a sub-menu (by the sending of another Input
   * Request messageType containing the entries of this sub-menu).
   */
  @XmlEnumValue("SubMenu")
  @Schema(
      description =
          "The selection of this entry produces the display of a sub-menu (by the sending of another Input Request message containing the entries of this sub-menu).")
  SUB_MENU("SubMenu"),

  /** The menu entry is a submenu, but cannot be selected. */
  @XmlEnumValue("NonSelectableSubMenu")
  @Schema(description = "The menu entry is a submenu, but cannot be selected.")
  NON_SELECTABLE_SUB_MENU("NonSelectableSubMenu");
  private final String value;

  MenuEntryTagType(String v) {
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
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the MenuEntryTagType, or {@code null} if no match is found.
   */
  public static MenuEntryTagType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
