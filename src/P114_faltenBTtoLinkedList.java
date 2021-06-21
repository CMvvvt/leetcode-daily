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
        public void flatten(TreeNode root) {
            TreeNode curr = root;
            while(curr != null) {
                if(curr.left != null) {
                    TreeNode next = curr.left;
                    TreeNode predecessor = next;
                    while(predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    predecessor.right = curr.right;
                    curr.left = null;
                    curr.right = next;
                }
                curr = curr.right;
            }
            return;
        }
    }

    class Solution3 {
        public void flatten(TreeNode root) {
            TreeNode curr = root;
            while(curr != null) {
                if(curr.left != null) {
                    TreeNode node = curr.left;
                    while(node.right != null) {
                        node = node.right;
                    }
                    TreeNode leftMost = node;
                    TreeNode right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                    leftMost.right = right;
                }
                curr = curr.right;
            }
            return;
        }
    }
}
