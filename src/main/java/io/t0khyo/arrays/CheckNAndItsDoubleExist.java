package io.t0khyo.arrays;

import java.util.HashSet;
import java.util.Set;

public class CheckNAndItsDoubleExist {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> nums = new HashSet<>();

        for (int num : arr) {
            nums.add(num);
        }

        for (int num : nums) {
            if (num % 2 == 0 && nums.contains(num / 2)) {
                System.out.println(num);
                System.out.println(num * 2);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        checkIfExist(new int[] {-2,0,10,-19,4,6,-8});
    }
}
