package io.t0khyo.stacks;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        int openP = 0;
        int closedP = 0;
        int count = 0;

        for (char p : s.toCharArray()) {
            if (p == '[') openP++;
            else closedP++;

            if (openP < closedP) {
                count++;
                closedP--;
            }
        }

        return (count + 1) / 2;
    }
}
