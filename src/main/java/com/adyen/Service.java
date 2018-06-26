/**
 * ######
 * ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 * ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 * ############   ############  #############   ############  #####  ######
 * ######
 * #############
 * ############
 * <p>
 * Adyen Java API Library
 * <p>
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.google.gson.Gson;

public class Service {

    protected static final Gson GSON = new Gson();
    protected boolean isApiKeySupported = false;
    private Client client;

    protected Service(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isApiKeySupported() {  return isApiKeySupported; }

    public void setApiKeySupported(boolean apiKeySupported) { isApiKeySupported = apiKeySupported; }

}
