package com.adyen.model.dispute.details;

import static com.adyen.util.Util.toIndentedString;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

public class DefenseDocumentType {
    @SerializedName("available")
    private boolean available;
    @SerializedName("defenseDocumentTypeCode")
    private String defenseDocumentTypeCode;
    @SerializedName("requirementLevel")
    private String requirementLevel;
    public boolean isAvailable() {
        return this.available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getDefenseDocumentTypeCode() {
        return this.defenseDocumentTypeCode;
    }
    public void setDefenseDocumentTypeCode(String defenseDocumentTypeCode) {
        this.defenseDocumentTypeCode = defenseDocumentTypeCode;
    }
    public String getRequirementLevel() {
        return this.requirementLevel;
    }
    public void setRequirementLevel(String requirementLevel) {
        this.requirementLevel = requirementLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefenseDocumentType defenseDocumentType = (DefenseDocumentType) o;
        return Objects.equals(this.available, defenseDocumentType.available) &&
            Objects.equals(this.defenseDocumentTypeCode, defenseDocumentType.defenseDocumentTypeCode) &&
            Objects.equals(this.requirementLevel, defenseDocumentType.requirementLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.available, this.defenseDocumentTypeCode, this.requirementLevel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DefenseDocumentType {\n");
        sb.append("    available: ").append(toIndentedString(this.available)).append("\n");
        sb.append("    defenseDocumentTypeCode: ").append(toIndentedString(this.defenseDocumentTypeCode)).append("\n");
        sb.append("    requirementLevel: ").append(toIndentedString(this.requirementLevel)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
