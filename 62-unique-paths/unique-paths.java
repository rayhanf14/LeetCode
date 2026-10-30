class Solution {
    int[][] dp;
    int rm;
    int cm;

    public int uniquePaths(int m, int n) {
        rm = m;
        cm = n;
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if (i >= rm || j >= cm) {
            return 0;
        }
        if (i == rm - 1 && j == cm - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = dfs(i + 1, j) + dfs(i, j + 1);

        dp[i][j] = ans;
        return ans;
    }
}