public class P112_pathSum {
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            if(root.val == targetSum && root.left == null && root.right == null) return true;
            if(root.left == null && root.right == null && root.val != targetSum) return false;
            return (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum-root.val));
        }
    }

    /**
     * 迭代法 queue
     */
    class Solution2 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            Queue<TreeNode> node = new LinkedList<>();
            Queue<Integer> val = new LinkedList<>();
            node.offer(root);
            val.offer(root.val);
            while(!node.isEmpty()) {
                TreeNode tempNode = node.poll();
                int tempVal = val.poll();
                if(tempNode.left == null && tempNode.right == null) {
                    if(tempVal == targetSum) {
                        return true;
                    }
                    continue;
                }
                if(tempNode.left != null) {
                    node.offer(tempNode.left);
                    val.offer(tempVal + tempNode.left.val);
                }
                if(tempNode.right != null) {
                    node.offer(tempNode.right);
                    val.offer(tempVal + tempNode.right.val);
                }
            }
            return false;
        }
    }
}
