package com.avi.practice.company.atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopVotedCandidate {

  private final int[] persons;
  private final int[] times;

  public TopVotedCandidate(int[] persons, int[] times) {
    this.persons = persons;
    this.times = times;
  }

  public int q(int t) {
    final Index index = findTimeIndex(t);
    final int idx = index.found ? index.idx : index.idx - 1;
    final Map<Integer, Vote> counts = new HashMap<>();
    for (int i = 0; i <= idx; i++) {
      final Vote vote = counts.computeIfAbsent(this.persons[i], Vote::new);
      vote.inc(this.times[i]);
    }

    final PriorityQueue<Vote> pq = new PriorityQueue<>((a, b) -> {
      if (a.vote == b.vote) {
        return b.maxVoteTime - a.maxVoteTime;
      }
      return b.vote - a.vote;
    });

    for (final Vote v : counts.values()) {
      pq.offer(v);
    }
    final Vote v = pq.poll();
    if (v != null) {
      return v.person;
    }
    return 0;
  }

  private Index findTimeIndex(int t) {
    int start = 0;
    int end = this.times.length - 1;
    int floorIndex = 0;
    while (start <= end) {
      final int mid = start + (end - start) / 2;
      if (this.times[mid] == t) {
        return new Index(mid, true);
      }
      if (t < this.times[mid]) {
        floorIndex = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return new Index(floorIndex, false);
  }

  private static final class Index {
    private final int idx;
    private final boolean found;


    private Index(int idx, boolean found) {
      this.idx = idx;
      this.found = found;
    }

    @Override
    public String toString() {
      return "Index{" +
        "idx=" + idx +
        ", found=" + found +
        '}';
    }
  }

  private static final class Vote {
    private final int person;
    private int vote = 0;
    private int maxVoteTime = 0;

    private Vote(final int person) {
      this.person = person;
    }

    private void inc(final int voteTime) {
      this.maxVoteTime = Math.max(voteTime, this.maxVoteTime);
      this.vote++;
    }

    @Override
    public String toString() {
      return "Vote{" +
        "person=" + person +
        ", vote=" + vote +
        ", maxVoteTime=" + maxVoteTime +
        '}';
    }
  }
}
