class Solution {
    int[][] dp;

    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }

        if (s % 2 != 0) {
            return false;
        }

        s = s / 2;
        dp = new int[nums.length][s + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(nums, s, 0);
    }

    boolean helper(int[] nums, int target, int i) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length || target < 0) {
            return false;
        }
        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }
        boolean pick = helper(nums, target - nums[i], i + 1);
        boolean skip = helper(nums, target, i + 1);
        boolean ans = pick || skip;
        if (ans) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = 0;
        }

        return ans;
    }
}