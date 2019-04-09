package com.adyen;

import com.adyen.model.applicationinfo.ApplicationInfo;
import org.junit.Test;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApplicationInfoTest {

    @Test
    public void TestApplicationInfoEquals() {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        ApplicationInfo applicationInfo2 = new ApplicationInfo();

        assertEquals(applicationInfo, applicationInfo2);
        assertNotNull(applicationInfo.getAdyenLibrary());
        assertEquals(LIB_NAME, applicationInfo.getAdyenLibrary().getName());
        assertEquals(LIB_VERSION, applicationInfo.getAdyenLibrary().getVersion());
    }
}
