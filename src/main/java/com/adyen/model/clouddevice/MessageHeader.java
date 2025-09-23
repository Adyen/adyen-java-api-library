package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Message header of the Sale to POI protocol message.
 */
@JsonPropertyOrder({
		"ProtocolVersion",
		"MessageClass",
		"MessageCategory",
		"MessageType",
		"ServiceID",
		"DeviceID",
		"SaleID",
		"POIID"
})
public class MessageHeader {

	@JsonProperty("ProtocolVersion")
	@Schema(description = ">--Rule:If MessageCategory is Login or Diagnosis")
	protected String protocolVersion;

	@JsonProperty("MessageClass")
	@Schema(description = "Class of the message")
	protected MessageClassType messageClass;

	@JsonProperty("MessageCategory")
	@Schema(description = "Category of message.")
	protected MessageCategoryType messageCategory;

	@JsonProperty("MessageType")
	@Schema(description = "Type of message of the Sale to POI protocol")
	protected MessageType messageType;

	@JsonProperty("ServiceID")
	@Schema(
			description =
					"Identification of a message pair, which processes a transaction --Rule: If \"Service\" or \"Event\" MessageClass message. If \"Device\" MessageClass, and request from POI or response from Sale.",
			minLength = 1,
			maxLength = 10)
	protected String serviceID;

	@JsonProperty("DeviceID")
	@Schema(
			description = "Identification of a device message pair --Rule: If \"Device\" MessageClass")
	protected String deviceID;

	@JsonProperty("SaleID")
	@Schema(
			description =
					"Identification of a Sale System or a Sale Terminal for the Sale to POI protocol")
	protected String saleID;

	@JsonProperty("POIID")
	@Schema(
			description = "Identification of a POI System or a POI Terminal for the Sale to POI protocol")
	protected String poiid;

	/**
	 * Gets protocol version.
	 *
	 * @return the protocol version
	 */
	public String getProtocolVersion() {
		return protocolVersion;
	}

	/**
	 * Sets protocol version.
	 *
	 * @param protocolVersion the protocol version
	 */
	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	/**
	 * Gets message class.
	 *
	 * @return the message class
	 */
	public MessageClassType getMessageClass() {
		return messageClass;
	}

	/**
	 * Sets message class.
	 *
	 * @param messageClass the message class
	 */
	public void setMessageClass(MessageClassType messageClass) {
		this.messageClass = messageClass;
	}

	/**
	 * Gets message category.
	 *
	 * @return the message category
	 */
	public MessageCategoryType getMessageCategory() {
		return messageCategory;
	}

	/**
	 * Sets message category.
	 *
	 * @param messageCategory the message category
	 */
	public void setMessageCategory(MessageCategoryType messageCategory) {
		this.messageCategory = messageCategory;
	}

	/**
	 * Gets message type.
	 *
	 * @return the message type
	 */
	public MessageType getMessageType() {
		return messageType;
	}

	/**
	 * Sets message type.
	 *
	 * @param messageType the message type
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	/**
	 * Gets service id.
	 *
	 * @return the service id
	 */
	public String getServiceID() {
		return serviceID;
	}

	/**
	 * Sets service id.
	 *
	 * @param serviceID the service id
	 */
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	/**
	 * Gets device id.
	 *
	 * @return the device id
	 */
	public String getDeviceID() {
		return deviceID;
	}

	/**
	 * Sets device id.
	 *
	 * @param deviceID the device id
	 */
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	/**
	 * Gets sale id.
	 *
	 * @return the sale id
	 */
	public String getSaleID() {
		return saleID;
	}

	/**
	 * Sets sale id.
	 *
	 * @param saleID the sale id
	 */
	public void setSaleID(String saleID) {
		this.saleID = saleID;
	}

	/**
	 * Gets poiid.
	 *
	 * @return the poiid
	 */
	public String getPOIID() {
		return poiid;
	}

	/**
	 * Sets poiid.
	 *
	 * @param poiid the poiid
	 */
	public void setPOIID(String poiid) {
		this.poiid = poiid;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MessageHeader {\n");
		sb.append("    protocolVersion: ").append(toIndentedString(protocolVersion)).append("\n");
		sb.append("    messageClass: ").append(toIndentedString(messageClass)).append("\n");
		sb.append("    messageCategory: ").append(toIndentedString(messageCategory)).append("\n");
		sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
		sb.append("    serviceID: ").append(toIndentedString(serviceID)).append("\n");
		sb.append("    deviceID: ").append(toIndentedString(deviceID)).append("\n");
		sb.append("    saleID: ").append(toIndentedString(saleID)).append("\n");
		sb.append("    poiid: ").append(toIndentedString(poiid)).append("\n");
		sb.append("}\n");
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