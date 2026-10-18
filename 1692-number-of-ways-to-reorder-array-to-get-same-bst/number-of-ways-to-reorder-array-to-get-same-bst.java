import java.util.*;

class Solution {
    int MOD = 1_000_000_007;
    long[] fact, invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (int) ((solve(list) - 1 + MOD) % MOD);
    }

    long power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }

    long comb(int n, int r) {
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    long solve(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) {
            return 1;
        }
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        long ways = comb(n - 1, left.size());
        ways = ways * solve(left) % MOD;
        ways = ways * solve(right) % MOD;
        return ways;
    }
}