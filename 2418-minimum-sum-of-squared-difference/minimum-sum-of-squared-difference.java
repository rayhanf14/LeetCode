class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int[] freq = new int[100001];
        int maxD = 0;
        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            maxD = Math.max(maxD, d);
            sum += d;
        }
        if (k >= sum) return 0;
        for (int i = maxD; i > 0 && k > 0; i--) {
            int count = freq[i];
            if (count == 0) continue;
            long req = Math.min((long) count, k);
            freq[i] -= (int) req;
            freq[i - 1] += (int) req;
            k -= req;
        }
        long ans = 0;
        for (int i = maxD; i > 0; i--) {
            ans += (long) freq[i] * i * i;
        }
        return ans;
    }
}