package io.t0khyo.math;

public class XorQueriesOfASubArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] result1 = xorQueries(arr1, queries1);
        for (int res : result1) {
            System.out.print(res + " ");
        }
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];

        for (int i = 1;i < arr.length;i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0;i < queries.length;i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = prefixXor[right];
            } else {
                result[i] = prefixXor[right] ^ prefixXor[left - 1];
            }
        }

        return result;
    }
}
