package com.adyen.serializer;

import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.applicationinfo.ExternalPlatform;
import com.adyen.model.applicationinfo.MerchantDevice;
import com.adyen.model.terminal.SaleToAcquirerDataModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;

public class SaleToAcquirerDataModelAdapterSerializerTest {

    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void testSerialize()  {
        SaleToAcquirerDataModelAdapterSerializer saleToAcquirerDataModelAdapter = new SaleToAcquirerDataModelAdapterSerializer();
        SaleToAcquirerDataModel saleToAcquirerDataModel = new SaleToAcquirerDataModel();

        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("key", "value");
        saleToAcquirerDataModel.setMetadata(metadata);
        saleToAcquirerDataModel.setShopperEmail("myemail@mail.com");
        saleToAcquirerDataModel.setShopperReference("13164308");
        saleToAcquirerDataModel.setRecurringContract("RECURRING,ONECLICK");
        saleToAcquirerDataModel.setShopperStatement("YOUR SHOPPER STATEMENT");
        saleToAcquirerDataModel.setRecurringDetailName("VALUE");
        saleToAcquirerDataModel.setRecurringTokenService("VALUE");
        saleToAcquirerDataModel.setStore("store value");
        saleToAcquirerDataModel.setMerchantAccount("merchantAccount");
        saleToAcquirerDataModel.setCurrency("EUR");

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

        saleToAcquirerDataModel.setApplicationInfo(applicationInfo);
        saleToAcquirerDataModel.setTenderOption("ReceiptHandler,AllowPartialAuthorisation,AskGratuity");

        Map<String, String> additionalData = new HashMap<String, String>();
        additionalData.put("key.key", "value");
        additionalData.put("key.keyTwo", "value2");
        saleToAcquirerDataModel.setAdditionalData(additionalData);
        
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
                "  }\n" +
                "}";

        // test if json string matches
        String requestJson = PRETTY_PRINT_GSON.toJson(saleToAcquirerDataModel);
        assertEquals(requestJson, json);
        
        // test if base64 works
        String jsonBase64 = new String(Base64.encodeBase64(json.getBytes()));
        assertEquals(jsonBase64, saleToAcquirerDataModelAdapter.serialize(saleToAcquirerDataModel, null, null).getAsString());
    }
}
