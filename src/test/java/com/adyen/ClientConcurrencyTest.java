package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class ClientConcurrencyTest {

  @Test
  public void testConcurrentFirstAccessCreatesOneHttpClient() throws Exception {
    int numberOfThreads = 16;
    BlockingCreationClient client = new BlockingCreationClient(numberOfThreads);
    CountDownLatch ready = new CountDownLatch(numberOfThreads);
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

    try {
      List<Future<?>> results = new ArrayList<>();
      for (int i = 0; i < numberOfThreads; i++) {
        results.add(
            executor.submit(
                () -> {
                  ready.countDown();
                  try {
                    assertTrue(start.await(5, TimeUnit.SECONDS));
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                  }
                  client.getHttpClient();
                }));
      }

      assertTrue(ready.await(5, TimeUnit.SECONDS));
      start.countDown();
      client.waitForConcurrentCreationWindow();
      client.allowCreation();

      for (Future<?> result : results) {
        result.get(5, TimeUnit.SECONDS);
      }

      assertEquals(1, client.getCreationCount());
    } finally {
      start.countDown();
      client.allowCreation();
      executor.shutdownNow();
      client.close();
    }
  }

  private static class BlockingCreationClient extends Client {
    private final CountDownLatch creationAttempts;
    private final CountDownLatch allowCreation = new CountDownLatch(1);
    private final AtomicInteger creationCount = new AtomicInteger();

    BlockingCreationClient(int numberOfThreads) {
      super("apiKey", Environment.TEST);
      creationAttempts = new CountDownLatch(numberOfThreads);
    }

    @Override
    ClientInterface createHttpClient() {
      creationCount.incrementAndGet();
      creationAttempts.countDown();
      try {
        allowCreation.await();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new AssertionError(e);
      }
      return new AdyenHttpClient();
    }

    void waitForConcurrentCreationWindow() throws InterruptedException {
      creationAttempts.await(1, TimeUnit.SECONDS);
    }

    void allowCreation() {
      allowCreation.countDown();
    }

    int getCreationCount() {
      return creationCount.get();
    }
  }
}
