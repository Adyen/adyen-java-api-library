/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** Key */
@JsonPropertyOrder({
  Key.JSON_PROPERTY_IDENTIFIER,
  Key.JSON_PROPERTY_PASSPHRASE,
  Key.JSON_PROPERTY_VERSION
})
public class Key {
  public static final String JSON_PROPERTY_IDENTIFIER = "identifier";
  private String identifier;

  public static final String JSON_PROPERTY_PASSPHRASE = "passphrase";
  private String passphrase;

  public static final String JSON_PROPERTY_VERSION = "version";
  private Integer version;

  public Key() {}

  /**
   * The unique identifier of the shared key.
   *
   * @param identifier The unique identifier of the shared key.
   * @return the current {@code Key} instance, allowing for method chaining
   */
  public Key identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * The unique identifier of the shared key.
   *
   * @return identifier The unique identifier of the shared key.
   */
  @JsonProperty(JSON_PROPERTY_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIdentifier() {
    return identifier;
  }

  /**
   * The unique identifier of the shared key.
   *
   * @param identifier The unique identifier of the shared key.
   */
  @JsonProperty(JSON_PROPERTY_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * The secure passphrase to protect the shared key. Must consist of: * At least 12 characters. *
   * At least 1 uppercase letter: &#x60;[A-Z]&#x60;. * At least 1 lowercase letter:
   * &#x60;[a-z]&#x60;. * At least 1 digit: &#x60;[0-9]&#x60;. * At least 1 special character.
   * Limited to the following: &#x60;~&#x60;, &#x60;@&#x60;, &#x60;$&#x60;, &#x60;%&#x60;,
   * &#x60;^&#x60;, &#x60;&amp;&#x60;, &#x60;*&#x60;, &#x60;(&#x60;, &#x60;)&#x60;, &#x60;_&#x60;,
   * &#x60;+&#x60;, &#x60;&#x3D;&#x60;, &#x60;}&#x60;, &#x60;{&#x60;, &#x60;]&#x60;, &#x60;[&#x60;,
   * &#x60;;&#x60;, &#x60;:&#x60;, &#x60;?&#x60;, &#x60;.&#x60;, &#x60;,&#x60;, &#x60;&gt;&#x60;,
   * &#x60;&lt;&#x60;.
   *
   * @param passphrase The secure passphrase to protect the shared key. Must consist of: * At least
   *     12 characters. * At least 1 uppercase letter: &#x60;[A-Z]&#x60;. * At least 1 lowercase
   *     letter: &#x60;[a-z]&#x60;. * At least 1 digit: &#x60;[0-9]&#x60;. * At least 1 special
   *     character. Limited to the following: &#x60;~&#x60;, &#x60;@&#x60;, &#x60;$&#x60;,
   *     &#x60;%&#x60;, &#x60;^&#x60;, &#x60;&amp;&#x60;, &#x60;*&#x60;, &#x60;(&#x60;,
   *     &#x60;)&#x60;, &#x60;_&#x60;, &#x60;+&#x60;, &#x60;&#x3D;&#x60;, &#x60;}&#x60;,
   *     &#x60;{&#x60;, &#x60;]&#x60;, &#x60;[&#x60;, &#x60;;&#x60;, &#x60;:&#x60;, &#x60;?&#x60;,
   *     &#x60;.&#x60;, &#x60;,&#x60;, &#x60;&gt;&#x60;, &#x60;&lt;&#x60;.
   * @return the current {@code Key} instance, allowing for method chaining
   */
  public Key passphrase(String passphrase) {
    this.passphrase = passphrase;
    return this;
  }

  /**
   * The secure passphrase to protect the shared key. Must consist of: * At least 12 characters. *
   * At least 1 uppercase letter: &#x60;[A-Z]&#x60;. * At least 1 lowercase letter:
   * &#x60;[a-z]&#x60;. * At least 1 digit: &#x60;[0-9]&#x60;. * At least 1 special character.
   * Limited to the following: &#x60;~&#x60;, &#x60;@&#x60;, &#x60;$&#x60;, &#x60;%&#x60;,
   * &#x60;^&#x60;, &#x60;&amp;&#x60;, &#x60;*&#x60;, &#x60;(&#x60;, &#x60;)&#x60;, &#x60;_&#x60;,
   * &#x60;+&#x60;, &#x60;&#x3D;&#x60;, &#x60;}&#x60;, &#x60;{&#x60;, &#x60;]&#x60;, &#x60;[&#x60;,
   * &#x60;;&#x60;, &#x60;:&#x60;, &#x60;?&#x60;, &#x60;.&#x60;, &#x60;,&#x60;, &#x60;&gt;&#x60;,
   * &#x60;&lt;&#x60;.
   *
   * @return passphrase The secure passphrase to protect the shared key. Must consist of: * At least
   *     12 characters. * At least 1 uppercase letter: &#x60;[A-Z]&#x60;. * At least 1 lowercase
   *     letter: &#x60;[a-z]&#x60;. * At least 1 digit: &#x60;[0-9]&#x60;. * At least 1 special
   *     character. Limited to the following: &#x60;~&#x60;, &#x60;@&#x60;, &#x60;$&#x60;,
   *     &#x60;%&#x60;, &#x60;^&#x60;, &#x60;&amp;&#x60;, &#x60;*&#x60;, &#x60;(&#x60;,
   *     &#x60;)&#x60;, &#x60;_&#x60;, &#x60;+&#x60;, &#x60;&#x3D;&#x60;, &#x60;}&#x60;,
   *     &#x60;{&#x60;, &#x60;]&#x60;, &#x60;[&#x60;, &#x60;;&#x60;, &#x60;:&#x60;, &#x60;?&#x60;,
   *     &#x60;.&#x60;, &#x60;,&#x60;, &#x60;&gt;&#x60;, &#x60;&lt;&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_PASSPHRASE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPassphrase() {
    return passphrase;
  }

  /**
   * The secure passphrase to protect the shared key. Must consist of: * At least 12 characters. *
   * At least 1 uppercase letter: &#x60;[A-Z]&#x60;. * At least 1 lowercase letter:
   * &#x60;[a-z]&#x60;. * At least 1 digit: &#x60;[0-9]&#x60;. * At least 1 special character.
   * Limited to the following: &#x60;~&#x60;, &#x60;@&#x60;, &#x60;$&#x60;, &#x60;%&#x60;,
   * &#x60;^&#x60;, &#x60;&amp;&#x60;, &#x60;*&#x60;, &#x60;(&#x60;, &#x60;)&#x60;, &#x60;_&#x60;,
   * &#x60;+&#x60;, &#x60;&#x3D;&#x60;, &#x60;}&#x60;, &#x60;{&#x60;, &#x60;]&#x60;, &#x60;[&#x60;,
   * &#x60;;&#x60;, &#x60;:&#x60;, &#x60;?&#x60;, &#x60;.&#x60;, &#x60;,&#x60;, &#x60;&gt;&#x60;,
   * &#x60;&lt;&#x60;.
   *
   * @param passphrase The secure passphrase to protect the shared key. Must consist of: * At least
   *     12 characters. * At least 1 uppercase letter: &#x60;[A-Z]&#x60;. * At least 1 lowercase
   *     letter: &#x60;[a-z]&#x60;. * At least 1 digit: &#x60;[0-9]&#x60;. * At least 1 special
   *     character. Limited to the following: &#x60;~&#x60;, &#x60;@&#x60;, &#x60;$&#x60;,
   *     &#x60;%&#x60;, &#x60;^&#x60;, &#x60;&amp;&#x60;, &#x60;*&#x60;, &#x60;(&#x60;,
   *     &#x60;)&#x60;, &#x60;_&#x60;, &#x60;+&#x60;, &#x60;&#x3D;&#x60;, &#x60;}&#x60;,
   *     &#x60;{&#x60;, &#x60;]&#x60;, &#x60;[&#x60;, &#x60;;&#x60;, &#x60;:&#x60;, &#x60;?&#x60;,
   *     &#x60;.&#x60;, &#x60;,&#x60;, &#x60;&gt;&#x60;, &#x60;&lt;&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_PASSPHRASE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase;
  }

  /**
   * The version number of the shared key.
   *
   * @param version The version number of the shared key.
   * @return the current {@code Key} instance, allowing for method chaining
   */
  public Key version(Integer version) {
    this.version = version;
    return this;
  }

  /**
   * The version number of the shared key.
   *
   * @return version The version number of the shared key.
   */
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getVersion() {
    return version;
  }

  /**
   * The version number of the shared key.
   *
   * @param version The version number of the shared key.
   */
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(Integer version) {
    this.version = version;
  }

  /** Return true if this Key object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Key key = (Key) o;
    return Objects.equals(this.identifier, key.identifier)
        && Objects.equals(this.passphrase, key.passphrase)
        && Objects.equals(this.version, key.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, passphrase, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Key {\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    passphrase: ").append(toIndentedString(passphrase)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of Key given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Key
   * @throws JsonProcessingException if the JSON string is invalid with respect to Key
   */
  public static Key fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Key.class);
  }

  /**
   * Convert an instance of Key to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
