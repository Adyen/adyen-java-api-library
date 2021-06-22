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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.management;

import com.adyen.constants.ApiConstants;

import java.util.HashMap;
import java.util.Map;

public class Options {
    private Integer pageNumber;
    private Integer pageSize;

    public Options(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Options() {
        this.pageNumber = ApiConstants.Pagination.DEFAULT_PAGE_NUMBER;
        this.pageSize = ApiConstants.Pagination.DEFAULT_PAGE_SIZE;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Options pageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Options pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, String> getOptionsMap() {
        Map<String, String> optionsMap = new HashMap<>();
        if (this.pageSize != null) {
            optionsMap.put("pageSize", String.valueOf(this.pageSize));
        }

        if (this.pageNumber != null) {
            optionsMap.put("pageNumber", String.valueOf(this.pageNumber));
        }

        return optionsMap;
    }
}
