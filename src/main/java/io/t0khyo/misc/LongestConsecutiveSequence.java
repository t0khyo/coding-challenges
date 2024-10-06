package io.t0khyo.misc;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            // is this number is a start of a sequence?
            if (!numSet.contains(num - 1)) {
                int length = 0;
                while (numSet.contains(num + length))
                    length++;

                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
