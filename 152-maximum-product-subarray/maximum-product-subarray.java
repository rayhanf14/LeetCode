class Solution {
    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int res = nums[0];
        for (int num : nums) {
            if (num == 0) {
                max = 1;
                min = 1;
                res = Math.max(res, 0);
                continue;
            }
            int temp = max * num;
            max = Math.max(num, Math.max(temp, min * num));
            min = Math.min(num, Math.min(temp, min * num));
            res = Math.max(res, max);
        }
        return res;
    }
}