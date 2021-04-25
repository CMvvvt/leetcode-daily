public class P897_IncreasingOrderSearchTree {
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
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            TreeNode dummyNode = new TreeNode(-1);
            TreeNode head = dummyNode;
            for(int val: res) {
                head.right = new TreeNode(val);
                head = head.right;
            }
            return dummyNode.right;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if(root == null) return;
            helper(root.left, res);
            res.add(root.val);
            helper(root.right,res);
        }
    }
}
