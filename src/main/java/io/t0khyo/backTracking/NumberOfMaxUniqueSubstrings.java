package io.t0khyo.backTracking;

import java.util.HashSet;
import java.util.Set;

public class NumberOfMaxUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();


        return dfs(0, set, s);
    }

    private int dfs(int i, Set<String> set, String s) {
        if (i == s.length()) return 0;

        int result = 0;
        for (int j = i;j < s.length();j++) {
            String subString = s.substring(i, j + 1);

            if (set.contains(subString)) continue;

            set.add(subString);
            result = Math.max(result, 1 + dfs(j + 1, set, s));
            set.remove(subString);
        }

        return result;
    }
}
