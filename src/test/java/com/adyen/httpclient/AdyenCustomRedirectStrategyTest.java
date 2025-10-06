package com.adyen.httpclient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.net.URI;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdyenCustomRedirectStrategyTest {

  private final AdyenCustomRedirectStrategy redirectStrategy = new AdyenCustomRedirectStrategy();

  @Mock private HttpRequest request;
  @Mock private HttpResponse response;
  @Mock private HttpContext context;
  @Mock private Header locationHeader;

  @Test
  public void testIsVerifyLocationAdyenDomain() {
    assertTrue(redirectStrategy.isVerifyLocation("https://test.adyen.com/redirect"));
  }

  @Test
  public void testIsVerifyLocationAdyenPaymentsDomain() {
    assertTrue(redirectStrategy.isVerifyLocation("https://test.adyenpayments.com/redirect"));
  }

  @Test
  public void testIsVerifyLocationMixedCase() {
    assertTrue(redirectStrategy.isVerifyLocation("https://TEST.ADYEN.COM/redirect"));
  }

  @Test
  public void testIsVerifyLocationInvalidDomain() {
    assertFalse(redirectStrategy.isVerifyLocation("https://example.com/redirect"));
  }

  @Test
  public void testIsVerifyLocationMaliciousDomain() {
    assertFalse(redirectStrategy.isVerifyLocation("https://adyen.com.evil.com"));
    assertFalse(redirectStrategy.isVerifyLocation("https://evil.com?q=.adyen.com"));
    assertFalse(redirectStrategy.isVerifyLocation("https://evil.com/.adyen.com"));
  }

  @Test
  public void testIsVerifyLocationEmpty() {
    assertFalse(redirectStrategy.isVerifyLocation(""));
  }

  @Test
  public void testGetLocationURI308AdyenDomain() throws HttpException {
    when(response.getCode()).thenReturn(308);
    when(response.getFirstHeader("Location")).thenReturn(locationHeader);
    when(locationHeader.getValue()).thenReturn("https://api.adyen.com");

    URI uri = redirectStrategy.getLocationURI(request, response, context);
    assertEquals("https://api.adyen.com/", uri.toString());
  }

  @Test
  public void testGetLocationURI308AdyenPaymentsDomain() throws HttpException {
    when(response.getCode()).thenReturn(308);
    when(response.getFirstHeader("Location")).thenReturn(locationHeader);
    when(locationHeader.getValue()).thenReturn("https://api.adyenpayments.com");

    URI uri = redirectStrategy.getLocationURI(request, response, context);
    assertEquals("https://api.adyenpayments.com/", uri.toString());
  }

  @Test
  public void testGetLocationURI308InvadidDomainThrowsException() {
    when(response.getCode()).thenReturn(308);
    when(response.getFirstHeader("Location")).thenReturn(locationHeader);
    String location = "https://test.example.com/";
    when(locationHeader.getValue()).thenReturn(location);

    try {
      redirectStrategy.getLocationURI(request, response, context);
      fail("Expected HttpException was not thrown");
    } catch (HttpException e) {
      assertEquals("Redirect location is invalid: " + location, e.getMessage());
    }
  }
}
