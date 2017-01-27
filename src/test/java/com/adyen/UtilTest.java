package com.adyen;

import com.adyen.Util.Util;
import com.adyen.model.Amount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Util class
 */
public class UtilTest {
    @Test
    public void testAmountDecimals() {
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(new Long("1000"));

        assertEquals(0, new BigDecimal("10.00").compareTo(amount.getDecimalValue()));
    }

    @Test
    public void testCreateAmount() {
        Amount amount = Util.createAmount("12.34", "EUR");

        assertEquals(0, new Long("1234").compareTo(amount.getValue()));
    }
}
