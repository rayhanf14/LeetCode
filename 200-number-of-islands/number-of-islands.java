class Solution {
    int[][] visited;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 1 || grid[i][j] == '0'){
                    continue;
                }
                dfs(grid, i, j);
                ans++;
            }
        }
        return ans;
    }
    void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if(visited[i][j] == 1 || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = 1;
        for(int[] d : dirs){
            int nr = i + d[0];
            int nc = j + d[1];
            dfs(grid, nr, nc);
        }
    }
}