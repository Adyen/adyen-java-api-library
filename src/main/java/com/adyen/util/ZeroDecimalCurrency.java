package com.adyen.util;

public class ZeroDecimalCurrency implements Currency {
    public int getDecimalPlaces() {
        return 0;
    }
}
