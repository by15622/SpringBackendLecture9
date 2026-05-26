package practice06;

import java.time.LocalTime;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerShutdownDemo {

  private static final String SHUTDOWN_SIGNAL =
      "SHUTDOWN";

  public static void run() {

    System.out.println();
    System.out.println("=== 4.4 [실습] Producer-Consumer와 우아한 종료 구현 ===");

    demonstrateGracefulShutdown();
  }

  private static void demonstrateGracefulShutdown() {

    BlockingQueue<String> orderQueue =
        new ArrayBlockingQueue<>(5);

    ExecutorService producerPool =
        Executors.newFixedThreadPool(2);

    ExecutorService consumerPool =
        Executors.newFixedThreadPool(3);

    int producerCount = 2;

    int consumerCount = 3;

    for (int i = 1; i <= producerCount; i++) {

      int producerId = i;

      producerPool.submit(() ->
          produceOrders(
              producerId,
              orderQueue
          )
      );
    }

    for (int i = 1; i <= consumerCount; i++) {

      int consumerId = i;

      consumerPool.submit(() ->
          consumeOrders(
              consumerId,
              orderQueue
          )
      );
    }

    shutdownProducerPool(
        producerPool
    );

    sendShutdownSignals(
        orderQueue,
        consumerCount
    );

    shutdownConsumerPool(
        consumerPool
    );
  }

  private static void produceOrders(
      int producerId,
      BlockingQueue<String> orderQueue
  ) {

    try {

      for (int i = 1; i <= 5; i++) {

        String order =
            "Order-P"
                + producerId
                + "-"
                + i;

        System.out.println(
            now()
                + " [Producer-"
                + producerId
                + "] 주문 생성: "
                + order
        );

        orderQueue.put(order);

        System.out.println(
            now()
                + " [Producer-"
                + producerId
                + "] 큐 저장 완료: "
                + order
                + ", 현재 큐 크기: "
                + orderQueue.size()
        );

        Thread.sleep(500);
      }

      System.out.println(
          now()
              + " [Producer-"
              + producerId
              + "] 주문 생성 완료"
      );

    } catch (InterruptedException e) {

      System.out.println(
          now()
              + " [Producer-"
              + producerId
              + "] 인터럽트 발생"
      );

      Thread.currentThread()
          .interrupt();
    }
  }

  private static void consumeOrders(
      int consumerId,
      BlockingQueue<String> orderQueue
  ) {

    try {

      while (true) {

        System.out.println(
            now()
                + " [Consumer-"
                + consumerId
                + "] 주문 대기 중"
        );

        String order =
            orderQueue.take();

        if (SHUTDOWN_SIGNAL.equals(order)) {

          System.out.println(
              now()
                  + " [Consumer-"
                  + consumerId
                  + "] 종료 신호 수신"
          );

          break;
        }

        System.out.println(
            now()
                + " [Consumer-"
                + consumerId
                + "] 주문 처리 시작: "
                + order
        );

        Thread.sleep(1500);

        System.out.println(
            now()
                + " [Consumer-"
                + consumerId
                + "] 주문 처리 완료: "
                + order
                + ", 현재 큐 크기: "
                + orderQueue.size()
        );
      }

    } catch (InterruptedException e) {

      System.out.println(
          now()
              + " [Consumer-"
              + consumerId
              + "] 인터럽트 발생"
      );

      Thread.currentThread()
          .interrupt();
    }
  }

  private static void shutdownProducerPool(
      ExecutorService producerPool
  ) {

    producerPool.shutdown();

    try {

      boolean finished =
          producerPool.awaitTermination(
              10,
              TimeUnit.SECONDS
          );

      if (finished) {

        System.out.println(
            now()
                + " [main] 모든 Producer 작업 완료"
        );

      } else {

        System.out.println(
            now()
                + " [main] Producer 종료 시간 초과. 강제 종료"
        );

        producerPool.shutdownNow();
      }

    } catch (InterruptedException e) {

      producerPool.shutdownNow();

      Thread.currentThread()
          .interrupt();
    }
  }

  private static void sendShutdownSignals(
      BlockingQueue<String> orderQueue,
      int consumerCount
  ) {

    try {

      for (int i = 0; i < consumerCount; i++) {

        orderQueue.put(
            SHUTDOWN_SIGNAL
        );
      }

      System.out.println(
          now()
              + " [main] Consumer 종료 신호 전송 완료"
      );

    } catch (InterruptedException e) {

      Thread.currentThread()
          .interrupt();
    }
  }

  private static void shutdownConsumerPool(
      ExecutorService consumerPool
  ) {

    consumerPool.shutdown();

    try {

      boolean finished =
          consumerPool.awaitTermination(
              10,
              TimeUnit.SECONDS
          );

      if (finished) {

        System.out.println(
            now()
                + " [main] 모든 Consumer 작업 완료"
        );

      } else {

        System.out.println(
            now()
                + " [main] Consumer 종료 시간 초과. 강제 종료"
        );

        consumerPool.shutdownNow();
      }

    } catch (InterruptedException e) {

      consumerPool.shutdownNow();

      Thread.currentThread()
          .interrupt();
    }
  }

  private static String now() {

    return "[" + LocalTime.now().withNano(0) + "]";
  }
}