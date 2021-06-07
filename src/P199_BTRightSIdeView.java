public class P199_BTRightSIdeView {
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
        public List<Integer> rightSideView(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            deque.addLast(root);
            while(! deque.isEmpty()){
                int size = deque.size();
                for(int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    if(i == size - 1) {
                        res.add(node.val);
                    }
                    if(node.left != null) deque.addLast(node.left);
                    if(node.right != null) deque.addLast(node.right);
                }
            }
            return res;
        }
    }
}
