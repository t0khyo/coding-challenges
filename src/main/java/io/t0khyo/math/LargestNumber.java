package io.t0khyo.math;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0;i < nums.length;i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // Reverse the comparison
        };

        Arrays.sort(numStrings, comparator);

        if (numStrings[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String numString : numStrings) {
            result.append(numString);
        }

        return result.toString();
    }
}
