package com.adyen.httpclient;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpURLConnectionClient implements ClientInterface {

    private static final String CHARSET = "UTF-8";

    /**
     * Does a POST request.
     * config is used to obtain basic auth username, password and User-Agent
     *
     * @param requestUrl
     * @param requestBody
     * @param config
     * @return
     * @throws IOException
     */
    public String request(String requestUrl, String requestBody, Config config) throws IOException, HTTPClientException {
        String response = "";

        URL targetUrl = new URL(requestUrl);

        // set configurations
        HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
        httpConnection.setUseCaches(false);
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("POST");

        // set headers
        httpConnection.setRequestProperty("Content-Type", "application/json");
        httpConnection.setRequestProperty("Accept-Charset", CHARSET);
        httpConnection.setRequestProperty("User-Agent",
                String.format("%s %s%s", config.getApplicationName(), Client.USER_AGENT_SUFFIX, Client.LIB_VERSION));

        // set basic authentication
        String authString = config.getUsername() + ":" + config.getPassword();
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        httpConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);

        OutputStream outputStream = httpConnection.getOutputStream();
        outputStream.write(requestBody.getBytes());
        outputStream.flush();

        int responseCode = httpConnection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            //Read the response from the error stream
            response = getResponseBody(httpConnection.getErrorStream());

            HTTPClientException httpClientException = new HTTPClientException(
                    responseCode,
                    "HTTP Exception",
                    httpConnection.getHeaderFields(),
                    response
            );

            throw httpClientException;
        }

        //InputStream is only available on successful requests >= 200 <400
        response = getResponseBody(httpConnection.getInputStream());
        //TODO: replace with logger
        System.out.println(response);

        // close the connection
        httpConnection.disconnect();

        return response;
    }

    /**
     * Does a request using Map<String, Object> as input/output
     *
     * @param service
     * @param requestUrl
     * @param params
     * @return
     */
    @SuppressWarnings("serial")
    public Map<String, Object> requestJson(Service service,
                                           String requestUrl,
                                           Map<String, Object> params) {

        Map<String, Object> json = new HashMap<String, Object>();

        Client client = service.getClient();
        Config config = client.getConfig();

        try {
            // convert parameters to JSON
            Gson gson = new GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .create();
            String input = gson.toJson(params);

            String result = request(requestUrl, input, config);

            // convert back to HashMap
            json = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String getResponseBody(InputStream responseStream)
            throws IOException {
        //\A is the beginning of the stream boundary
        Scanner scanner = new Scanner(responseStream, CHARSET);
        scanner.useDelimiter("\\A");
        String rBody = scanner.useDelimiter("\\A").next();
        scanner.close();
        responseStream.close();
        return rBody;
    }
}
