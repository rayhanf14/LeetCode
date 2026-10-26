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
        for(int p: parent){
            set.add(find(p));
        }
        return set.size();

    }
    void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            parent[px] = py;
        }
    }
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}