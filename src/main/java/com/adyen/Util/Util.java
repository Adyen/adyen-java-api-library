package com.adyen.Util;

import java.util.Iterator;
import java.util.List;

public class Util {


    public static <T> String implode(String glue, List<T> list) {
        // list is empty, return empty string
        if (list == null || list.isEmpty()) {
            return "";
        }

        Iterator<T> iter = list.iterator();

        // init the builder with the first element
        StringBuilder sb = new StringBuilder();
        sb.append(iter.next());

        // concat each element
        while (iter.hasNext()) {
            sb.append(glue).append(iter.next());
        }

        // return result
        return sb.toString();
    }

}
