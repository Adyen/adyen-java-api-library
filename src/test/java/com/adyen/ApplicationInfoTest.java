package com.adyen;

import org.junit.Test;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.applicationinfo.CommonField;
import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertTrue;

public class ApplicationInfoTest {

    @Test
    public void TestApplicationInfoEquals() {

        CommonField adyenLibrary = new CommonField();
        adyenLibrary.setName(LIB_NAME);
        adyenLibrary.setVersion(LIB_VERSION);

        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.setAdyenLibrary(adyenLibrary);

        ApplicationInfo applicationInfo2 = new ApplicationInfo();
        applicationInfo2.setAdyenLibrary(adyenLibrary);

        assertTrue(applicationInfo.equals(applicationInfo2));
    }
}
