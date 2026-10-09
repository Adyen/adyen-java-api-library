/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.legalentitymanagement;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.RequestOptions;
import com.adyen.model.legalentitymanagement.Address;
import com.adyen.model.legalentitymanagement.BirthData;
import com.adyen.model.legalentitymanagement.Individual;
import com.adyen.model.legalentitymanagement.LegalEntity;
import com.adyen.model.legalentitymanagement.LegalEntityInfoRequiredType;
import com.adyen.model.legalentitymanagement.Name;
import com.adyen.model.legalentitymanagement.PhoneNumber;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class LegalEntitiesApiIT extends BaseIntegrationTest {

  // Scenario: Create a legal entity for an individual residing in the Netherlands
  @Test
  public void shouldCreateLegalEntityForIndividualResidingInTheNetherlands()
      throws ApiException, IOException {
    // Arrange
    Address residentialAddress =
        new Address()
            .city("Amsterdam")
            .country("NL")
            .postalCode("1011DJ")
            .street("Simon Carmiggeltstraat 6 - 50");
    Individual individual =
        new Individual()
            .residentialAddress(residentialAddress)
            .name(new Name().firstName("Shelly").lastName("Eller"))
            .phone(new PhoneNumber().number("+31858888138").type("mobile"))
            .birthData(new BirthData().dateOfBirth("1990-06-21"))
            .email("s.eller@example.com");
    LegalEntityInfoRequiredType request =
        new LegalEntityInfoRequiredType()
            .type(LegalEntityInfoRequiredType.TypeEnum.INDIVIDUAL)
            .individual(individual);
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    LegalEntitiesApi legalEntitiesApi = new LegalEntitiesApi(getLegalEntityManagementClient());

    // Act
    LegalEntity response = legalEntitiesApi.createLegalEntity(request, requestOptions);

    // Assert
    assertNotNull(response.getId(), "The legal entity must have an ID");
    assertFalse(response.getId().isBlank(), "The legal entity ID must not be blank");
    assertEquals(
        LegalEntity.TypeEnum.INDIVIDUAL,
        response.getType(),
        "The legal entity type must be individual");
  }
}
