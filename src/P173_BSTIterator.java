public class P173_BSTIterator {
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
    class BSTIterator {
        private  Deque<TreeNode> deque;
        public BSTIterator(TreeNode root) {
            deque = new ArrayDeque<>();
            inOrder(root, deque);
        }

        public int next() {
            int val = deque.removeFirst().val;
            return val;
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }

        private void inOrder(TreeNode root, Deque<TreeNode> deque) {
            if(root == null) return;
            inOrder(root.left, deque);
            deque.addLast(root);
            inOrder(root.right, deque);
            return;
        }
    }

    class BSTIterator2 {
        private TreeNode curr;
        private Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            curr = root;
            stack = new Stack();
        }

        public int next() {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            int value = curr.val;
            curr = curr.right;
            return value;
        }

        public boolean hasNext() {
            return curr != null || !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
