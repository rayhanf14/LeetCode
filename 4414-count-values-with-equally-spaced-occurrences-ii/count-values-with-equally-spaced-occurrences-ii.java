class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (Integer k : map.keySet()) {
            List<Integer> l = map.get(k);
            if (l.size() >= 3) {
                boolean flag = true;
                for (int i = 0; i < l.size() - 2; i++) {
                    if (l.get(i + 1) - l.get(i) != l.get(i + 2) - l.get(i + 1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
        }
        return ans;
    }
}