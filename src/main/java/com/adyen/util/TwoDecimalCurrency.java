package com.adyen.util;

public class TwoDecimalCurrency implements Currency {
    public int getDecimalPlaces() {
        return 2;
    }
}
