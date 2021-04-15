public class P783_minDisBST {
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
        int pre;
        int ans;
        public int minDiffInBST(TreeNode root) {
            ans = Integer.MAX_VALUE;
            pre = -1;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.left);
            if(pre == -1) {
                pre = root.val;
            } else {
                ans = Math.min(ans, root.val - pre);
                pre = root.val;
            }
            dfs(root.right);
        }
    }
}
