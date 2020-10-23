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
package com.adyen;

import com.adyen.model.SubjectErasureRequest;
import com.adyen.model.SubjectErasureResponse;
import com.adyen.service.DataProtection;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 */
public class DataProtectionServiceTest extends BaseTest {
    /**
     * Test success flow for POST /requestSubjectErasure
     */
    @Test
    public  void TestRequestSubjectErasureSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/request-subject-erasure-success.json");
        DataProtection dataProtection = new DataProtection(client);
        SubjectErasureRequest subjectErasureRequest = createSubjectErasureRequest();

        SubjectErasureResponse subjectErasureResponse = dataProtection.requestSubjectErasure(subjectErasureRequest);

        assertEquals(SubjectErasureResponse.ResultEnum.SUCCESS, subjectErasureResponse.getResult());
    }

    protected SubjectErasureRequest createSubjectErasureRequest() {
        SubjectErasureRequest subjectErasureRequest = new SubjectErasureRequest();
        subjectErasureRequest.setForceErasure(false);
        subjectErasureRequest.setMerchantAccount("Test");
        subjectErasureRequest.setPspReference("123456");

        return subjectErasureRequest;
    }

    @Test
    public void TestGetAuthenticationResultErrorNotFound() throws IOException {
        Client client = createMockClientForErrors(200, "mocks/request-subject-erasure-not-found.json");

        DataProtection dataProtection = new DataProtection(client);
        SubjectErasureRequest subjectErasureRequest = createSubjectErasureRequest();

        try {
            dataProtection.requestSubjectErasure(subjectErasureRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals(200, e.getStatusCode());
        }
    }

}
