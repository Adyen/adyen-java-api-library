package com.adyen.httpclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;

class RequestFormTest {

  @Test
  void serializesUrlEncodedFields() throws Exception {
    RequestForm form = RequestForm.create(List.of("application/x-www-form-urlencoded"));
    form.add("description", "a value & more");

    assertEquals("application/x-www-form-urlencoded", form.getContentType());
    assertEquals(
        "description=a+value+%26+more", new String(form.getRequestBody(), StandardCharsets.UTF_8));
  }

  @Test
  void serializesMultipartFilesAndFields() throws Exception {
    RequestForm form = RequestForm.create(List.of("multipart/form-data; charset=utf-8"));
    form.add("description", "test file");
    form.add("file", new HttpFile("file data".getBytes(StandardCharsets.UTF_8), "test.txt"));

    String requestBody = new String(form.getRequestBody(), StandardCharsets.UTF_8);
    assertTrue(form.getContentType().startsWith("multipart/form-data"));
    assertTrue(form.getContentType().contains("boundary="));
    assertTrue(requestBody.contains("name=\"description\""));
    assertTrue(requestBody.contains("test file"));
    assertTrue(requestBody.contains("filename=\"test.txt\""));
    assertTrue(requestBody.contains("file data"));
  }

  @Test
  void rejectsFilesForUrlEncodedRequests() {
    RequestForm form = RequestForm.create(List.of("application/x-www-form-urlencoded"));

    assertThrows(
        IllegalStateException.class,
        () -> form.add("file", new HttpFile(new byte[] {1}, "test.bin")));
  }
}
