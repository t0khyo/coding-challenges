package io.t0khyo.dp;

import java.util.HashMap;

public class FibNumber {
    HashMap<Integer, Integer> memo = new HashMap<>();


    public int fib(int n) {
        int result;

        if (memo.containsKey(n))
            return memo.get(n);
        if (n <= 2) {
            if (n == 0) return 0;
            result = 1;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        memo.put(n, result);
        return result;
    }
}
