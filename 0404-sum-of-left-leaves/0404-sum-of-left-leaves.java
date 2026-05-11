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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,0);
        return sum;
    }

    void helper(TreeNode root,int i){
        if(root.left==null && root.right==null){
            if(i==-1){
                sum=sum+root.val;
            }
            return;
        }

        if(root.left!=null){
            helper(root.left,-1);
        }

        if(root.right!=null){
            helper(root.right,1);
        }
    }
}