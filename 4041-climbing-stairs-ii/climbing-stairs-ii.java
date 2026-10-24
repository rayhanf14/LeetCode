class Solution {
    int[] dp;

    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, costs, n);
    }

    int helper(int i, int[] costs, int n) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE;
        if (i + 1 <= n)
            ans = Math.min(ans, costs[i] + 1 + helper(i + 1, costs, n));
        if (i + 2 <= n)
            ans = Math.min(ans, costs[i + 1] + 4 + helper(i + 2, costs, n));
        if (i + 3 <= n)
            ans = Math.min(ans, costs[i + 2] + 9 + helper(i + 3, costs, n));

        return dp[i] = ans;
    }
}