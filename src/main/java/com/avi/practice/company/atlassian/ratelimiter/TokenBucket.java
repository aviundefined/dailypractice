package com.avi.practice.company.atlassian.ratelimiter;

public class TokenBucket {

  private final long maxTokens;
  private final int rateTokensPerSecond;
  private long currentAvailableTokens;
  private long lastExecutionNanos;

  public TokenBucket(int maxTokens, int rateTokensPerSecond) {
    this.maxTokens = maxTokens;
    this.currentAvailableTokens = maxTokens;
    this.rateTokensPerSecond = rateTokensPerSecond;
    this.lastExecutionNanos = System.nanoTime();
  }

  public synchronized boolean isAllowed() {
    fillTokens();
    if (this.currentAvailableTokens > 0) {
      this.currentAvailableTokens--;
      return true;
    }
    return false;
  }

  private void fillTokens() {
    final long tokensGenerated = (System.nanoTime() - this.lastExecutionNanos) * (this.rateTokensPerSecond / (1000L * 1000L * 1000L));
    this.currentAvailableTokens = Math.max(this.currentAvailableTokens + tokensGenerated, this.maxTokens);
    this.lastExecutionNanos = System.nanoTime();
  }
}
