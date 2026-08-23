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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.model.paymentsapp.JSON;
import com.adyen.model.transfers.TransferDataTracing;
import com.adyen.model.transfers.USAchTracingData;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.EnumFeature;
import tools.jackson.databind.util.StdDateFormat;

class Jackson3CompatibilityTest {

  private static final String UTF_8_TEXT = "Jackson 3 – UTF-8 ✓";

  @AfterEach
  void restoreDefaultDateFormat() {
    JSON.getDefault().setDateFormat(StdDateFormat.instance);
  }

  @Test
  void setDateFormatRebuildsMapperWithoutLosingModulesOrConfiguration() throws Exception {
    ObjectMapper before = JSON.getMapper();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    JSON.getDefault().setDateFormat(dateFormat);

    ObjectMapper after = JSON.getMapper();
    assertNotSame(before, after);
    assertFalse(after.isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES));
    assertTrue(after.isEnabled(EnumFeature.WRITE_ENUMS_USING_TO_STRING));
    assertEquals("\"1970/01/01\"", after.writeValueAsString(new Date(0)));

    byte[] bytes = UTF_8_TEXT.getBytes(UTF_8);
    assertArrayEquals(bytes, after.readValue(after.writeValueAsString(bytes), byte[].class));
  }

  @Test
  void mapperIsVisibleDuringConcurrentReconfiguration() throws Exception {
    Field mapperField = JSON.class.getDeclaredField("mapper");
    assertTrue(Modifier.isVolatile(mapperField.getModifiers()));

    int taskCount = 5;
    CyclicBarrier start = new CyclicBarrier(taskCount);
    ExecutorService executor = Executors.newFixedThreadPool(taskCount);
    List<Future<?>> futures = new ArrayList<>();
    try {
      futures.add(
          executor.submit(
              () -> {
                start.await();
                for (int i = 0; i < 100; i++) {
                  JSON.getDefault()
                      .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
                }
                return null;
              }));
      for (int task = 1; task < taskCount; task++) {
        futures.add(
            executor.submit(
                () -> {
                  start.await();
                  for (int i = 0; i < 100; i++) {
                    ObjectMapper mapper = JSON.getMapper();
                    assertNotNull(mapper);
                    assertTrue(mapper.readTree("{\"visible\":true}").get("visible").asBoolean());
                  }
                  return null;
                }));
      }

      for (Future<?> future : futures) {
        future.get();
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  void deserializesOneOfModelWithJackson3() throws Exception {
    TransferDataTracing tracing =
        TransferDataTracing.fromJson("{\"type\":\"usAch\",\"traceNumber\":\"091000010000001\"}");

    USAchTracingData usAch = assertInstanceOf(USAchTracingData.class, tracing.getActualInstance());
    assertEquals(USAchTracingData.TypeEnum.USACH, usAch.getType());
    assertEquals("091000010000001", usAch.getTraceNumber());
  }

  @Test
  void serializesByteArraysAsUtf8AndRoundTripsThem() throws Exception {
    ObjectMapper mapper = JSON.getMapper();
    byte[] bytes = UTF_8_TEXT.getBytes(UTF_8);

    String serialized = mapper.writeValueAsString(bytes);

    assertEquals("\"" + UTF_8_TEXT + "\"", serialized);
    assertArrayEquals(bytes, mapper.readValue(serialized, byte[].class));
  }
}
