class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] == target) return true;
            if (nums[left] == nums[m] && nums[m] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[left] <= nums[m]) {
                if (nums[left] <= target && target < nums[m]) {
                    right = m - 1;
                } else {
                    left = m + 1;
                }
            }
            else {
                if (nums[m] < target && target <= nums[right]) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            }
        }
        return false;
    }
}