public class P98_validateBST {
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
        public boolean isValidBST(TreeNode root) {
            Deque<Integer> res = new ArrayDeque<>();
            inOrder(root, res);
            while(!res.isEmpty()) {
                int pre = res.removeFirst();
                if(res.isEmpty()) return true;
                int next = res.peekFirst();
                if(next <= pre) return false;
            }
            return true;
        }
        private void inOrder(TreeNode root,  Deque<Integer> res) {
            if(root == null) return;
            inOrder(root.left, res);
            res.addLast(root.val);
            inOrder(root.right, res);
            return;
        }
    }
}
