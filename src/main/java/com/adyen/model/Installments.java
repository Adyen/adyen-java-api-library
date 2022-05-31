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
package com.adyen.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * Installments
 */
public class Installments {
    /**
     * The installment plan, used for [card installments in Japan](https://docs.adyen.com/payment-methods/cards/credit-card-installments#make-a-payment-japan). By default, this is set to **regular**. Possible values: * **regular** * **revolving**
     */
    @JsonAdapter(PlanEnum.Adapter.class)
    public enum PlanEnum {
        REGULAR("regular"),
        REVOLVING("revolving");

        private String value;

        PlanEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static PlanEnum fromValue(String input) {
            for (PlanEnum b : PlanEnum.values()) {
                if (b.value.equals(input)) {
                    return b;
                }
            }
            return null;
        }
        public static class Adapter extends TypeAdapter<PlanEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PlanEnum enumeration) throws IOException {
                jsonWriter.value(String.valueOf(enumeration.getValue()));
            }

            @Override
            public PlanEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return PlanEnum.fromValue((String)(value));
            }
        }
    }  @SerializedName("plan")
    private PlanEnum plan = null;

    @SerializedName("value")
    private Integer value = null;

    public Installments plan(PlanEnum plan) {
        this.plan = plan;
        return this;
    }

    /**
     * The installment plan, used for [card installments in Japan](https://docs.adyen.com/payment-methods/cards/credit-card-installments#make-a-payment-japan). By default, this is set to **regular**. Possible values: * **regular** * **revolving**
     * @return plan
     **/
    @Schema(description = "The installment plan, used for [card installments in Japan](https://docs.adyen.com/payment-methods/cards/credit-card-installments#make-a-payment-japan). By default, this is set to **regular**. Possible values: * **regular** * **revolving** ")
    public PlanEnum getPlan() {
        return plan;
    }

    public void setPlan(PlanEnum plan) {
        this.plan = plan;
    }

    public Installments value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * the number of installments in which the payment will be divided
     *
     * @return value
     **/
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Installments installments = (Installments) o;
        return Objects.equals(this.plan, installments.plan) &&
                Objects.equals(this.value, installments.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plan, value);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Installments {\n");

        sb.append("    plan: ").append(toIndentedString(plan)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

