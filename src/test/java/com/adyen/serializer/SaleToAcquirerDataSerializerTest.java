package com.adyen.serializer;

import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.applicationinfo.ExternalPlatform;
import com.adyen.model.applicationinfo.MerchantDevice;
import com.adyen.model.terminal.SaleToAcquirerData;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;
import java.util.Base64;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;

public class SaleToAcquirerDataSerializerTest {

    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void testSerialize()  {
        SaleToAcquirerDataSerializer saleToAcquirerDataModelAdapter = new SaleToAcquirerDataSerializer();
        SaleToAcquirerData saleToAcquirerData = new SaleToAcquirerData();

        Map<String, String> metadata = new HashMap<>();
        metadata.put("key", "value");
        saleToAcquirerData.setMetadata(metadata);
        saleToAcquirerData.setShopperEmail("myemail@mail.com");
        saleToAcquirerData.setShopperReference("13164308");
        saleToAcquirerData.setRecurringContract("RECURRING,ONECLICK");
        saleToAcquirerData.setShopperStatement("YOUR SHOPPER STATEMENT");
        saleToAcquirerData.setRecurringDetailName("VALUE");
        saleToAcquirerData.setRecurringTokenService("VALUE");
        saleToAcquirerData.setStore("store value");
        saleToAcquirerData.setMerchantAccount("merchantAccount");
        saleToAcquirerData.setCurrency("EUR");

        ApplicationInfo applicationInfo = new ApplicationInfo();

        ExternalPlatform externalPlatform = new ExternalPlatform();
        externalPlatform.setIntegrator("externalPlatformIntegrator");
        externalPlatform.setName("externalPlatformName");
        externalPlatform.setVersion("2.0.0");
        applicationInfo.setExternalPlatform(externalPlatform);
        
        MerchantDevice merchantDevice = new MerchantDevice();
        merchantDevice.setOs("merchantDeviceOS");
        merchantDevice.setOsVersion("10.12.6");
        merchantDevice.setReference("4c32759faaa7");
        applicationInfo.setMerchantDevice(merchantDevice);

        saleToAcquirerData.setApplicationInfo(applicationInfo);
        saleToAcquirerData.setTenderOption("ReceiptHandler,AllowPartialAuthorisation,AskGratuity");

        Map<String, String> additionalData = new HashMap<>();
        additionalData.put("key.key", "value");
        additionalData.put("key.keyTwo", "value2");
        saleToAcquirerData.setAdditionalData(additionalData);
        saleToAcquirerData.setAuthorisationType("authorisationType");
        
        String json = "{\n" +
                "  \"metadata\": {\n" +
                "    \"key\": \"value\"\n" +
                "  },\n" +
                "  \"shopperEmail\": \"myemail@mail.com\",\n" +
                "  \"shopperReference\": \"13164308\",\n" +
                "  \"recurringContract\": \"RECURRING,ONECLICK\",\n" +
                "  \"shopperStatement\": \"YOUR SHOPPER STATEMENT\",\n" +
                "  \"recurringDetailName\": \"VALUE\",\n" +
                "  \"recurringTokenService\": \"VALUE\",\n" +
                "  \"store\": \"store value\",\n" +
                "  \"merchantAccount\": \"merchantAccount\",\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"applicationInfo\": {\n" +
                "    \"adyenLibrary\": {\n" +
                "      \"name\": \""+ LIB_NAME + "\",\n" +
                "      \"version\": \""+ LIB_VERSION + "\"\n" +
                "    },\n" +
                "    \"externalPlatform\": {\n" +
                "      \"integrator\": \"externalPlatformIntegrator\",\n" +
                "      \"name\": \"externalPlatformName\",\n" +
                "      \"version\": \"2.0.0\"\n" +
                "    },\n" +
                "    \"merchantDevice\": {\n" +
                "      \"os\": \"merchantDeviceOS\",\n" +
                "      \"osVersion\": \"10.12.6\",\n" +
                "      \"reference\": \"4c32759faaa7\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"tenderOption\": \"ReceiptHandler,AllowPartialAuthorisation,AskGratuity\",\n" +
                "  \"additionalData\": {\n" +
                "    \"key.keyTwo\": \"value2\",\n" +
                "    \"key.key\": \"value\"\n" +
                "  },\n" +
                "  \"authorisationType\": \"authorisationType\"\n" +
                "}";

        // test if json string matches
        String requestJson = PRETTY_PRINT_GSON.toJson(saleToAcquirerData);
        assertJsonStringEquals(requestJson, json);
        
        // test if base64 works
        String serialized = saleToAcquirerDataModelAdapter.serialize(saleToAcquirerData, null, null).getAsString();
        SaleToAcquirerData saleToAcquirerDataDecoded = new Gson().fromJson(new String(Base64.getDecoder().decode(serialized)), SaleToAcquirerData.class);
        assertEquals(saleToAcquirerData, saleToAcquirerDataDecoded);
    }

    public static void assertJsonStringEquals(String firstInput, String secondInput) {
        JsonParser parser = new JsonParser();
        assertEquals(parser.parse(firstInput), parser.parse(secondInput));
    }
}
