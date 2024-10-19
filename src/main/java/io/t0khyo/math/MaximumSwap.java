package io.t0khyo.math;

public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        char maxDigit = '0';
        int maxIdx = -1;
        int swapI = -1;
        int swapJ = -1;

        for (int i = nums.length - 1;i >= 0;i--) {
            // max
            if (nums[i] > maxDigit) {
                maxDigit = nums[i];
                maxIdx = i;
            }
            // swap
            if (nums[i] < maxDigit) {
                swapI = i;
                swapJ = maxIdx;
            }
        }

        if (swapJ < 0 || swapI < 0)
            return num;

        char temp = nums[swapI];
        nums[swapI] = nums[swapJ];
        nums[swapJ] = temp;

        return Integer.parseInt(String.valueOf(nums));
    }
}
