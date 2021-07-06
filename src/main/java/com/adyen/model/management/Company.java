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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.management;
import com.adyen.model.management.links.CompanyLinks;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.adyen.util.Util.toIndentedString;

public class Company {
    @SerializedName("_links")
    @JsonProperty("_links")
    private CompanyLinks links = null;

    @SerializedName("dataCenters")
    private List<DataCenter> dataCenters = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("status")
    private String status = null;

    public Company links(CompanyLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     * @return links
     **/
    public CompanyLinks getLinks() {
        return links;
    }

    public void setLinks(CompanyLinks links) {
        this.links = links;
    }

    public Company dataCenters(List<DataCenter> dataCenters) {
        this.dataCenters = dataCenters;
        return this;
    }

    public Company addDataCentersItem(DataCenter dataCentersItem) {
        if (this.dataCenters == null) {
            this.dataCenters = new ArrayList<DataCenter>();
        }
        this.dataCenters.add(dataCentersItem);
        return this;
    }

    /**
     * Data centers for the company account.
     * @return dataCenters
     **/
    public List<DataCenter> getDataCenters() {
        return dataCenters;
    }

    public void setDataCenters(List<DataCenter> dataCenters) {
        this.dataCenters = dataCenters;
    }

    public Company id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id of the company.
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Company name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the company.
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company status(String status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the company account.
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(this.links, company.links) &&
                Objects.equals(this.dataCenters, company.dataCenters) &&
                Objects.equals(this.id, company.id) &&
                Objects.equals(this.name, company.name) &&
                Objects.equals(this.status, company.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, dataCenters, id, name, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Company {\n");

        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    dataCenters: ").append(toIndentedString(dataCenters)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
