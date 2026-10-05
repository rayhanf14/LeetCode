class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(0);
            } else {
                int score = stack.pop();
                if(score == 0){
                    score = 1;
                } 
                else {
                    score = 2 * score;
                }
                stack.push(stack.pop() + score);
            }
        }
        return stack.pop();
    }
}