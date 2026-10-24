class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return helper(n);
    }
    int helper(int n){
        if(n == 1 || n == 2){
            return n;
        }
        if(dp[n] > 0) return dp[n];
        int ans = helper(n - 1) + helper(n - 2);
        dp[n] = ans;
        return ans;
    }
}