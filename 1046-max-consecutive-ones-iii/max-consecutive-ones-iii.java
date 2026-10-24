class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int max = -1;
        int nz = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                nz++;
            }
            while (nz > k) {
                if (nums[l] == 0) {
                    nz--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}