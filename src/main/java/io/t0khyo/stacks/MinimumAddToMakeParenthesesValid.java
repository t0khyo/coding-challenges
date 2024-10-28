package io.t0khyo.stacks;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int closedP = 0;
        int openP = 0;
        int swapCount = 0;

        for (char p : s.toCharArray()) {
            if (p == '(') {
                openP++;
            } else {
                closedP++;

                if (openP < closedP) {
                    swapCount++;
                    closedP--;
                }
            }
        }

        return Math.abs(openP - closedP + swapCount);
    }
}
