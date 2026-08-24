class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int s = -1;
        for (int i = lower; i <= upper; i++) {
            if (!set.contains(i)) {
                if (s == -1) {
                    s = i;
                }
            } else {
                if (s != -1) {
                    ans.add(List.of(s, i - 1));
                    s = -1;
                }
            }
        }
        if (s != -1) {
            ans.add(List.of(s, upper));
        }
        return ans;
    }
}