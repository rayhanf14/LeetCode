class Solution {
    public int countSubstrings(String s) {
        if(s.length() < 2){
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans += expand(s, i, i) + expand(s, i, i + 1);
        }
        return ans;
        
    }
    int expand(String s, int left, int right){
        int c = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            c++;
            left--;
            right++;
        }
        return c;
    }
}