package io.t0khyo.stacks;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> idxStack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0;i < temperatures.length;i++) {
            // While the current day's temperature is warmer than the temperature at the index stored in the stack
            while (!idxStack.isEmpty() && temperatures[i] > temperatures[idxStack.peek()]) {
                int prevDay = idxStack.pop();
                res[prevDay] = i - prevDay;
            }
            idxStack.push(i);
        }

        return res;
    }
}
