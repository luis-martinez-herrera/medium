package org.example.asynchronous.standalone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StandaloneMain {

  public static void main(String[] args) {
    log.info("Main thread name: {}", Thread.currentThread().getName());

    StandaloneMain standaloneMain = new StandaloneMain();
    standaloneMain.runWithThread();
    standaloneMain.runWithRunnable();
    standaloneMain.runWithExecutorService();
    standaloneMain.runWithCustomForkJoin();
  }

  private void runWithThread() {
    CustomThread customThread = new CustomThread(10);
    customThread.start();
  }

  private void runWithRunnable() {
    CustomRunnable customRunnable = new CustomRunnable(10);
    Thread newThread = new Thread(customRunnable);
    newThread.start();
  }

  private void runWithExecutorService() {
    CustomRunnable customRunnable1 = new CustomRunnable(10);
    CustomRunnable customRunnable2 = new CustomRunnable(10);

    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(customRunnable1);
    executor.submit(customRunnable2);

    executor.shutdown();
  }

  private void runWithCustomForkJoin() {
    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction();
    commonPool.invoke(customRecursiveAction);
  }
}
