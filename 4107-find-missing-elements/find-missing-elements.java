class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        for(int m: nums){
            if(m < min){
                min = m;
            }
            if(m > max){
                max = m;
            }
            set.add(m);
        }
        for(int i = min; i <= max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}