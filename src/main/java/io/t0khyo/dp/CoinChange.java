package io.t0khyo.dp;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] memo = new int[amount + 1];

        Arrays.fill(memo, amount + 1);

        // Base case: to make amount 0, 0 coins are required
        memo[0] = 0;

        for (int currentAmount = 1;currentAmount <= amount;currentAmount++) {
            for (int coin : coins) {
                int subProblem = currentAmount - coin;
                if (subProblem >= 0) {
                    memo[currentAmount] = Math.min(memo[currentAmount], memo[subProblem] + 1);
                }
            }
        }

        // If memo[amount] is still infinity, return -1 (no solution)
        return memo[amount] > amount ? -1 : memo[amount];
    }

}
