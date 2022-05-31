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
 */
package com.adyen.model.applicationinfo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

public class ExternalPlatform extends CommonField {

    @SerializedName("integrator")
    private String integrator = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("version")
    private String version = null;

    public String getIntegrator() {
        return integrator;
    }

    public void setIntegrator(String integrator) {
        this.integrator = integrator;
    }

    public ExternalPlatform name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the field. For example, Name of External Platform.
     * @return name
     **/
    @Schema(description = "Name of the field. For example, Name of External Platform.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExternalPlatform version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Version of the field. For example, Version of External Platform.
     * @return version
     **/
    @Schema(description = "Version of the field. For example, Version of External Platform.")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExternalPlatform externalPlatform = (ExternalPlatform) o;
        return Objects.equals(this.integrator, externalPlatform.integrator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integrator, name, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExternalPlatform {\n");

        sb.append("    integrator: ").append(toIndentedString(integrator)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("}");
        return sb.toString();
    }




}
