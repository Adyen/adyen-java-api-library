/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaskUtilTest {

    @Test
    public void TestMaskWithFixedSize() {
        assertEquals("****", MaskUtil.mask("StringToMask"));
    }

    @Test
    public void TestMaskWithFixedSizeWithEmptyString() {
        assertEquals("", MaskUtil.mask(""));
    }

    @Test
    public void TestMaskCardNumber() {
        assertEquals("************3456", MaskUtil.maskCardNumber("1234567890123456"));
    }

    @Test
    public void TestMaskCardNumberWithHyphens() {
        assertEquals("************3456", MaskUtil.maskCardNumber("1234-5678-9012-3456"));
    }

    @Test
    public void TestMaskCardNumberWithNull() {
        assertEquals("", MaskUtil.maskCardNumber(null));
    }

    @Test
    public void TestMaskCardNumberWithEmptyString() {
        assertEquals("", MaskUtil.maskCardNumber(""));
    }

    @Test
    public void TestMaskCardNumberWithTooShortCardNumber() {
        assertEquals("", MaskUtil.maskCardNumber("123"));
    }
}
