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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        return helper(root,targetSum);
    }

    boolean helper(TreeNode root,int target){
        if(root.left==null && root.right==null){
            if(target-root.val==0) return true;
            return false;
        }

        target=target-root.val;
        boolean left=false;
        if(root.left!=null){
            left=helper(root.left,target);
        }

        boolean right=false;
        if(root.right!=null){
            right=helper(root.right,target);
        }

        return left || right;
    }
}