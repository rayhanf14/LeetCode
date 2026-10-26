class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;
    int m,n;

    public int countIslands(int[][] grid,int k) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 || visited[i][j]) continue;

                long sum = dfs(i,j,grid);
                if(sum % k == 0) ans++;
            }
        }
        return ans;
    }

    long dfs(int i,int j,int[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n ||
           grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        long sum = grid[i][j];

        for(int[] d : dirs) {
            int nr = i + d[0];
            int nc = j + d[1];
            sum += dfs(nr,nc,grid);
        }
        return sum;
    }
}