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

import java.util.List;

public class CreateTestCardRangesResult {
    List<TestCardRangeCreationResultWrapper> rangeCreationResults = null;

    public List<TestCardRangeCreationResultWrapper> getRangeCreationResults() {
        return rangeCreationResults;
    }

    public void setRangeCreationResults(List<TestCardRangeCreationResultWrapper> rangeCreationResults) {
        this.rangeCreationResults = rangeCreationResults;
    }

    @Override
    public String toString() {
        return "CreateTestCardRangesResult{" +
                "rangeCreationResults=" + rangeCreationResults +
                '}';
    }
}
