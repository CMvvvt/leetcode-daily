public class P104_maxDepthOfBT {
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
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            else {
                int leftDepth = maxDepth(root.left);
                int rightDepth = maxDepth(root.right);
                return Math.max(leftDepth, rightDepth) + 1;
            }
        }
    }

    class Solution2 {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size > 0) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                depth++;
            }
            return depth;
        }
    }
}
