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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.terminal.serialization;

import com.adyen.model.nexo.AuthenticatedData;
import com.adyen.model.nexo.KEK;
import com.adyen.model.nexo.KeyTransport;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gson {@link TypeAdapterFactory} for {@link com.adyen.model.nexo.AuthenticatedData}.
 *
 * <p>Handles polymorphic deserialization of the {@code keyTransportOrKEK} list by inspecting each
 * element's fields: items containing {@code KEKIdentifier} are deserialized as {@link
 * com.adyen.model.nexo.KEK}, all others as {@link com.adyen.model.nexo.KeyTransport}. Serialization
 * is delegated to Gson's default behavior.
 */
public class AuthenticatedDataTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!AuthenticatedData.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        TypeAdapter<AuthenticatedData> delegate =
                gson.getDelegateAdapter(this, TypeToken.get(AuthenticatedData.class));
        TypeAdapter<JsonObject> jsonObjectAdapter = gson.getAdapter(JsonObject.class);

        return (TypeAdapter<T>)
                new TypeAdapter<AuthenticatedData>() {
                    @Override
                    public void write(JsonWriter out, AuthenticatedData value) throws IOException {
                        delegate.write(out, value);
                    }

                    @Override
                    public AuthenticatedData read(JsonReader in) throws IOException {
                        JsonObject jsonObject = jsonObjectAdapter.read(in);

                        JsonArray keyTransportOrKEKArray = null;
                        if (jsonObject.has("keyTransportOrKEK")) {
                            keyTransportOrKEKArray = jsonObject.getAsJsonArray("keyTransportOrKEK");
                            jsonObject.remove("keyTransportOrKEK");
                        }
                        AuthenticatedData result = delegate.fromJsonTree(jsonObject);
                        if (keyTransportOrKEKArray != null) {
                            for (JsonElement element : keyTransportOrKEKArray) {
                                JsonObject item = element.getAsJsonObject();
                                if (item.has("KEKIdentifier")) {
                                    result.getKeyTransportOrKEK().add(gson.fromJson(item, KEK.class));
                                } else {
                                    result.getKeyTransportOrKEK().add(gson.fromJson(item, KeyTransport.class));
                                }
                            }
                        }
                        return result;
                    }
                };
    }
}
