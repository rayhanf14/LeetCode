class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[1], b[1]));
        for(int i = 0; i < points.length; i++){
            double d = (double) points[i][0] * points[i][0] + (double) points[i][1] * points[i][1];

            pq.offer(new double[]{i, d});
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            int index = (int) pq.poll()[0];
            ans[i] = points[index];
        }

        return ans;
    }
}