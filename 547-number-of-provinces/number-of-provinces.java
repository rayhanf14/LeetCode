class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(find(parent[i]));
        }
        return set.size();
    }
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            return;
        }
        parent[py] = px;
        return;
    }
}