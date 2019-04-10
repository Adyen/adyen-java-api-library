/**
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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.modification.AbstractModificationRequest;
import org.junit.Test;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ModificationRequestTest {

    @Test
    public void TestDefaultApplicationInfoAdyenLibrary() {
        AbstractModificationRequest modificationRequest = new AbstractModificationRequest();

        assertNotNull(modificationRequest.getApplicationInfo());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, modificationRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, modificationRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test
    public void TestCustomApplicationInfoAdyenLibrary() {
        AbstractModificationRequest modificationRequest = new AbstractModificationRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        modificationRequest.setApplicationInfo(applicationInfo);

        assertNotNull(modificationRequest.getApplicationInfo());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, modificationRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, modificationRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test
    public void TestNullApplicationInfoAdyenLibrary() {
        AbstractModificationRequest modificationRequest = new AbstractModificationRequest();
        modificationRequest.setApplicationInfo(null);

        assertNotNull(modificationRequest.getApplicationInfo());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, modificationRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(modificationRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, modificationRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }
}