package io.t0khyo.strings;

import java.util.HashSet;

public class FindTheLengthOfTheLongestCommonPrefix {
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixSet = new HashSet<>();
        for (int n : arr2) {
            while (n != 0 && !prefixSet.contains(n)) {
                prefixSet.add(n);
                n /= 10;
            }
        }

        int longestPrefix = 0;
        for (int n : arr1) {
            while (n != 0 & !prefixSet.contains(n))
                n /= 10;

            if (prefixSet.contains(n)) {
                longestPrefix = Math.max(longestPrefix, String.valueOf(n).length());
            }
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{1, 10, 100, 100, 10000}, new int[]{1341, 103333, 10000}));
    }
}
