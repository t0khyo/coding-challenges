package io.t0khyo.arrayhashing;

import java.util.Arrays;

public class CH10ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int i = 0;i < result.length;i++) {
            System.out.print(result[i] + " ");
        }
    }

    // O(n^2)
    public static int[] productExceptSelf_tooMuchTime(int[] nums) {
        int[] result = new int[nums.length];
        int productHistory = 1;
        for (int i = 0;i < nums.length;i++) {
            result[i] = 1;
            result[i] *= productHistory;
            productHistory *= nums[i];

            for (int j = i + 1;j < nums.length;j++) {
                result[i] *= nums[j];
            }
        }

        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        int postfix = 1;

        for (int i = 0;i < nums.length;i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = nums.length-1 ;i >= 0;i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

}
