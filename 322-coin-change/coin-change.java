class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return helper(coins, amount);
    }

    int helper(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(dp[amount] != -2) return dp[amount];

        int ans = Integer.MAX_VALUE;

        for(int c : coins) {
            int res = helper(coins, amount - c);
            if(res != -1) {
                ans = Math.min(ans, 1 + res);
            }
        }

        dp[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return dp[amount];
    }
}