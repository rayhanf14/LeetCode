class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        findPath(0, graph.length - 1, graph, path);
        return ans;
    }

    void findPath(int n, int t, int[][] graph, List<Integer> path) {
        // Add current node to path
        path.add(n);
        // Base case: reached target
        if (n == t) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // Explore all neighbors
        for (int neighbor : graph[n]) {
            findPath(neighbor, t, graph, path);
        }
        // Backtrack
        path.remove(path.size() - 1);
    }
}