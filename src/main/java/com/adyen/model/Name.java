/**
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Name
 */
public class Name {
  @SerializedName("infix")
  private String infix = null;

  /**
   * the gender
   */
  public enum GenderEnum {
    @SerializedName("MALE")
    MALE("MALE"),
    
    @SerializedName("FEMALE")
    FEMALE("FEMALE"),
    
    @SerializedName("UNKNOWN")
    UNKNOWN("UNKNOWN");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("gender")
  private GenderEnum gender = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("firstName")
  private String firstName = null;

  public Name infix(String infix) {
    this.infix = infix;
    return this;
  }

   /**
   * the infix
   * @return infix
  **/
  public String getInfix() {
    return infix;
  }

  public void setInfix(String infix) {
    this.infix = infix;
  }

  public Name gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

   /**
   * the gender
   * @return gender
  **/
  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public Name lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * the last name
   * @return lastName
  **/
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Name firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * the first name
   * @return firstName
  **/
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(this.infix, name.infix) &&
        Objects.equals(this.gender, name.gender) &&
        Objects.equals(this.lastName, name.lastName) &&
        Objects.equals(this.firstName, name.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(infix, gender, lastName, firstName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Name {\n");

    sb.append("    infix: ").append(toIndentedString(infix)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

