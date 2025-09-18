package com.adyen.httpclient;

import java.net.URI;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.core5.http.Header;
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
   * @return
   * @throws HttpException an error has occurred
   */
  @Override
  public URI getLocationURI(HttpRequest request, HttpResponse response, HttpContext context)
      throws HttpException {
    URI uri = super.getLocationURI(request, response, context);

    int statusCode = response.getCode();
    if (statusCode == 308) {
      // validate 308 redirect
      Header locationHeader = response.getFirstHeader("Location");
      if (locationHeader == null) {
        throw new HttpException("Redirect location is missing");
      }
      if (!isVerifyLocation(locationHeader.getValue())) {
        throw new HttpException("Redirect location is invalid: " + locationHeader.getValue());
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
    location = location.toLowerCase();
    return location.contains(".adyen.com") || location.contains(".adyenpayments.com");
  }

}
