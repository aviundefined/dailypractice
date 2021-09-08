package com.avi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by navinash on 31/08/21.
 * Copyright 2019 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 */
public class Solution {

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final List<String> list = Arrays.asList("in", "sells", "seas", "she", "seashells", "sea");
        final Set<String> dict = new HashSet<>(list);
        {
            final String sentence = "seashells";
            System.out.println(solution.canMakeSentence(sentence, dict));
        }
        {
            final String sentence = "shesellsseas";
            System.out.println(solution.canMakeSentence(sentence, dict));
        }
        {
            final String sentence = "shesellsseashellsinseas";
            // she-sells-seashells-in-seas
            System.out.println(solution.canMakeSentence(sentence, dict));
        }
        // seashells -> true
        // shesellsseas
        // shesellseashellsinseas -> true
    }

    private boolean canMakeSentence(final String sentence, final Set<String> dict) {
        if (sentence == null || sentence.length() == 0 || "".equals(sentence.trim())) {
            return true;
        }
        if (dict.contains(sentence)) {
            return true;
        }

        final int n = sentence.length();
        final boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        // 0 1 2 3 4 5 6 7 8 9 10 11
        // s h e s e l l s s e a   s
        // fill dp[i+1]
        for (int i = 0; i < n; i++) { // 3
            final String prefix = sentence.substring(0, i + 1); // shesellsseas
            if (dict.contains(prefix)) {
                dp[i + 1] = true;
            } else {
                for (int j = i; j >= 0; j--) { // 3
                    if (dp[j]) {  //
                        final String suffix = sentence.substring(j, i + 1); // s
                        if (dict.contains(suffix)) {
                            dp[i + 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[n];
    }
}
