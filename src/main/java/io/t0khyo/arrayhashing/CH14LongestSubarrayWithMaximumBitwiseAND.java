package io.t0khyo.arrayhashing;

public class CH14LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int size = 0;
        int result = 0;

        for (int num : nums)
            if (num > max) max = num;

        for (int num : nums) {
            if (num == max)
                size++;
            else
                size = 0;
            result = Math.max(size, result);
        }
        return result;
    }
}
