class Solution {
    int m;
    int n;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 || visited[i][j] == 1){
                    continue;
                }
                ans = Math.max(ans, dfs(i, j, grid, visited));
            }
        }
        return ans;
    }
    int dfs(int i, int j, int[][] g, int[][] v){
        if(i >= m || i < 0 || j >= n || j < 0){
            return 0;
        }
        if(g[i][j] == 0 || v[i][j] == 1){
            return 0;
        }
        v[i][j] = 1;
        int res = 1;
        for(int[] d: dirs){
            int nr = d[0] + i;
            int nc = d[1] + j;
            res += dfs(nr, nc, g, v);
        }
        return res;
    }
}