package com.adyen;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.adyen.model.applicationinfo.ApplicationInfo;
import org.junit.jupiter.api.Test;

public class ApplicationInfoTest {

  @Test
  public void TestApplicationInfoEquals() {
    ApplicationInfo applicationInfo = new ApplicationInfo();
    ApplicationInfo applicationInfo2 = new ApplicationInfo();

    assertEquals(applicationInfo, applicationInfo2);
  }

  @Test
  public void TestApplicationInfoPrefilledLibraryFields() {
    ApplicationInfo applicationInfo = new ApplicationInfo();

    assertNotNull(applicationInfo.getAdyenLibrary());
    assertNotNull(applicationInfo.getAdyenLibrary().getName());
    assertEquals(LIB_NAME, applicationInfo.getAdyenLibrary().getName());
    assertNotNull(applicationInfo.getAdyenLibrary().getVersion());
    assertEquals(LIB_VERSION, applicationInfo.getAdyenLibrary().getVersion());
  }
}
