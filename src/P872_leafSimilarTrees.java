public class P872_leafSimilarTrees {
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> res1 = new LinkedList<>();
            List<Integer> res2 = new LinkedList<>();
            dfs(root1, res1);
            dfs(root2, res2);
            return isSame(res1, res2);
        }

        private void dfs(TreeNode root, List<Integer> res) {
            if(root == null) return;
            if(root.left == null && root.right == null) {
                res.add(root.val);
            }
            dfs(root.left, res);
            dfs(root.right, res);
            return;
        }

        private boolean isSame(List<Integer> res1, List<Integer> res2) {
            if(res1.size() != res2.size()) return false;
            while(! res1.isEmpty()) {
                if(res1.remove(res1.size() - 1) != res2.remove(res2.size() - 1)) return false;
            }
            return true;
        }
    }
}
