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
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }
        private int height(TreeNode root) {
            if(root == null) return 0;
            int leftTree = height(root.left);
            int rightTree = height(root.right);
            if(leftTree == -1 || rightTree == -1 || Math.abs(leftTree-rightTree) > 1) {
                return -1;
            } else {
                return Math.max(leftTree, rightTree) + 1;
            }
        }
    }
}
