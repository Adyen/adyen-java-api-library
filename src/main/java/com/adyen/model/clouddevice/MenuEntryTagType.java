package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of menu entry tag. */
public enum MenuEntryTagType {

  /** The Cashier may select this entryof the menu */
  @Schema(description = "The Cashier may select this entryof the menu")
  SELECTABLE("Selectable"),

  /** The Cashier cannot select this entryof the menu */
  @Schema(description = "The Cashier cannot select this entryof the menu")
  NON_SELECTABLE("NonSelectable"),

  /**
   * The selection of this entry produces the display of a sub-menu (by the sending of another Input
   * Request messageType containing the entries of this sub-menu).
   */
  @Schema(
      description =
          "The selection of this entry produces the display of a sub-menu (by the sending of another Input Request message containing the entries of this sub-menu).")
  SUB_MENU("SubMenu"),

  /** The menu entry is a submenu, but cannot be selected. */
  @Schema(description = "The menu entry is a submenu, but cannot be selected.")
  NON_SELECTABLE_SUB_MENU("NonSelectableSubMenu");

  private final String value;

  MenuEntryTagType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the MenuEntryTagType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a MenuEntryTagType from a string value.
   *
   * @param v the string value
   * @return the corresponding MenuEntryTagType
   */
  @JsonCreator
  public static MenuEntryTagType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
