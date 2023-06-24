package com.avi.practice.company.atlassian.taskexecutor;

public interface ITaskExecutor extends IExecutor {

  void register(final Task task);

  class Task {

    private final long startTimeMs;
    private final Runnable runnable;

    public Task(long startTimeMs, Runnable runnable) {
      this.startTimeMs = startTimeMs;
      this.runnable = runnable;
    }

    public long getStartTimeMs() {
      return startTimeMs;
    }

    public final void execute() {
      this.runnable.run();
    }
  }
}
