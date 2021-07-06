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

import com.adyen.model.management.links.ApiCredentialLinks;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * ApiCredential
 */

public class ApiCredential {
    @SerializedName("_links")
    @JsonProperty("_links")
    private ApiCredentialLinks links = null;

    @SerializedName("active")
    private Boolean active = null;

    @SerializedName("allowedIpAddresses")
    private List<String> allowedIpAddresses = null;

    @SerializedName("allowedOrigins")
    private List<AllowedOrigin> allowedOrigins = null;

    @SerializedName("clientKey")
    private String clientKey = null;

    @SerializedName("id")
    private String id = null;

    @SerializedName("roles")
    private List<String> roles = null;

    @SerializedName("username")
    private String username = null;

    public ApiCredential links(ApiCredentialLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    public ApiCredentialLinks getLinks() {
        return links;
    }

    public void setLinks(ApiCredentialLinks links) {
        this.links = links;
    }

    public ApiCredential active(Boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Flag indicating whether this API Credential is active.
     *
     * @return active
     **/
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ApiCredential allowedIpAddresses(List<String> allowedIpAddresses) {
        this.allowedIpAddresses = allowedIpAddresses;
        return this;
    }

    public ApiCredential addAllowedIpAddressesItem(String allowedIpAddressesItem) {
        if (this.allowedIpAddresses == null) {
            this.allowedIpAddresses = new ArrayList<>();
        }
        this.allowedIpAddresses.add(allowedIpAddressesItem);
        return this;
    }

    /**
     * List of allowed IP addresses allowed for this API Credential.
     *
     * @return allowedIpAddresses
     **/
    public List<String> getAllowedIpAddresses() {
        return allowedIpAddresses;
    }

    public void setAllowedIpAddresses(List<String> allowedIpAddresses) {
        this.allowedIpAddresses = allowedIpAddresses;
    }

    public ApiCredential allowedOrigins(List<AllowedOrigin> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
        return this;
    }

    public ApiCredential addAllowedOriginsItem(AllowedOrigin allowedOriginsItem) {
        if (this.allowedOrigins == null) {
            this.allowedOrigins = new ArrayList<>();
        }
        this.allowedOrigins.add(allowedOriginsItem);
        return this;
    }

    /**
     * List of allowed origins for this API Credential.
     *
     * @return allowedOrigins
     **/
    public List<AllowedOrigin> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<AllowedOrigin> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public ApiCredential clientKey(String clientKey) {
        this.clientKey = clientKey;
        return this;
    }

    /**
     * The client key for this API Credential.
     *
     * @return clientKey
     **/
    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public ApiCredential id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The id for this API Credential.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ApiCredential roles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public ApiCredential addRolesItem(String rolesItem) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * List roles configured for this API Credential.
     *
     * @return roles
     **/
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public ApiCredential username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The user name for this API Credential.
     *
     * @return username
     **/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiCredential apiCredential = (ApiCredential) o;
        return Objects.equals(this.links, apiCredential.links) &&
                Objects.equals(this.active, apiCredential.active) &&
                Objects.equals(this.allowedIpAddresses, apiCredential.allowedIpAddresses) &&
                Objects.equals(this.allowedOrigins, apiCredential.allowedOrigins) &&
                Objects.equals(this.clientKey, apiCredential.clientKey) &&
                Objects.equals(this.id, apiCredential.id) &&
                Objects.equals(this.roles, apiCredential.roles) &&
                Objects.equals(this.username, apiCredential.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, active, allowedIpAddresses, allowedOrigins, clientKey, id, roles, username);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiCredential {\n");

        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    active: ").append(toIndentedString(active)).append("\n");
        sb.append("    allowedIpAddresses: ").append(toIndentedString(allowedIpAddresses)).append("\n");
        sb.append("    allowedOrigins: ").append(toIndentedString(allowedOrigins)).append("\n");
        sb.append("    clientKey: ").append(toIndentedString(clientKey)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
