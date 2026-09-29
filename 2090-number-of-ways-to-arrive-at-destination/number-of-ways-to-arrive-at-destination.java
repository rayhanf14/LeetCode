class Solution {

    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> g = new ArrayList<>();
        for(int i = 0; i < n; i++){
            g.add(new ArrayList<>());
        }
        for (int[] x : roads) {
            g.get(x[0]).add(new long[]{x[1], x[2]});
            g.get(x[1]).add(new long[]{x[0], x[2]});
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        while(!pq.isEmpty()){
            long[] current = pq.poll();
            int node = (int) current[0];
            long d = current[1];
            if(d > dist[node]){
                continue;
            }
            for(long[] edge: g.get(node)){
                int next = (int) edge[0];
                long w = edge[1];
                long newDist = w + d;
                if(newDist < dist[next]){

                    dist[next] = newDist;
                    ways[next] = ways[node];

                    pq.offer(new long[]{next, newDist});
                }
                else if(newDist == dist[next]){

                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}