public class P114_faltenBTtoLinkedList {
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
        public void flatten(TreeNode root) {
            if(root == null) return;
            Deque<TreeNode> path = new LinkedList<>();
            preOrder(root, path);
            path.removeFirst();
            while(!path.isEmpty()) {
                root.left = null;
                root.right = path.removeFirst();
                root = root.right;
            }
            return;
        }

        private void preOrder(TreeNode root, Deque<TreeNode> path) {
            if(root == null) return;
            path.addLast(root);
            preOrder(root.left, path);
            preOrder(root.right, path);
            return;
        }
    }
}
