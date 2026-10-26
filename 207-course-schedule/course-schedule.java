class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] p: prerequisites){
            int c = p[0];
            int pre = p[1];
            graph.get(pre).add(c);
        }
        int[] states = new int[numCourses];
        for(int i = 0; i < states.length; i++){
            if(states[i] == 0){
                if(!dfs(graph, states, i)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(List<List<Integer>> graph, int[] states, int i){
        if(states[i] == 1){
            return false;
        }
        if(states[i] == 2){
            return true;
        }
        states[i] = 1;
        for(int next: graph.get(i)){
            if(!dfs(graph, states, next)){
                return false;
            }
        }
        states[i] = 2;
        return true;
    }
}