
class Solution {
    static final int MOD = 1_000_000_007;
    long[] sum, sq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);
        long ans = 0;
        for (int r = 0; r < n; r++) {
            int prev = last[nums[r]];

            update(1, 0, n - 1, prev + 1, r);

            ans = (ans + sq[1]) % MOD;
            last[nums[r]] = r;
        }
        return (int) ans;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0) return;
        long add = lazy[node];
        long len = r - l + 1;
        sq[node] = (sq[node] + 2 * add * sum[node]
                    + add * add % MOD * len) % MOD;

        sum[node] = (sum[node] + add * len) % MOD;
        if (l != r) {
            lazy[node * 2] = (lazy[node * 2] + add) % MOD;
            lazy[node * 2 + 1] = (lazy[node * 2 + 1] + add) % MOD;
        }
        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        push(node, l, r);
        if (r < ql || l > qr) return;
        if (ql <= l && r <= qr) {
            lazy[node] = 1;
            push(node, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        update(node * 2, l, mid, ql, qr);
        update(node * 2 + 1, mid + 1, r, ql, qr);
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}
