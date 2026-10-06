class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks) freq[ch - 'A']++;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0) pq.offer(new Integer[]{i, freq[i], 0});
        }
        Queue<Integer[]> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!queue.isEmpty() && queue.peek()[2] == time) pq.offer(queue.poll());
            if(!pq.isEmpty()){
                Integer[] current = pq.poll();
                current[1]--;
                if(current[1] > 0){
                    current[2] = time + n + 1;
                    queue.offer(current);
                }
            }
        }
        return time;
    }
}