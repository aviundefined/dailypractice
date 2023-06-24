package com.avi.practice.company.atlassian;


import org.junit.Assert;
import org.junit.Test;

public class TopVotedCandidateTest {

  @Test
  public void testCase1() {
    final int[] persons = {0,1,1,0,0,1,0};
    final int[] times = {0,5,10,15,20,25,30};
    final TopVotedCandidate solver = new TopVotedCandidate(persons, times);
    Assert.assertEquals(0, solver.q(3));
    Assert.assertEquals(1, solver.q(12));
    Assert.assertEquals(1, solver.q(25));
    Assert.assertEquals(0, solver.q(15));
    Assert.assertEquals(0, solver.q(24));
    Assert.assertEquals(1, solver.q(8));
  }
}