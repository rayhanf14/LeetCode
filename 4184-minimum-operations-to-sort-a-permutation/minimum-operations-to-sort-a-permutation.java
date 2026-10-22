class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        int pos0 = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }

        boolean increasing = true;

        for (int i = 0; i < n; i++) {

            int next = nums[(i + 1) % n];

            if (next != (nums[i] + 1) % n) {
                increasing = false;
                break;
            }
        }

        boolean decreasing = true;

        for (int i = 0; i < n; i++) {

            int next = nums[(i + 1) % n];

            if (next != (nums[i] - 1 + n) % n) {
                decreasing = false;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Cyclic increasing
        if (increasing) {

            // only rotations
            ans = Math.min(ans, pos0);

            // reverse + rotations + reverse
            ans = Math.min(ans, 2 + Math.min(pos0, n - pos0));
        }

        // Cyclic decreasing
        if (decreasing) {

            // reverse + rotations
            ans = Math.min(ans,
                    1 + Math.min(n - 1 - pos0, pos0 + 1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}