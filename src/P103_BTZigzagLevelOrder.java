public class P103_BTZigzagLevelOrder {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            Deque<TreeNode> deque =  new ArrayDeque<>();
            deque.addLast(root);
            boolean isZigZag = false;
            while(!deque.isEmpty()) {
                int n = deque.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    TreeNode node = new TreeNode();
                    if(isZigZag) {
                        node = deque.removeLast();
                        level.add(node.val);
                        if(node.right != null) {
                            deque.addFirst(node.right);
                        }
                        if(node.left != null) {
                            deque.addFirst(node.left);
                        }
                    } else {
                        node = deque.removeFirst();
                        level.add(node.val);
                        if(node.left != null) {
                            deque.addLast(node.left);
                        }
                        if(node.right != null) {
                            deque.addLast(node.right);
                        }
                    }

                }
                res.add(level);
                isZigZag = !isZigZag;
            }
            return res;
        }
    }
}
