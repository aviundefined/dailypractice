package com.avi.practice.company.atlassian.taskexecutor;

import com.avi.practice.company.atlassian.taskexecutor.ITaskExecutor.Task;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool implements IExecutor {

  private final BlockingQueue<Task> queue = new LinkedBlockingDeque<>();
  private final Worker[] workers;

  public ThreadPool(int maxThreads) {
    this.workers = new Worker[maxThreads];
    for (int i = 0; i < maxThreads; i++) {
      workers[i] = new Worker();
    }
  }

  @Override
  public final void start() {
    for (final Worker worker : workers) {
      worker.start();
    }
  }

  @Override
  public final void stop() {
    for (final Worker worker : workers) {
      try {
        worker.interrupt();
      } catch (final Exception ignored) {

      }
    }
  }

  private final class Worker extends Thread {

    @Override
    public void run() {
      while (true) {
        ITaskExecutor.Task task = null;
        synchronized (queue) {
          try {
            while (queue.isEmpty()) {
              wait();
            }
            task = queue.poll();
          } catch (final Exception ignored) {

          }
        }
        try {
          if (task != null) {
            task.execute();
          }
        } catch (Exception ignored) {

        }
      }
    }
  }
}
