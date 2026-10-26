
class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int[][] visited;
    int m,n;
    String s;

    public boolean exist(char[][] board,String word) {
        m = board.length;
        n = board[0].length;
        s = word;
        visited = new int[m][n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(helper(i,j,board,new StringBuilder())){
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(int i,int j,char[][] board,StringBuilder sb) {
        if(i < 0 || j < 0 || i >= m || j >= n ||
           visited[i][j] == 1 || board[i][j] != s.charAt(sb.length())){
            return false;
        }
        sb.append(board[i][j]);
        visited[i][j] = 1;
        if(sb.length() == s.length()){
            return true;
        }
        for(int[] d : dirs){
            int nr = i + d[0];
            int nc = j + d[1];
            if(helper(nr,nc,board,sb)){
                return true;
            }
        }
        visited[i][j] = 0;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
}
