class Solution {
    int[][][] dp;
    int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1,0}};
    int MOD = 1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(m, n, maxMove, startRow, startColumn);
    }

    int helper(int m, int n, int max, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }
        if (max == 0) {
            return 0;
        }
        if (dp[r][c][max] != -1) {
            return dp[r][c][max];
        }
        long ans = 0;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            ans += helper(m, n, max - 1, nr, nc);
            ans %= MOD;
        }
        return dp[r][c][max] = (int) ans;
    }
}