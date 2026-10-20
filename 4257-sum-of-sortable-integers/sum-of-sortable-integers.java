import java.util.*;
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) ans++;
        for (int k = 2; k <= n; k++) {
            if (n % k != 0) continue;
            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i += k) {
                int d = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    int next = i + (j - i + 1) % k;
                    if (nums[j] > nums[next]) d++;
                }
                if (d > 1 || min < prevMax) {
                    valid = false;
                    break;
                }
                prevMax = max;
            }
            if (valid) ans += k;
        }
        return ans;
    }
}