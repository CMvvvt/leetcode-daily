public class P107_BTLevelOrderTraversal {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<List<Integer>> level = new ArrayDeque<>();
            if(root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> list = new ArrayList<>();
                while(n > 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                    n--;
                }
                level.add(list);
            }
            while(!level.isEmpty()) {
                res.add(level.removeLast());
            }
            return res;
        }
    }
}
