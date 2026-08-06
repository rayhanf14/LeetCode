class Solution {

    Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];

        return solve(0, n - 1, nums) >= 0;
    }

    private int solve(int l, int r, int[] nums) {
        if (l == r) {
            return nums[l];
        }

        if (dp[l][r] != null) {
            return dp[l][r];
        }

        int takeLeft = nums[l] - solve(l + 1, r, nums);
        int takeRight = nums[r] - solve(l, r - 1, nums);

        return dp[l][r] = Math.max(takeLeft, takeRight);
    }
}