package io.t0khyo.prefixsum;

public class PrefixSum {
    public static int[] calcPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];

        prefixSum[0] = arr[0];

        for (int i = 1;i < arr.length;i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }

    public static int[] calcPrefixSumInPlace(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        return arr;
    }
}