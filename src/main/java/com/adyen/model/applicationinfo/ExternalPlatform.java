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

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

public class ExternalPlatform extends CommonField {

    @SerializedName("integrator")
    private String integrator = null;

    public String getIntegrator() {
        return integrator;
    }

    public void setIntegrator(String integrator) {
        this.integrator = integrator;
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
        return Objects.hash(integrator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExternalPlatform {\n");

        sb.append("    integrator: ").append(toIndentedString(integrator)).append("\n");
        sb.append("}");
        return sb.toString();
    }




}
