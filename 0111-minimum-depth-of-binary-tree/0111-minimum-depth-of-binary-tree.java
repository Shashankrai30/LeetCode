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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;

        return helper(root);
    }

    int helper(TreeNode root){
        if(root.left==null && root.right==null) return 1;

        int left=Integer.MAX_VALUE;
        if(root.left!=null){
            left=helper(root.left);
        }

        int right=Integer.MAX_VALUE;
        if(root.right!=null){
            right=helper(root.right);
        }

        return 1 + Math.min(left,right);
    }
}