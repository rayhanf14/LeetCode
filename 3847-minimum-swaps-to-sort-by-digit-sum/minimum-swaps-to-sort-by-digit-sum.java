import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int x = nums[i];

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
            map.put(nums[i], i);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] destination = new int[n];

        for (int i = 0; i < n; i++) {
            destination[map.get(arr[i][0])] = i;
        }
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = destination[j];
                cycleSize++;
            }
            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }
        return swaps;
    }
}