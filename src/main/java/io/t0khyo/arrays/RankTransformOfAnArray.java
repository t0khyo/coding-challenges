package io.t0khyo.arrays;

import java.util.HashMap;
import java.util.TreeSet;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> numRanks = new HashMap<>();
        TreeSet<Integer> nums = new TreeSet<>();

        for (int n : arr) nums.add(n);

        int rank = 1;

        for (int n : nums) {
            numRanks.put(n, rank);
            rank++;
        }

        for (int i = 0;i < arr.length;i++) {
            arr[i] = numRanks.get(arr[i]);
        }

        return arr;
    }
}
