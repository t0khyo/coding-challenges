package io.t0khyo.misc;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifferance {
    // nLog(n)
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0;i < timePoints.size();i++) {
            int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int m = Integer.parseInt(timePoints.get(i).substring(3));

            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        int minTimeDiff = Integer.MAX_VALUE;
        for (int i = 0;i < minutes.length - 1;i++) {
            minTimeDiff = Math.min(minTimeDiff, minutes[i + 1] - minutes[i]);
        }

        return Math.min(
                minTimeDiff,
                24 * 60 - minutes[minutes.length - 1] + minutes[0]
        );
    }
}
