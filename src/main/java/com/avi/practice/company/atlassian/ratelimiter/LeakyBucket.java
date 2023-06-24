package com.avi.practice.company.atlassian.ratelimiter;

public class LeakyBucket {

  private final long maxTokens;
  private final long tokenGenerationFreqMillis;
  private final Thread tokenGenerator;
  private final Object lock = new Object();
  private long currentTokens;

  public LeakyBucket(long maxTokens, long tokenGenerationFreqMillis) {
    this.maxTokens = maxTokens;
    this.tokenGenerationFreqMillis = tokenGenerationFreqMillis;
    this.tokenGenerator = new Thread(this::generateToken);
    this.tokenGenerator.setDaemon(true);
  }

  public synchronized void start() {
    this.tokenGenerator.start();
  }

  public synchronized void stop() {
    this.tokenGenerator.interrupt();
  }

  public boolean isAllowed() throws InterruptedException {
    synchronized (lock) {
      if (currentTokens == 0) {
        lock.wait();
      }
      this.currentTokens--;
      return true;
    }
  }

  private void generateToken() {
    while (true) {
      synchronized (lock) {
        if (this.currentTokens < this.maxTokens) {
          this.currentTokens++;
        }
        lock.notify();
      }

      try {
        Thread.sleep(this.tokenGenerationFreqMillis);
      } catch (InterruptedException ignored) {

      }
    }
  }
}
