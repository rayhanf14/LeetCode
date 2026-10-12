class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        long ans = 0;
        int[] bits = new int[30];
        for(int i = 0; i < nums.size(); i++){
            int d = nums.get(i);
            int b = 0;
            while(d > 0){
                if((d & 1) == 1){
                    bits[b] += 1;
                }
                d = d >> 1;
                b++;
            }
        }
        while(k > 0){
            int x = 0;
            for(int i = 0; i < bits.length; i++){
                if(bits[i] > 0){
                    bits[i]--;
                    x |= (1 << i);
                }
            }
            long prod = (long) x * x;
            ans = (ans + prod) % MOD;
            k--;
        }
        return (int) ans;
    }
}