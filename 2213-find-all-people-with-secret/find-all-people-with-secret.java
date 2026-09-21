/*
Approach: Sort meetings by time and use DSU (Union-Find).
For each group of meetings at the same time, temporarily union all
participants so the secret can propagate instantly through the entire
connected component. After processing that time, keep the connections
for components connected to person 0 (who represents the secret) and
reset all other connections, since they were only temporary. Finally,
all people connected to person 0 are the ones who know the secret.
Time: O(m log m + m * α(n)), Space: O(n + m)
*/
class Solution {
    int[] parent;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 0 and firstPerson know the secret initially
        union(0, firstPerson);
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            // Find all meetings at this time
            int j = i;
            HashSet<Integer> people = new HashSet<>();
            while (j < meetings.length && meetings[j][2] == time) {

                int u = meetings[j][0];
                int v = meetings[j][1];

                union(u, v);

                people.add(u);
                people.add(v);

                j++;
            }
            // Keep only components connected to person 0
            for (int person : people) {
                if (find(person) == find(0)) {
                    parent[person] = find(0);
                } else {
                    // Break the temporary connection
                    parent[person] = person;
                }
            }

            i = j;
        }
        List<Integer> ans = new ArrayList<>();
        for (int person = 0; person < n; person++) {
            if (find(person) == find(0)) {
                ans.add(person);
            }
        }
        return ans;
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}