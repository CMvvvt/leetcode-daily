public class P110_balancedBT {
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
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            int leftLevel = getLevel(root.left);
            int rightLevel = getLevel(root.right);
            return (Math.abs(leftLevel - rightLevel) <= 1 && isBalanced(root.left) && isBalanced(root.right));
        }

        private int getLevel(TreeNode node) {
            if(node == null) return 0;
            return Math.max(getLevel(node.left), getLevel(node.right)) + 1;
        }
    }
}
