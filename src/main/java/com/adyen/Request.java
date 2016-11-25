package com.adyen;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rikt on 8/10/16.
 */
public class Request {

    protected HashMap<String,String> items;
    protected HashMap<String,HashMap<String,String>> nestedItems;

    public HashMap<String, String> getItems() {
        return items;
    }

    public void setItems(HashMap<String, String> items) {
        this.items = items;
    }

    public HashMap<String, HashMap<String, String>> getNestedItems() {
        return nestedItems;
    }

    public void setNestedItems(HashMap<String, HashMap<String, String>> nestedItems) {
        this.nestedItems = nestedItems;
    }


    // define all request items



}
