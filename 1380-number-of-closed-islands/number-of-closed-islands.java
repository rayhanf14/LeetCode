class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i, j, grid)) ans++;
            }
        }
        return ans;
    }
    boolean dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (grid[i][j] == 1) return true;
        grid[i][j] = 1;
        boolean closed = true;
        for (int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];
            if (!dfs(nr, nc, grid)) closed = false;
        }
        return closed;
    }
}