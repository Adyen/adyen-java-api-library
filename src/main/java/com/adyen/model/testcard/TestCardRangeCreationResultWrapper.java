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
package com.adyen.model.testcard;

import com.google.gson.annotations.SerializedName;

public class TestCardRangeCreationResultWrapper {

    @SerializedName("TestCardRangeCreationResult")
    private TestCardRangeCreationResult testCardRangeCreationResult = null;

    public TestCardRangeCreationResult getTestCardRangeCreationResult() {
        return testCardRangeCreationResult;
    }

    public void setTestCardRangeCreationResult(TestCardRangeCreationResult testCardRangeCreationResult) {
        this.testCardRangeCreationResult = testCardRangeCreationResult;
    }

    @Override
    public String toString() {
        return "TestCardRangeCreationResultWrapper{" +
                "testCardRangeCreationResult=" + testCardRangeCreationResult +
                '}';
    }
}
