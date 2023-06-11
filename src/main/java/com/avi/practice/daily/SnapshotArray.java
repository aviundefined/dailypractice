package com.avi.practice.daily;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SnapshotArray {

  private final TreeMap<Integer, int[]> snaps = new TreeMap<>();
  private final int length;
  private int current_snap_id;

  public SnapshotArray(int length) {
    this.length = length;
    this.current_snap_id = 1;
    this.snaps.put(this.current_snap_id, new int[length]);
  }

  public void set(int index, int val) {
    final int[] arr = this.snaps.computeIfAbsent(this.current_snap_id, k -> new int[this.length]);
    arr[index] = val;
  }

  public int snap() {
    return ++this.current_snap_id;
  }

  public int get(int index, int snap_id) {
    final Map.Entry<Integer, int[]> e = this.snaps.floorEntry(snap_id);
    return e.getValue()[index];
  }
}
