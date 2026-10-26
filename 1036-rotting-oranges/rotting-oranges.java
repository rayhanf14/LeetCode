class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    int m,n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int ans = 0;

        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];

                for(int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if(grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
            ans++;
        }
        if(fresh == 0) return ans;
        return -1;
    }
}