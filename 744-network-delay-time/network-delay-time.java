class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            graph.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            // Already found a shorter path
            if (time > dist[node]) {
                continue;
            }
            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                int newTime = time + weight;
                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.offer(new int[]{next, newTime});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}