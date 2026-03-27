package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Print Request messageType. -- Usage: It conveys the data to print and
 * the way to process the print. It contains the complete content to print.
 *
 * <p>Java class for PrintRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PrintRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrintOutput" type="{}PrintOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class PrintRequest {

  /** The Print output. */
  @SerializedName("PrintOutput")
  @Schema(description = "Information to print and the way to process the print.")
  protected PrintOutput printOutput;

  /**
   * Gets the value of the printOutput property.
   *
   * @return possible object is {@link PrintOutput }
   */
  public PrintOutput getPrintOutput() {
    return printOutput;
  }

  /**
   * Sets the value of the printOutput property.
   *
   * @param value allowed object is {@link PrintOutput }
   */
  public void setPrintOutput(PrintOutput value) {
    this.printOutput = value;
  }
}
