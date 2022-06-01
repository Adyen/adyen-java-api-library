/*
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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.posterminalmanagement;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * GetTerminalDetailsResponse
 */

public class GetTerminalDetailsResponse {
    @SerializedName("bluetoothIp")
    private String bluetoothIp = null;

    @SerializedName("bluetoothMac")
    private String bluetoothMac = null;

    @SerializedName("companyAccount")
    private String companyAccount = null;

    @SerializedName("country")
    private String country = null;

    @SerializedName("deviceModel")
    private String deviceModel = null;

    @SerializedName("dhcpEnabled")
    private Boolean dhcpEnabled = null;

    @SerializedName("displayLabel")
    private String displayLabel = null;

    @SerializedName("ethernetIp")
    private String ethernetIp = null;

    @SerializedName("ethernetMac")
    private String ethernetMac = null;

    @SerializedName("firmwareVersion")
    private String firmwareVersion = null;

    @SerializedName("iccid")
    private String iccid = null;

    @SerializedName("lastActivityDateTime")
    private String lastActivityDateTime = null;

    @SerializedName("lastTransactionDateTime")
    private String lastTransactionDateTime = null;

    @SerializedName("linkNegotiation")
    private String linkNegotiation = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("merchantInventory")
    private Boolean merchantInventory = null;

    @SerializedName("permanentTerminalId")
    private String permanentTerminalId = null;

    @SerializedName("serialNumber")
    private String serialNumber = null;

    @SerializedName("simStatus")
    private String simStatus = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("storeDetails")
    private Store storeDetails = null;

    @SerializedName("terminal")
    private String terminal = null;

    /**
     * The status of the terminal:   - &#x60;OnlineToday&#x60;, &#x60;OnlineLast1Day&#x60;, &#x60;OnlineLast2Days&#x60; etcetera to &#x60;OnlineLast7Days&#x60;: Indicates when in the past week the terminal was last online.   - &#x60;SwitchedOff&#x60;: Indicates it was more than a week ago that the terminal was last online.   - &#x60;ReAssignToInventoryPending&#x60;, &#x60;ReAssignToStorePending&#x60;, &#x60;ReAssignToMerchantInventoryPending&#x60;: Indicates the terminal is scheduled to be reassigned.
     */
    @JsonAdapter(TerminalStatusEnum.Adapter.class)
    public enum TerminalStatusEnum {
        ONLINELAST1DAY("OnlineLast1Day"),
        ONLINELAST2DAYS("OnlineLast2Days"),
        ONLINELAST3DAYS("OnlineLast3Days"),
        ONLINELAST4DAYS("OnlineLast4Days"),
        ONLINELAST5DAYS("OnlineLast5Days"),
        ONLINELAST6DAYS("OnlineLast6Days"),
        ONLINELAST7DAYS("OnlineLast7Days"),
        ONLINETODAY("OnlineToday"),
        REASSIGNTOINVENTORYPENDING("ReAssignToInventoryPending"),
        REASSIGNTOMERCHANTINVENTORYPENDING("ReAssignToMerchantInventoryPending"),
        REASSIGNTOSTOREPENDING("ReAssignToStorePending"),
        SWITCHEDOFF("SwitchedOff");

        @JsonValue
        private final String value;

        TerminalStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TerminalStatusEnum fromValue(String text) {
            for (TerminalStatusEnum b : TerminalStatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TerminalStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TerminalStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TerminalStatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TerminalStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("terminalStatus")
    private TerminalStatusEnum terminalStatus = null;

    @SerializedName("wifiIp")
    private String wifiIp = null;

    @SerializedName("wifiMac")
    private String wifiMac = null;

    public GetTerminalDetailsResponse bluetoothIp(String bluetoothIp) {
        this.bluetoothIp = bluetoothIp;
        return this;
    }

    /**
     * The Bluetooth IP address of the terminal.
     *
     * @return bluetoothIp
     **/
    public String getBluetoothIp() {
        return bluetoothIp;
    }

    public void setBluetoothIp(String bluetoothIp) {
        this.bluetoothIp = bluetoothIp;
    }

    public GetTerminalDetailsResponse bluetoothMac(String bluetoothMac) {
        this.bluetoothMac = bluetoothMac;
        return this;
    }

    /**
     * The Bluetooth MAC address of the terminal.
     *
     * @return bluetoothMac
     **/
    public String getBluetoothMac() {
        return bluetoothMac;
    }

    public void setBluetoothMac(String bluetoothMac) {
        this.bluetoothMac = bluetoothMac;
    }

    public GetTerminalDetailsResponse companyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
        return this;
    }

    /**
     * The company account that the terminal is associated with. If this is the only account level shown in the response, the terminal is assigned to the inventory of the company account.
     *
     * @return companyAccount
     **/
    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public GetTerminalDetailsResponse country(String country) {
        this.country = country;
        return this;
    }

    /**
     * The country where the terminal is used.
     *
     * @return country
     **/
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GetTerminalDetailsResponse deviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
        return this;
    }

    /**
     * The model name of the terminal.
     *
     * @return deviceModel
     **/
    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public GetTerminalDetailsResponse dhcpEnabled(Boolean dhcpEnabled) {
        this.dhcpEnabled = dhcpEnabled;
        return this;
    }

    /**
     * Indicates whether assigning IP addresses through a DHCP server is enabled on the terminal.
     *
     * @return dhcpEnabled
     **/
    public Boolean isDhcpEnabled() {
        return dhcpEnabled;
    }

    public void setDhcpEnabled(Boolean dhcpEnabled) {
        this.dhcpEnabled = dhcpEnabled;
    }

    public GetTerminalDetailsResponse displayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
        return this;
    }

    /**
     * The label shown on the status bar of the display. This label (if any) is specified in your Customer Area.
     *
     * @return displayLabel
     **/
    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public GetTerminalDetailsResponse ethernetIp(String ethernetIp) {
        this.ethernetIp = ethernetIp;
        return this;
    }

    /**
     * The terminal&#x27;s IP address in your Ethernet network.
     *
     * @return ethernetIp
     **/
    public String getEthernetIp() {
        return ethernetIp;
    }

    public void setEthernetIp(String ethernetIp) {
        this.ethernetIp = ethernetIp;
    }

    public GetTerminalDetailsResponse ethernetMac(String ethernetMac) {
        this.ethernetMac = ethernetMac;
        return this;
    }

    /**
     * The terminal&#x27;s MAC address in your Ethernet network.
     *
     * @return ethernetMac
     **/
    public String getEthernetMac() {
        return ethernetMac;
    }

    public void setEthernetMac(String ethernetMac) {
        this.ethernetMac = ethernetMac;
    }

    public GetTerminalDetailsResponse firmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return this;
    }

    /**
     * The software release currently in use on the terminal.
     *
     * @return firmwareVersion
     **/
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public GetTerminalDetailsResponse iccid(String iccid) {
        this.iccid = iccid;
        return this;
    }

    /**
     * The integrated circuit card identifier (ICCID) of the SIM card in the terminal.
     *
     * @return iccid
     **/
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public GetTerminalDetailsResponse lastActivityDateTime(String lastActivityDateTime) {
        this.lastActivityDateTime = lastActivityDateTime;
        return this;
    }

    /**
     * Date and time of the last activity on the terminal. Not included when the last activity was more than 14 days ago.
     *
     * @return lastActivityDateTime
     **/
    public String getLastActivityDateTime() {
        return lastActivityDateTime;
    }

    public void setLastActivityDateTime(String lastActivityDateTime) {
        this.lastActivityDateTime = lastActivityDateTime;
    }

    public GetTerminalDetailsResponse lastTransactionDateTime(String lastTransactionDateTime) {
        this.lastTransactionDateTime = lastTransactionDateTime;
        return this;
    }

    /**
     * Date and time of the last transaction on the terminal. Not included when the last transaction was more than 14 days ago.
     *
     * @return lastTransactionDateTime
     **/
    public String getLastTransactionDateTime() {
        return lastTransactionDateTime;
    }

    public void setLastTransactionDateTime(String lastTransactionDateTime) {
        this.lastTransactionDateTime = lastTransactionDateTime;
    }

    public GetTerminalDetailsResponse linkNegotiation(String linkNegotiation) {
        this.linkNegotiation = linkNegotiation;
        return this;
    }

    /**
     * The Ethernet link negotiation that the terminal uses:   - &#x60;auto&#x60;: Auto-negotiation  - &#x60;100full&#x60;: 100 Mbps full duplex
     *
     * @return linkNegotiation
     **/
    public String getLinkNegotiation() {
        return linkNegotiation;
    }

    public void setLinkNegotiation(String linkNegotiation) {
        this.linkNegotiation = linkNegotiation;
    }

    public GetTerminalDetailsResponse merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account that the terminal is associated with. If the response doesn&#x27;t contain a &#x60;store&#x60; the terminal is assigned to this merchant account.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public GetTerminalDetailsResponse merchantInventory(Boolean merchantInventory) {
        this.merchantInventory = merchantInventory;
        return this;
    }

    /**
     * Boolean that indicates if the terminal is assigned to the merchant inventory. This is returned when the terminal is assigned to a merchant account.  - If **true**, this indicates that the terminal is in the merchant inventory. This also means that the terminal cannot be boarded.  - If **false**, this indicates that the terminal is assigned to the merchant account as an in-store terminal. This means that the terminal is ready to be boarded, or is already boarded.
     *
     * @return merchantInventory
     **/
    public Boolean isMerchantInventory() {
        return merchantInventory;
    }

    public void setMerchantInventory(Boolean merchantInventory) {
        this.merchantInventory = merchantInventory;
    }

    public GetTerminalDetailsResponse permanentTerminalId(String permanentTerminalId) {
        this.permanentTerminalId = permanentTerminalId;
        return this;
    }

    /**
     * The permanent terminal ID.
     *
     * @return permanentTerminalId
     **/
    public String getPermanentTerminalId() {
        return permanentTerminalId;
    }

    public void setPermanentTerminalId(String permanentTerminalId) {
        this.permanentTerminalId = permanentTerminalId;
    }

    public GetTerminalDetailsResponse serialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /**
     * The serial number of the terminal.
     *
     * @return serialNumber
     **/
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public GetTerminalDetailsResponse simStatus(String simStatus) {
        this.simStatus = simStatus;
        return this;
    }

    /**
     * On a terminal that supports 3G or 4G connectivity, indicates the status of the SIM card in the terminal: ACTIVE or INVENTORY.
     *
     * @return simStatus
     **/
    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        this.simStatus = simStatus;
    }

    public GetTerminalDetailsResponse store(String store) {
        this.store = store;
        return this;
    }

    /**
     * The store code of the store that the terminal is assigned to.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public GetTerminalDetailsResponse storeDetails(Store storeDetails) {
        this.storeDetails = storeDetails;
        return this;
    }

    /**
     * Get storeDetails
     *
     * @return storeDetails
     **/
    public Store getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(Store storeDetails) {
        this.storeDetails = storeDetails;
    }

    public GetTerminalDetailsResponse terminal(String terminal) {
        this.terminal = terminal;
        return this;
    }

    /**
     * The unique terminal ID.
     *
     * @return terminal
     **/
    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public GetTerminalDetailsResponse terminalStatus(TerminalStatusEnum terminalStatus) {
        this.terminalStatus = terminalStatus;
        return this;
    }

    /**
     * The status of the terminal:   - &#x60;OnlineToday&#x60;, &#x60;OnlineLast1Day&#x60;, &#x60;OnlineLast2Days&#x60; etcetera to &#x60;OnlineLast7Days&#x60;: Indicates when in the past week the terminal was last online.   - &#x60;SwitchedOff&#x60;: Indicates it was more than a week ago that the terminal was last online.   - &#x60;ReAssignToInventoryPending&#x60;, &#x60;ReAssignToStorePending&#x60;, &#x60;ReAssignToMerchantInventoryPending&#x60;: Indicates the terminal is scheduled to be reassigned.
     *
     * @return terminalStatus
     **/
    public TerminalStatusEnum getTerminalStatus() {
        return terminalStatus;
    }

    public void setTerminalStatus(TerminalStatusEnum terminalStatus) {
        this.terminalStatus = terminalStatus;
    }

    public GetTerminalDetailsResponse wifiIp(String wifiIp) {
        this.wifiIp = wifiIp;
        return this;
    }

    /**
     * The terminal&#x27;s IP address in your Wi-Fi network.
     *
     * @return wifiIp
     **/
    public String getWifiIp() {
        return wifiIp;
    }

    public void setWifiIp(String wifiIp) {
        this.wifiIp = wifiIp;
    }

    public GetTerminalDetailsResponse wifiMac(String wifiMac) {
        this.wifiMac = wifiMac;
        return this;
    }

    /**
     * The terminal&#x27;s MAC address in your Wi-Fi network.
     *
     * @return wifiMac
     **/
    public String getWifiMac() {
        return wifiMac;
    }

    public void setWifiMac(String wifiMac) {
        this.wifiMac = wifiMac;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTerminalDetailsResponse getTerminalDetailsResponse = (GetTerminalDetailsResponse) o;
        return Objects.equals(this.bluetoothIp, getTerminalDetailsResponse.bluetoothIp) &&
                Objects.equals(this.bluetoothMac, getTerminalDetailsResponse.bluetoothMac) &&
                Objects.equals(this.companyAccount, getTerminalDetailsResponse.companyAccount) &&
                Objects.equals(this.country, getTerminalDetailsResponse.country) &&
                Objects.equals(this.deviceModel, getTerminalDetailsResponse.deviceModel) &&
                Objects.equals(this.dhcpEnabled, getTerminalDetailsResponse.dhcpEnabled) &&
                Objects.equals(this.displayLabel, getTerminalDetailsResponse.displayLabel) &&
                Objects.equals(this.ethernetIp, getTerminalDetailsResponse.ethernetIp) &&
                Objects.equals(this.ethernetMac, getTerminalDetailsResponse.ethernetMac) &&
                Objects.equals(this.firmwareVersion, getTerminalDetailsResponse.firmwareVersion) &&
                Objects.equals(this.iccid, getTerminalDetailsResponse.iccid) &&
                Objects.equals(this.lastActivityDateTime, getTerminalDetailsResponse.lastActivityDateTime) &&
                Objects.equals(this.lastTransactionDateTime, getTerminalDetailsResponse.lastTransactionDateTime) &&
                Objects.equals(this.linkNegotiation, getTerminalDetailsResponse.linkNegotiation) &&
                Objects.equals(this.merchantAccount, getTerminalDetailsResponse.merchantAccount) &&
                Objects.equals(this.merchantInventory, getTerminalDetailsResponse.merchantInventory) &&
                Objects.equals(this.permanentTerminalId, getTerminalDetailsResponse.permanentTerminalId) &&
                Objects.equals(this.serialNumber, getTerminalDetailsResponse.serialNumber) &&
                Objects.equals(this.simStatus, getTerminalDetailsResponse.simStatus) &&
                Objects.equals(this.store, getTerminalDetailsResponse.store) &&
                Objects.equals(this.storeDetails, getTerminalDetailsResponse.storeDetails) &&
                Objects.equals(this.terminal, getTerminalDetailsResponse.terminal) &&
                Objects.equals(this.terminalStatus, getTerminalDetailsResponse.terminalStatus) &&
                Objects.equals(this.wifiIp, getTerminalDetailsResponse.wifiIp) &&
                Objects.equals(this.wifiMac, getTerminalDetailsResponse.wifiMac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bluetoothIp, bluetoothMac, companyAccount, country, deviceModel, dhcpEnabled, displayLabel, ethernetIp, ethernetMac, firmwareVersion, iccid, lastActivityDateTime, lastTransactionDateTime, linkNegotiation, merchantAccount, merchantInventory, permanentTerminalId, serialNumber, simStatus, store, storeDetails, terminal, terminalStatus, wifiIp, wifiMac);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetTerminalDetailsResponse {\n");

        sb.append("    bluetoothIp: ").append(toIndentedString(bluetoothIp)).append("\n");
        sb.append("    bluetoothMac: ").append(toIndentedString(bluetoothMac)).append("\n");
        sb.append("    companyAccount: ").append(toIndentedString(companyAccount)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    deviceModel: ").append(toIndentedString(deviceModel)).append("\n");
        sb.append("    dhcpEnabled: ").append(toIndentedString(dhcpEnabled)).append("\n");
        sb.append("    displayLabel: ").append(toIndentedString(displayLabel)).append("\n");
        sb.append("    ethernetIp: ").append(toIndentedString(ethernetIp)).append("\n");
        sb.append("    ethernetMac: ").append(toIndentedString(ethernetMac)).append("\n");
        sb.append("    firmwareVersion: ").append(toIndentedString(firmwareVersion)).append("\n");
        sb.append("    iccid: ").append(toIndentedString(iccid)).append("\n");
        sb.append("    lastActivityDateTime: ").append(toIndentedString(lastActivityDateTime)).append("\n");
        sb.append("    lastTransactionDateTime: ").append(toIndentedString(lastTransactionDateTime)).append("\n");
        sb.append("    linkNegotiation: ").append(toIndentedString(linkNegotiation)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    merchantInventory: ").append(toIndentedString(merchantInventory)).append("\n");
        sb.append("    permanentTerminalId: ").append(toIndentedString(permanentTerminalId)).append("\n");
        sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
        sb.append("    simStatus: ").append(toIndentedString(simStatus)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    storeDetails: ").append(toIndentedString(storeDetails)).append("\n");
        sb.append("    terminal: ").append(toIndentedString(terminal)).append("\n");
        sb.append("    terminalStatus: ").append(toIndentedString(terminalStatus)).append("\n");
        sb.append("    wifiIp: ").append(toIndentedString(wifiIp)).append("\n");
        sb.append("    wifiMac: ").append(toIndentedString(wifiMac)).append("\n");
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
