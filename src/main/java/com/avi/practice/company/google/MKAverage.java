package com.avi.practice.company.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class MKAverage {

    private final int m;
    private final int k;
    private final Deque<Integer> dq = new ArrayDeque<>();
    private final TreeMap<Integer, Integer> sorted = new TreeMap<>();
    private int sum = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        dq.offerLast(num);
        sorted.compute(num, (key, val) -> {
            return val == null ? 1 : val + 1;
        });
        sum += num;

        if (dq.size() > m) {
            final int removedValue = dq.pollFirst();
            sum -= removedValue;
            final int count = sorted.get(removedValue);
            if (count > 1) {
                sorted.put(removedValue, count - 1);
            } else {
                sorted.remove(removedValue);
            }
        }
    }

    public int calculateMKAverage() {
        if (dq.size() < m) {
            return -1;
        }

        int currSum = sum;
        int less = k;
        for (final Map.Entry<Integer, Integer> e : sorted.entrySet()) {
            if (less == 0) {
                break;
            }
            final int counts = Math.min(less, e.getValue());
            currSum -= (counts * e.getKey());
            less -= counts;
        }

        int greater = k;
        for (final Map.Entry<Integer, Integer> e : sorted.descendingMap().entrySet()) {
            if (greater == 0) {
                break;
            }
            final int counts = Math.min(greater, e.getValue());
            currSum -= (counts * e.getKey());
            greater -= counts;
        }

        return (currSum) / (m - 2 * k);
    }

}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */