
class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] nprime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!nprime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    nprime[j] = true;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (!nprime[i]) {
                if (sum + i > s) {
                    break;
                }
                sum += i;
                ans.add(i);
            }
        }

        return ans;
    }
}
