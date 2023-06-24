package com.avi.practice.company.atlassian.taskexecutor;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TaskExecutor implements ITaskExecutor {

  private final PriorityQueue<Task> tasks;
  private final Lock lock = new ReentrantLock();
  private final Condition condition = lock.newCondition();
  private final Thread executor;
  private final IExecutor pool;

  public TaskExecutor(final int maxConcurrentTasks) {
    this.tasks = new PriorityQueue<>((t1, t2) -> (int) (t1.getStartTimeMs() - t2.getStartTimeMs()));
    this.executor = new Thread(this::execute);
    this.executor.setDaemon(true);
    this.pool = new ThreadPool(maxConcurrentTasks);
  }

  @Override
  public void register(Task task) {
    lock.lock();
    try {
      tasks.offer(task);
      condition.signal();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void start() {
    this.pool.start();
    this.executor.start();
  }

  @Override
  public void stop() {
    this.executor.interrupt();
  }

  private void execute() {
    while (true) {
      lock.lock();
      Task task = null;
      try {
        while (tasks.isEmpty()) {
          condition.await();
        }
        while (!tasks.isEmpty()) {
          // Check the top of the tasks heap
          final long sleepTime = sleepTime(tasks.peek());
          if (sleepTime <= 0) {
            break;
          }
          condition.await(sleepTime, TimeUnit.MILLISECONDS);
        }
        task = tasks.poll();
      } catch (final Exception ignored) {
        // Catching exception here to make sure that any task should not impact other tasks;
      } finally {
        lock.unlock();
      }
      if (task != null) {
        runTask(task);
      }
    }
  }

  private void runTask(final Task task) {
    task.execute();
  }

  private long sleepTime(final Task task) {
    return task.getStartTimeMs() - System.currentTimeMillis();
  }
}
