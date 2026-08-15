class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            int curr = r; 
            for (int j = 0; j < n / 2; j++) {
                char left = s.charAt((j + r) % n);
                char right = s.charAt((n - 1 - j + r) % n);
                int diff1 = (right - left + 26) % 26;
                int diff2 = (left - right + 26) % 26;
                curr += Math.min(diff1, diff2);
            }
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}