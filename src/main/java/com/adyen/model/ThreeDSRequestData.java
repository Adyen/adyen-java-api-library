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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Objects;

public class ThreeDSRequestData {
    /**
     * Indicates if [native 3D Secure authentication](https://docs.adyen.com/online-payments/3d-secure/native-3ds2) should be used when available.  Possible values: * **preferred**: Use native 3D Secure authentication when available.
     */
    @JsonAdapter(NativeThreeDSEnum.Adapter.class)
    public enum NativeThreeDSEnum {
        PREFERRED("preferred");

        private final String value;

        NativeThreeDSEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static NativeThreeDSEnum fromValue(String input) {
            for (NativeThreeDSEnum b : NativeThreeDSEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<NativeThreeDSEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final NativeThreeDSEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public NativeThreeDSEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return NativeThreeDSEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("nativeThreeDS")
    private NativeThreeDSEnum nativeThreeDS = null;

    /**
     * The version of 3D Secure to use.  Possible values:  * **2.1.0** * **2.2.0**
     */
    @JsonAdapter(ThreeDSVersionEnum.Adapter.class)
    public enum ThreeDSVersionEnum {
        _1_0("2.1.0"),
        _2_0("2.2.0");

        private final String value;

        ThreeDSVersionEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static ThreeDSVersionEnum fromValue(String input) {
            for (ThreeDSVersionEnum b : ThreeDSVersionEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<ThreeDSVersionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ThreeDSVersionEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public ThreeDSVersionEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return ThreeDSVersionEnum.fromValue((String) (value));
            }
        }
    }  @SerializedName("threeDSVersion")
    private ThreeDSVersionEnum threeDSVersion = null;

    public ThreeDSRequestData nativeThreeDS(NativeThreeDSEnum nativeThreeDS) {
        this.nativeThreeDS = nativeThreeDS;
        return this;
    }

    /**
     * Indicates if [native 3D Secure authentication](https://docs.adyen.com/online-payments/3d-secure/native-3ds2) should be used when available.  Possible values: * **preferred**: Use native 3D Secure authentication when available.
     * @return nativeThreeDS
     **/
    @Schema(description = "Indicates if [native 3D Secure authentication](https://docs.adyen.com/online-payments/3d-secure/native-3ds2) should be used when available.  Possible values: * **preferred**: Use native 3D Secure authentication when available.")
    public NativeThreeDSEnum getNativeThreeDS() {
        return nativeThreeDS;
    }

    public void setNativeThreeDS(NativeThreeDSEnum nativeThreeDS) {
        this.nativeThreeDS = nativeThreeDS;
    }

    public ThreeDSRequestData threeDSVersion(ThreeDSVersionEnum threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
        return this;
    }

    /**
     * The version of 3D Secure to use.  Possible values:  * **2.1.0** * **2.2.0**
     * @return threeDSVersion
     **/
    @Schema(description = "The version of 3D Secure to use.  Possible values:  * **2.1.0** * **2.2.0**")
    public ThreeDSVersionEnum getThreeDSVersion() {
        return threeDSVersion;
    }

    public void setThreeDSVersion(ThreeDSVersionEnum threeDSVersion) {
        this.threeDSVersion = threeDSVersion;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThreeDSRequestData threeDSRequestData = (ThreeDSRequestData) o;
        return Objects.equals(this.nativeThreeDS, threeDSRequestData.nativeThreeDS) &&
                Objects.equals(this.threeDSVersion, threeDSRequestData.threeDSVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nativeThreeDS, threeDSVersion);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThreeDSRequestData {\n");

        sb.append("    nativeThreeDS: ").append(toIndentedString(nativeThreeDS)).append("\n");
        sb.append("    threeDSVersion: ").append(toIndentedString(threeDSVersion)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
