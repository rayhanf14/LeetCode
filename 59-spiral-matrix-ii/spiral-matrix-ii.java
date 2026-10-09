class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int val = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                ans[top][i] = val;
                val++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans[i][right] = val;
                val++;
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans[bottom][i] = val;
                    val++;
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans[i][left] = val;
                    val++;
                }
                left++;
            }
        }
        return ans;
    }
}