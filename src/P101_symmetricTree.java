public class P101_symmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
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
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }
        private boolean check(TreeNode p, TreeNode q) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(p);
            queue.offer(q);
            while(!queue.isEmpty()) {
                p = queue.poll();
                q = queue.poll();
                if(p == null && q == null) {
                    continue;
                }
                if(p == null || q == null ||(p.val != q.val)) return false;
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            }
            return true;
        }
    }
}
