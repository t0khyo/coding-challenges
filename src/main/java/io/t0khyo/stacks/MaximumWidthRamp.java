package io.t0khyo.stacks;

import java.util.Arrays;

public class MaximumWidthRamp {
    public static int maxWidthRamp(int[] nums) {
        int currMax = Integer.MIN_VALUE;
        int[] maxRight = new int[nums.length];
        for (int i = nums.length-1;i >= 0;i--) {
            if (nums[i] > currMax) {
                currMax = nums[i];
            }
            maxRight[i] = currMax;
        }

        int res = 0;
        int l = 0;

        for (int r = 0;r < nums.length;r++) {
            while (nums[l] > maxRight[r]) {
                l++;
            }
            res = Math.max(res, r-l);
        }

        return res;
    }

    public static void main(String[] args) {
        maxWidthRamp(new int[]{6,0,8,3,1,6});
    }
}
