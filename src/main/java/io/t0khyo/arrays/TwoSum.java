package io.t0khyo.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    /*
     * [2, 3, 7, 4, 8] - target 7 - output [1, 3]
     * The easiest brute force is nested i, j loops with O(n^2).
     *
     *   solution:
     *      we need to look for the delta of the target by looping
     *      e.g. if [i] = 2 find 5.
     *
     *      for finding a key value data structure (MAP 🗺)
     */
    public static int[] twoSum(int[] nums, int target) {
        // key = value of the number - value = index
        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for (int i = 0;i < nums.length;i++) {
            int delta = target - nums[i];
            if (visitedNumbers.containsKey(delta)) {
                return new int[]{visitedNumbers.get(delta), i};
            }
            visitedNumbers.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
