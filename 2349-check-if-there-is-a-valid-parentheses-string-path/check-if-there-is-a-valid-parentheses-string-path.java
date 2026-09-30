class Solution {
    int m;
    int n;
    int[][] dirs = { { 0, 1 }, { 1, 0 } };
    int[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n][m + n];
        if (grid[0][0] == ')')
            return false;
        if ((m + n - 1) % 2 != 0)
            return false;
        return dfs(0, 0, grid, 0);
    }

    boolean dfs(int i, int j, char[][] grid, int balance) {
    if (i >= m || j >= n) return false;
    if (grid[i][j] == '(') balance++;
    else balance--;
    if (balance < 0) return false;
    int remaining = (m - 1 - i) + (n - 1 - j);
    if (balance > remaining) return false;
    if (memo[i][j][balance] != 0) {
        return memo[i][j][balance] == 1;
    }
    if (i == m - 1 && j == n - 1) {
        return balance == 0;
    }
    boolean ans = false;
    for (int[] d : dirs) {
        int nr = i + d[0];
        int nc = j + d[1];

        if (dfs(nr, nc, grid, balance)) {
            ans = true;
            break;
        }
    }
    memo[i][j][balance] = ans ? 1 : -1;
    return ans;
}
}