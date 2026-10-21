import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Handle trivial case or impossible case
        if (n == 2) {
            if (s.charAt(0) > s.charAt(1)) return -1;
            return 0;
        }
        
        char[] arr = s.toCharArray();
        
        // 1. Check if it is already sorted
        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;
        
        // Create a sorted version to find differences
        char[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        int firstDiff = -1;
        int lastDiff = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArr[i]) {
                if (firstDiff == -1) firstDiff = i;
                lastDiff = i;
            }
        }
        
        // 2. If the misplaced elements don't span the whole string, 1 operation is enough
        if (lastDiff - firstDiff + 1 < n) {
            return 1;
        }
        
        // 3. Check the strict condition for 3 operations
        char minChar = sortedArr[0];
        char maxChar = sortedArr[n - 1];
        
        int maxCount = 0;
        int minCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == maxChar) maxCount++;
            if (arr[i] == minChar) minCount++;
        }
        
        // 3 operations if the unique absolute max is trapped at the start 
        // AND the unique absolute min is trapped at the end
        if (arr[0] == maxChar && maxCount == 1 &&
            arr[n - 1] == minChar && minCount == 1) {
            return 3;
        }
        
        // 4. Otherwise, 2 operations are always sufficient
        return 2;
    }
}