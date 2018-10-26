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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.httpclient;

import com.adyen.Config;
import com.adyen.model.RequestOptions;

import java.io.IOException;
import java.util.Map;

public interface ClientInterface {

    String request(String endpoint, String json, Config config) throws IOException, HTTPClientException;
    String request(String endpoint, String json, Config config, boolean isApiKeyRequired) throws IOException, HTTPClientException;
    String request(String endpoint, String json, Config config, boolean isApiKeyRequired, RequestOptions requestOptions) throws IOException, HTTPClientException;

    String post(String endpoint, Map<String, String> postParameters, Config config) throws IOException, HTTPClientException;
}
