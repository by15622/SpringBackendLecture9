package com.codeit.javathreadbasicdemo.practice03;

public class ThreadLifecycleDemo {

  public static void run() {

    System.out.println();
    System.out.println("=== 3.5 [실습] 스레드 제어와 생명주기 확인 ===");

    demonstrateStartSleepJoin();

    System.out.println();

    demonstrateInterrupt();

    System.out.println();

    demonstrateThreadState();
  }

  private static void demonstrateStartSleepJoin() {

    System.out.println("[start(), sleep(), join() 확인]");

    Thread workerThread =
        new Thread(() -> {

          String threadName =
              Thread.currentThread()
                  .getName();

          try {
            for (int i = 1; i <= 3; i++) {

              System.out.println(
                  "[" + threadName + "] 작업 단계 "
                      + i
                      + "/3"
              );

              Thread.sleep(1000);
            }

            System.out.println(
                "[" + threadName + "] 작업 완료"
            );

          } catch (InterruptedException e) {

            System.out.println(
                "[" + threadName + "] 작업 중 인터럽트 발생"
            );

            Thread.currentThread()
                .interrupt();
          }
        });

    workerThread.setName("WorkerThread");

    System.out.println(
        "start() 호출 전 상태: "
            + workerThread.getState()
    );

    workerThread.start();

    System.out.println(
        "start() 호출 후 상태: "
            + workerThread.getState()
    );

    try {
      System.out.println("main 스레드가 WorkerThread 종료를 기다린다.");

      workerThread.join();

      System.out.println(
          "join() 이후 상태: "
              + workerThread.getState()
      );

    } catch (InterruptedException e) {

      Thread.currentThread()
          .interrupt();
    }
  }

  private static void demonstrateInterrupt() {

    System.out.println("[interrupt() 확인]");

    Thread longRunningThread =
        new Thread(() -> {

          String threadName =
              Thread.currentThread()
                  .getName();

          try {
            for (int i = 1; i <= 10; i++) {

              System.out.println(
                  "[" + threadName + "] 진행률: "
                      + (i * 10)
                      + "%"
              );

              Thread.sleep(500);
            }

          } catch (InterruptedException e) {

            System.out.println(
                "[" + threadName + "] sleep 중 interrupt 신호 감지"
            );

            Thread.currentThread()
                .interrupt();
          }

          System.out.println(
              "[" + threadName + "] 작업 종료"
          );
        });

    longRunningThread.setName("LongRunningThread");

    longRunningThread.start();

    try {
      Thread.sleep(2000);

      System.out.println(
          "[main] 2초 후 interrupt() 호출"
      );

      longRunningThread.interrupt();

      longRunningThread.join();

    } catch (InterruptedException e) {

      Thread.currentThread()
          .interrupt();
    }
  }

  private static void demonstrateThreadState() {

    System.out.println("[Thread.State 확인]");

    Object lock =
        new Object();

    Thread stateThread =
        new Thread(() -> {

          String threadName =
              Thread.currentThread()
                  .getName();

          try {
            System.out.println(
                "[" + threadName + "] 실행 시작"
            );

            Thread.sleep(1500);

            synchronized (lock) {
              System.out.println(
                  "[" + threadName + "] wait 상태 진입"
              );

              lock.wait(1000);
            }

            System.out.println(
                "[" + threadName + "] 실행 종료"
            );

          } catch (InterruptedException e) {

            Thread.currentThread()
                .interrupt();
          }
        });

    stateThread.setName("StateThread");

    Thread monitorThread =
        new Thread(() -> {

          try {
            while (
                stateThread.getState()
                    != Thread.State.TERMINATED
            ) {

              System.out.println(
                  "[MonitorThread] StateThread 상태: "
                      + stateThread.getState()
              );

              Thread.sleep(300);
            }

            System.out.println(
                "[MonitorThread] StateThread 상태: "
                    + stateThread.getState()
            );

          } catch (InterruptedException e) {

            Thread.currentThread()
                .interrupt();
          }
        });

    monitorThread.setName("MonitorThread");

    System.out.println(
        "stateThread 시작 전 상태: "
            + stateThread.getState()
    );

    monitorThread.start();
    stateThread.start();

    try {
      stateThread.join();
      monitorThread.join();

    } catch (InterruptedException e) {

      Thread.currentThread()
          .interrupt();
    }
  }
}