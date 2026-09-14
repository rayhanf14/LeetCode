class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        // Course is already in the current DFS path → cycle
        if (state[course] == 1) {
            return false;
        }
        // Already completely processed
        if (state[course] == 2) {
            return true;
        }
        // Mark as currently visiting
        state[course] = 1;
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }
        // Finished processing this course
        state[course] = 2;
        return true;
    }
}