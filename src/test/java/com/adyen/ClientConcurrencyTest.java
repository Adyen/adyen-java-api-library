package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockConstruction;

import com.adyen.enums.Environment;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.ClientInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

public class ClientConcurrencyTest {

  @Test
  public void testConcurrentFirstAccessCreatesOneHttpClient() throws Exception {
    int numberOfThreads = 16;
    Client client = new Client("apiKey", Environment.TEST);
    CountDownLatch ready = new CountDownLatch(numberOfThreads);
    CountDownLatch start = new CountDownLatch(1);
    CountDownLatch constructionStarted = new CountDownLatch(numberOfThreads);
    CountDownLatch allowConstruction = new CountDownLatch(1);
    AtomicInteger creationCount = new AtomicInteger();
    ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

    try {
      List<Future<ClientInterface>> results = new ArrayList<>();
      for (int i = 0; i < numberOfThreads; i++) {
        results.add(
            executor.submit(
                () -> {
                  try (MockedConstruction<AdyenHttpClient> ignored =
                      mockConstruction(
                          AdyenHttpClient.class,
                          (mock, context) -> {
                            creationCount.incrementAndGet();
                            constructionStarted.countDown();
                            try {
                              assertTrue(allowConstruction.await(5, TimeUnit.SECONDS));
                            } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                              throw new AssertionError(e);
                            }
                          })) {
                    ready.countDown();
                    try {
                      assertTrue(start.await(5, TimeUnit.SECONDS));
                    } catch (InterruptedException e) {
                      Thread.currentThread().interrupt();
                      throw new AssertionError(e);
                    }
                    return client.getHttpClient();
                  }
                }));
      }

      assertTrue(ready.await(5, TimeUnit.SECONDS));
      start.countDown();
      constructionStarted.await(1, TimeUnit.SECONDS);
      allowConstruction.countDown();

      ClientInterface expectedHttpClient = results.get(0).get(5, TimeUnit.SECONDS);
      for (int i = 1; i < results.size(); i++) {
        assertSame(expectedHttpClient, results.get(i).get(5, TimeUnit.SECONDS));
      }

      assertEquals(1, creationCount.get());
    } finally {
      start.countDown();
      allowConstruction.countDown();
      executor.shutdownNow();
      client.close();
    }
  }
}
