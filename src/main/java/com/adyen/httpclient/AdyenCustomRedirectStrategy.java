package com.adyen.httpclient;

import java.net.URI;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/**
 * Implements a custom redirect strategy when the API returns 308
 */
public class AdyenCustomRedirectStrategy extends DefaultRedirectStrategy {

  /**
   * Override getLocationURI to validate the location header
   * @param request the request
   * @param response the response
   * @param context the context
   * @return location url as URI
   * @throws HttpException an error has occurred
   */
  @Override
  public URI getLocationURI(HttpRequest request, HttpResponse response, HttpContext context)
      throws HttpException {
    URI uri = super.getLocationURI(request, response, context);

    int statusCode = response.getCode();
    if (statusCode == 308) {
      // validate 308 redirect
      if (!isVerifyLocation(uri.toString())) {
        throw new HttpException("Redirect location is invalid: " + uri);
      }
    }

    return uri;
  }

  /**
   * True when location header is valid
   *
   * @param location Value of the location header
   * @return true if valid
   */
  boolean isVerifyLocation(String location) {
    if (location == null) {
      return false;
    }
    try {
      URI uri = new URI(location);
      String host = uri.getHost();
      if (host == null) {
        return false;
      }
      String lowerCaseHost = host.toLowerCase();
      return lowerCaseHost.endsWith(".adyen.com") || lowerCaseHost.endsWith(".adyenpayments.com");
    } catch (java.net.URISyntaxException e) {
      return false;
    }
  }
}
