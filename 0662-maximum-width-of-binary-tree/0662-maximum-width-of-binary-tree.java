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
    class pair {
        TreeNode node;
        int index;

        public pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<pair> dq = new ArrayDeque<>();

        dq.offer(new pair(root, 0));

        int max = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();

            int first = dq.peekFirst().index;
            int last = dq.peekLast().index;
            max = Math.max(max, last - first + 1);

            for (int i = 0; i < size; i++) {
                pair temp = dq.poll();
                int ind = temp.index;

                if (temp.node.left != null) {
                    dq.offer(new pair(temp.node.left, 2 * ind + 1));
                }

                if (temp.node.right != null) {
                    dq.offer(new pair(temp.node.right, 2 * ind + 2));
                }
            }
        }

        return max;
    }
}