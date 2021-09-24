package com.adyen.model.dispute.details;

import static com.adyen.util.Util.toIndentedString;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class DefenseReason {
    @SerializedName("defenseDocumentTypes")
    private DefenseDocumentType[] defenseDocumentTypes;
    @SerializedName("defenseReasonCode")
    private String defenseReasonCode;
    @SerializedName("satisfied")
    private boolean satisfied;
    public DefenseDocumentType[] getDefenseDocumentTypes() {
        return this.defenseDocumentTypes;
    }
    public void setDefenseDocumentTypes(DefenseDocumentType[] defenseDocumentTypes) {
        this.defenseDocumentTypes = defenseDocumentTypes;
    }
    public String getDefenseReasonCode() {
        return this.defenseReasonCode;
    }
    public void setDefenseReasonCode(String defenseReasonCode) {
        this.defenseReasonCode = defenseReasonCode;
    }
    public boolean isSatisfied() {
        return this.satisfied;
    }
    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefenseReason defenseReason = (DefenseReason) o;
        return Objects.equals(this.defenseDocumentTypes, defenseReason.defenseDocumentTypes) &&
            Objects.equals(this.defenseReasonCode, defenseReason.defenseReasonCode) &&
            Objects.equals(this.satisfied, defenseReason.satisfied);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.defenseDocumentTypes, this.defenseReasonCode, this.satisfied);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DefenseReason {\n");
        sb.append("    defenseDocumentTypes: [").append("\n");
        for (DefenseDocumentType ddt : this.defenseDocumentTypes) {
            sb.append("    ").append(toIndentedString(ddt)).append(",\n");
        }
        sb.append("    ").append(toIndentedString("]")).append("\n");
        sb.append("    defenseReasonCode: ").append(toIndentedString(this.defenseReasonCode)).append("\n");
        sb.append("    satisfied: ").append(toIndentedString(this.satisfied)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
