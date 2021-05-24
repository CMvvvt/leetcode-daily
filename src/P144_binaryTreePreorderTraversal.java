public class P144_binaryTreePreorderTraversal {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        private void dfs(TreeNode root, List<Integer> res) {
            if(root == null) return;
            res.add(root.val);
            dfs(root.left, res);
            dfs(root.right, res);
        }
    }
}
