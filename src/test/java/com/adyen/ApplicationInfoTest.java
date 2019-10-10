package com.adyen;

import org.junit.Test;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.terminal.SaleToAcquirerDataModel;
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

    @Test
    public void TestApplicationInfoPrefilledSaleToAcquirerDataModel() {

        SaleToAcquirerDataModel saleToAcquirerDataModel = new SaleToAcquirerDataModel();
        String applicationInfoExpected = "{\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \""+LIB_NAME+"\",\n"
                + "      \"version\": \""+LIB_VERSION+"\"\n"
                + "    }\n"
                + "  }\n"
                + "}";
        String applicationInfoJson = saleToAcquirerDataModel.toJson();
        assertEquals(applicationInfoJson, applicationInfoExpected);
    }
}
