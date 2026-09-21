class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean[][] visitedPacific = new boolean[m][n];
                boolean[][] visitedAtlantic = new boolean[m][n];
                if(helper(i,j,heights,0,visitedPacific) && helper(i,j,heights,1,visitedAtlantic)){
                    ans.add(List.of(i,j));
                }
            }
        }
        return ans;
    }
    boolean helper(int i,int j,int[][] heights,int flag,boolean[][] visited){
        if(flag == 0 && (i < 0 || j < 0)){
            return true;
        }
        if(flag == 1 && (i >= heights.length || j >= heights[0].length)){
            return true;
        }
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length){
            return false;  
        } 
        if(visited[i][j]){
            return false;
        } 
        visited[i][j] = true;
        for(int[] d : dirs){
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc] > heights[i][j]) continue;
            if(helper(nr,nc,heights,flag,visited)){
                return true;
            } 
        }
        return false;
    }
}