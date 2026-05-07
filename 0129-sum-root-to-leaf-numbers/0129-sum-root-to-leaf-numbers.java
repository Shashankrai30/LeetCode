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
    public int sumNumbers(TreeNode root) {
       if(root==null) return 0;
        sum=0;
        
        helper(root,0);
        
        return sum;
    }
    
    void helper(TreeNode root,int value){
        if(root.left==null && root.right==null){
            value=value*10+root.val;
            sum=sum+value;
            return;
        }
        
        value=value*10+root.val;
        
        if(root.left!=null){
            helper(root.left,value);
        }
        
        if(root.right!=null){
            helper(root.right,value);
        }
    }
}