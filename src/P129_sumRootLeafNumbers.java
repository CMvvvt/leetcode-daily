public class P129_sumRootLeafNumbers {
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
        public int sumNumbers(TreeNode root) {
            if(root == null) return 0;
            List<Integer> res = new ArrayList<>();
            int val = 0;
            dfs(root, res, val);
            int ans = 0;
            while(! res.isEmpty()) {
                ans += res.remove(res.size()-1);
            }
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> res, int val) {
            val = val*10 + root.val;
            if(root.left == null && root.right == null) {
                res.add(val);
            }

            if(root.left != null) dfs(root.left, res, val);
            if(root.right != null) dfs(root.right, res, val);
            return;
        }
    }
}
