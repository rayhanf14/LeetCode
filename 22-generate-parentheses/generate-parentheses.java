class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        ans.clear();
        StringBuilder p = new StringBuilder();
        helper(p, n, n);
        return ans;
    }
    void helper(StringBuilder p, int o, int c) {
        if (o == 0 && c == 0) {
            ans.add(p.toString());
            return;
        }
        if (o > 0) {
            p.append('(');
            helper(p, o - 1, c);
            p.deleteCharAt(p.length() - 1);
        }
        if (c > o) {
            p.append(')');
            helper(p, o, c - 1);
            p.deleteCharAt(p.length() - 1);
        }
    }
}