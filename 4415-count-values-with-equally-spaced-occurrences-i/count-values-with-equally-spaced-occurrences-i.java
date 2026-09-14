class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for(Integer k: map.keySet()){
            if(map.get(k).size() == 3){
                List<Integer> l = map.get(k);
                if(l.get(1) - l.get(0) == l.get(2) - l.get(1)){
                    ans++;
                }
            }
        }
        return ans;
    }
}