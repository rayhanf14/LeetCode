class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][2001];
        return helper(nums, 0, 0, target, dp);
    }

    static int helper(int[] nums, int index, int sum, int target, Integer[][] dp) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        int x = 1000;
        if (dp[index][sum + x] != null) {
            return dp[index][sum + x];
        }
        int add = helper(nums, index + 1, sum + nums[index], target, dp);
        int subtract = helper(nums, index + 1, sum - nums[index], target, dp);
        return dp[index][sum + x] = add + subtract;
    }
}