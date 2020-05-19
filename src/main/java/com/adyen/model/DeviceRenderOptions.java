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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 *
 */

package com.adyen.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * DeviceRenderOptions
 */
public class DeviceRenderOptions {

    /**
     * Gets or Sets sdkInterface
     */
    @JsonAdapter(SdkInterfaceEnum.Adapter.class)
    public enum SdkInterfaceEnum {

        HTML("Html"),
        NATIVE("Native"),
        BOTH("both");

        private String value;

        SdkInterfaceEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SdkInterfaceEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<SdkInterfaceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SdkInterfaceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SdkInterfaceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SdkInterfaceEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("sdkInterface")
    private SdkInterfaceEnum sdkInterface = null;

    /**
     * Gets or Sets sdkUiType
     */
    @JsonAdapter(SdkUiTypeEnum.Adapter.class)
    public enum SdkUiTypeEnum {

        MULTISELECT("multiSelect"),
        OTHERHTML("otherHtml"),
        OUTOFBAND("outOfBand"),
        SINGLESELECT("singleSelect"),
        TEXT("text");

        private String value;

        SdkUiTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SdkUiTypeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<SdkUiTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SdkUiTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SdkUiTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SdkUiTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("sdkUiType")
    private List<SdkUiTypeEnum> sdkUiType = null;

    public DeviceRenderOptions sdkInterface(SdkInterfaceEnum sdkInterface) {
        this.sdkInterface = sdkInterface;
        return this;
    }

    public SdkInterfaceEnum getSdkInterface() {
        return sdkInterface;
    }

    public void setSdkInterface(SdkInterfaceEnum sdkInterface) {
        this.sdkInterface = sdkInterface;
    }

    public DeviceRenderOptions sdkUiType(List<SdkUiTypeEnum> sdkUiType) {
        this.sdkUiType = sdkUiType;
        return this;
    }

    public DeviceRenderOptions addSdkUiTypeItem(SdkUiTypeEnum sdkUiTypeItem) {

        if (this.sdkUiType == null) {
            this.sdkUiType = new ArrayList<>();
        }

        this.sdkUiType.add(sdkUiTypeItem);
        return this;
    }

    public List<SdkUiTypeEnum> getSdkUiType() {
        return sdkUiType;
    }

    public void setSdkUiType(List<SdkUiTypeEnum> sdkUiType) {
        this.sdkUiType = sdkUiType;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceRenderOptions deviceRenderOptions = (DeviceRenderOptions) o;
        return Objects.equals(this.sdkInterface, deviceRenderOptions.sdkInterface) && Objects.equals(this.sdkUiType, deviceRenderOptions.sdkUiType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sdkInterface, sdkUiType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeviceRenderOptions {\n");

        sb.append("    sdkInterface: ").append(toIndentedString(sdkInterface)).append("\n");
        sb.append("    sdkUiType: ").append(toIndentedString(sdkUiType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}



