public class P99_recoverBST {
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
        public void recoverTree(TreeNode root) {
            List<Integer> tree = new LinkedList<>();
            inOrder(root, tree);
            int[] swap = getIndex(tree);
            recover(root, 2, swap[0], swap[1]);
        }

        private void inOrder(TreeNode root, List<Integer> tree) {
            if(root == null) return;
            inOrder(root.left, tree);
            tree.add(root.val);
            inOrder(root.right, tree);
            return;
        }

        private int[] getIndex(List<Integer> tree) {
            int n = tree.size();
            int x = -1, y = -1;
            for(int i = 0; i < n-1; i++){
                if(tree.get(i+1) < tree.get(i)) {
                    y = tree.get(i+1);
                    if(x == -1) {
                        x = tree.get(i);
                    } else {
                        break;
                    }
                }
            }
            return new int[]{x,y};
        }

        private void recover(TreeNode root, int count, int x, int y) {
            if(root != null) {
                if(root.val == x || root.val == y) {
                    root.val = root.val == x ? y: x;
                    if(--count == 0) return;
                }
                recover(root.left, count, x, y);
                recover(root.right, count, x, y);
            }
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
        public void recoverTree(TreeNode root) {
            TreeNode x = null, y = null, pre = null;
            Deque<TreeNode> stack = new ArrayDeque<>();
            while(!stack.isEmpty() || root != null) {
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(pre != null && root.val < pre.val) {
                    y = root;
                    if(x == null) {
                        x = pre;
                    } else {
                        break;
                    }
                }
                pre = root;
                root = root.right;
            }

            swap(x, y);
        }
        private void swap(TreeNode x, TreeNode y) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
}
