package com.adyen;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rikt on 8/10/16.
 */
public class GsonTest extends BaseTest {

    @Test
    public void TestGson() {



//        Gson gson = new Gson();
//        Gson gson = new GsonBuilder()
//                .enableComplexMapKeySerialization()
//                .create();
//
//
//        RequestTest test = new RequestTest();
//
//
//        HashMap<String,String> items = new HashMap<String, String>();
//        items.put("currency","EUR");
//        items.put("value","100000");
//
//
//        HashMap<String, HashMap<String,String>> allItems = new HashMap<String, HashMap<String, String>>();
//        allItems.put("amount", items);
//
//
//        test.setItems(allItems);
//
//        test.setSimpleItems(items);
//
//
//        String json1 = gson.toJson(test, RequestTest.class);
//
//        String json2 = gson.toJson(test.getSimpleItems());
//
////        String json = gson.toJson(items, RequestTest.class);
//
//
//        System.out.println("HEIR");
//        System.out.println(json1);
//
//        System.out.println("HEIR");
//
//        System.out.println(json2);



        Request request = new Request();

        HashMap<String,String> topLevelItems = new HashMap<String, String>();
        topLevelItems.put("merchantAccount", "MagentoMerchantRik");
        topLevelItems.put("reference", "1000000");

        request.setItems(topLevelItems);



        HashMap<String, HashMap<String,String>> nestedItems = new HashMap<String, HashMap<String, String>>();

        HashMap<String,String> amount = new HashMap<String, String>();
        amount.put("currency", "EUR");
        amount.put("value", "10000");
        nestedItems.put("amount", amount);
        request.setNestedItems(nestedItems);


        String result = new Gson().toJson(request.items);
        String result2 = new Gson().toJson(request.nestedItems);


        Map firstObject = new Gson().fromJson(result, HashMap.class);
        Map secondObject = new Gson().fromJson(result2, HashMap.class);

        HashMap resultMap = new HashMap();
        resultMap.putAll(firstObject);
        resultMap.putAll(secondObject);

        String resultJson = new Gson().toJson(resultMap);
        System.out.println(resultJson);


    }





}
