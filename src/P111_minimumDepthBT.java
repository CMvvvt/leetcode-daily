public class P111_minimumDepthBT {/**
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if(root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth+1;
    }
}
    class Solution2 {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (root.left == null || root.right == null) ? left + right + 1: Math.min(left, right) + 1;
        }
    }

    class Solution3 {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;
            int m = minDepth(root.left);
            int n = minDepth(root.right);
            if(root.left == null || root.right == null) {
                return m + n + 1;
            }
            return Math.min(m, n) + 1;
        }
    }

    /**
     * iteration BFS method
     */
    class Solution4 {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 0;
            while(! queue.isEmpty()) {
                int size = queue.size();
                level++;
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node. right != null) {
                        queue.offer(node.right);
                    }
                    if(node.left == null && node.right == null) {
                        return level;
                    }
                }
            }
            return level;
        }
    }
}
