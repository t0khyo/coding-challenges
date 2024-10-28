package io.t0khyo.misc;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequancyMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : nums) {
            numFrequancyMap.put(num, numFrequancyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : numFrequancyMap.keySet()) {
            int frequency = numFrequancyMap.get(num);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(num);
        }

        int[] result = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1;i >= 0;i--) {
            if (bucket[i] != null) {
                for (int j = 0;
                     j < bucket[i].size() && pos < k;
                     j++) {
                    result[pos] = bucket[i].get(j);
                    System.out.println(result[pos]);
                    pos++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3, 4, 5, 6, 7, 3, 3, 2};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
