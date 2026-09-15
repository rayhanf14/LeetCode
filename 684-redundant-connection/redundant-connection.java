class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        // Initially, every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int rootU = find(u);
            int rootV = find(v);
            // Already connected this edge creates a cycle
            if (rootU == rootV) {
                return edge;
            }
            // Merge the two components
            parent[rootV] = rootU;
        }
        return new int[]{};
    }
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // Path compression
        parent[x] = find(parent[x]);
        return parent[x];
    }
}