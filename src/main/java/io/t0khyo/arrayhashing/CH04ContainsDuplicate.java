package io.t0khyo.arrayhashing;

import java.util.HashSet;
import java.util.Set;

public class CH04ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visitedNumber = new HashSet<>();
        for (int num : nums) {
            if (visitedNumber.contains(num)) {
                return true;
            }
            visitedNumber.add(num);
        }
        return false;
    }
}
