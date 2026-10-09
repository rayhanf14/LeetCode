class Solution {
    public int minInsertions(String s) {
        int balance = 0;
        int ans = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                balance += 2;
                if(balance % 2 != 0){
                    ans++;
                    balance--;
                }
            }
            else{
                balance--;
                if(balance < 0){
                    ans++;
                    balance = 1;
                }
            }
        }
        return ans + balance;
    }
}