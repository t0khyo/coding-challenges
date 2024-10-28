package io.t0khyo.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakInAnArray {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longestSquare = 0;

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            int streak = 0;
            int currentNum = num;
            while (numSet.contains(currentNum)) {
                streak++;
                currentNum = currentNum * currentNum;
            }

            longestSquare = Math.max(longestSquare, streak);
        }

        return longestSquare >= 2 ? longestSquare + 1 : -1;
    }
}
