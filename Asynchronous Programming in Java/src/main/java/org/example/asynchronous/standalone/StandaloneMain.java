package org.example.asynchronous.standalone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StandaloneMain {

  private final int testNumber;

  public StandaloneMain(int testNumber) {
    this.testNumber = testNumber;
  }

  public static void main(String[] args) {
    log.info("Main thread name: {}", Thread.currentThread().getName());

    StandaloneMain standaloneMain = new StandaloneMain(14);
    standaloneMain.runWithThread();
    standaloneMain.runWithRunnable();
    standaloneMain.runWithExecutorService();
    standaloneMain.runWithCustomForkJoin();
  }

  private void runWithThread() {
    CustomThread customThread = new CustomThread(this.testNumber);
    customThread.start();
  }

  private void runWithRunnable() {
    CustomRunnable customRunnable = new CustomRunnable(this.testNumber);
    Thread newThread = new Thread(customRunnable);
    newThread.start();
  }

  private void runWithExecutorService() {
    CustomRunnable customRunnable1 = new CustomRunnable(this.testNumber);
    CustomRunnable customRunnable2 = new CustomRunnable(this.testNumber);

    ExecutorService executor = Executors.newFixedThreadPool(this.testNumber);
    executor.submit(customRunnable1);
    executor.submit(customRunnable2);

    executor.shutdown();
  }

  private void runWithCustomForkJoin() {
    CustomRecursiveAction customRecursiveAction1 = new CustomRecursiveAction(this.testNumber);
    CustomRecursiveAction customRecursiveAction2 = new CustomRecursiveAction(this.testNumber);

    List<CustomRecursiveAction> subtasks = new ArrayList<>();
    subtasks.add(customRecursiveAction1);
    subtasks.add(customRecursiveAction2);

    ForkJoinTask.invokeAll(subtasks);
  }
}
