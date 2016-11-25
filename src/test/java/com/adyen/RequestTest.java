package com.adyen;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rikt on 8/10/16.
 */
public class RequestTest {


    protected HashMap<String,String> simpleItems;

    protected HashMap<String,HashMap<String,String>> items;

    public HashMap<String, String> getSimpleItems() {
        return simpleItems;
    }

    public void setSimpleItems(HashMap<String, String> simpleItems) {
        this.simpleItems = simpleItems;
    }

    public HashMap<String, HashMap<String, String>> getItems() {
        return items;
    }

    public void setItems(HashMap<String, HashMap<String, String>> items) {
        this.items = items;
    }
}
