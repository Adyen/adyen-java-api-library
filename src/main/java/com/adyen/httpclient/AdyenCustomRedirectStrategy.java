package com.adyen.httpclient;

import java.net.URI;
import java.util.Locale;
import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

/** Implements a custom redirect strategy that only follows secure Adyen API redirects. */
public class AdyenCustomRedirectStrategy extends DefaultRedirectStrategy {

  /**
   * Override getLocationURI to validate the location header
   *
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

    if (!isVerifyLocation(uri)) {
      throw new HttpException("Redirect location is invalid: " + uri);
    }

    return uri;
  }

  /**
   * True when location header targets an HTTPS Adyen API domain.
   *
   * @param location Value of the location header
   * @return true if valid
   */
  boolean isVerifyLocation(String location) {
    if (location == null) {
      return false;
    }
    try {
      return isVerifyLocation(new URI(location));
    } catch (java.net.URISyntaxException e) {
      return false;
    }
  }

  private boolean isVerifyLocation(URI uri) {
    if (!"https".equalsIgnoreCase(uri.getScheme())) {
      return false;
    }
    String host = uri.getHost();
    if (host == null) {
      return false;
    }
    String lowerCaseHost = host.toLowerCase(Locale.ROOT);
    if (lowerCaseHost.endsWith(".")) {
      lowerCaseHost = lowerCaseHost.substring(0, lowerCaseHost.length() - 1);
    }
    return lowerCaseHost.equals("adyen.com")
        || lowerCaseHost.endsWith(".adyen.com")
        || lowerCaseHost.equals("adyenpayments.com")
        || lowerCaseHost.endsWith(".adyenpayments.com");
  }
}
