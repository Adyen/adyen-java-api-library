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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.serializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.adyen.model.nexo.AccountType;
import com.adyen.model.nexo.AuthenticationMethodType;
import com.adyen.terminal.serialization.XMLEnumTypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class XMLEnumSerializerTest {

  @Test
  public void testAuthenticationMethodTypeMultipleValues() throws Exception {
    XMLEnumTypeAdapter<AuthenticationMethodType> adapter =
        new XMLEnumTypeAdapter<>(AuthenticationMethodType.class);

    String value1 = "\"OnlinePIN\"";
    JsonReader jsonReader1 = new JsonReader(new StringReader(value1));
    AuthenticationMethodType authenticationMethodType1 = adapter.read(jsonReader1);

    assertNotNull(authenticationMethodType1);
    assertEquals(AuthenticationMethodType.ON_LINE_PIN, authenticationMethodType1);

    String value2 = "\"OnLinePIN\"";
    JsonReader jsonReader2 = new JsonReader(new StringReader(value2));
    AuthenticationMethodType authenticationMethodType2 = adapter.read(jsonReader2);

    assertNotNull(authenticationMethodType2);
    assertEquals(AuthenticationMethodType.ON_LINE_PIN, authenticationMethodType2);
  }

  @Test
  public void testAuthenticationMethodTypeInvalidEnum() throws Exception {
    XMLEnumTypeAdapter<AuthenticationMethodType> adapter =
        new XMLEnumTypeAdapter<>(AuthenticationMethodType.class);

    String value1 = "\"unknown\"";
    JsonReader jsonReader1 = new JsonReader(new StringReader(value1));
    AuthenticationMethodType authenticationMethodType1 = adapter.read(jsonReader1);

    // verify unknown enum is set as null
    assertNull(authenticationMethodType1);
  }

  @Test
  public void testAccountTypeAccountTypeFromValue() {
    assertEquals(AccountType.DEFAULT, AccountType.fromValue("Default"));
    assertEquals(AccountType.SAVINGS, AccountType.fromValue("Savings"));
    assertEquals(AccountType.CHECKING, AccountType.fromValue("Checking"));
    assertEquals(AccountType.CREDIT_CARD, AccountType.fromValue("CreditCard"));
    assertEquals(AccountType.UNIVERSAL, AccountType.fromValue("Universal"));
    assertEquals(AccountType.INVESTMENT, AccountType.fromValue("Investment"));
    assertEquals(AccountType.CARD_TOTALS, AccountType.fromValue("CardTotals"));
    assertEquals(AccountType.EPURSE_CARD, AccountType.fromValue("EpurseCard"));
  }

  @Test
  public void testFromValueWithInvalid() {
    assertNull(AccountType.fromValue("InvalidAccountType"));
  }

  @Test
  public void testAccountTypeFromValueWithNull() {
    assertNull(AccountType.fromValue(null));
  }

  @Test
  public void testAccountTypeFromValueWithEmpty() {
    assertNull(AccountType.fromValue(""));
  }

  @Test
  public void testAccountTypeFromValueIsCaseSensitive() {
    assertNull(AccountType.fromValue("default"));
    assertNull(AccountType.fromValue("SAVINGS"));
  }

  @Test
  public void testValue() {
    assertEquals("Default", AccountType.DEFAULT.value());
    assertEquals("Savings", AccountType.SAVINGS.value());
    assertEquals("Checking", AccountType.CHECKING.value());
    assertEquals("CreditCard", AccountType.CREDIT_CARD.value());
    assertEquals("Universal", AccountType.UNIVERSAL.value());
    assertEquals("Investment", AccountType.INVESTMENT.value());
    assertEquals("CardTotals", AccountType.CARD_TOTALS.value());
    assertEquals("EpurseCard", AccountType.EPURSE_CARD.value());
  }
}
