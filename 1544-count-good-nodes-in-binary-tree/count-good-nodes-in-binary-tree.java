/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val);
        return ans;
    }
    void helper(TreeNode node, int max){
        if(node == null){
            return;
        }
        if(node.val >= max){
            ans++;
        }
        max = Math.max(node.val, max);
        helper(node.left, max);
        helper(node.right, max);
    }
}