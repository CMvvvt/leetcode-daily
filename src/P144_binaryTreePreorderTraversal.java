public class P144_binaryTreePreorderTraversal {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        private void dfs(TreeNode root, List<Integer> res) {
            if(root == null) return;
            res.add(root.val);
            dfs(root.left, res);
            dfs(root.right, res);
        }
    }

    /**
     *  iteration method added
     *
     */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root == null) return new ArrayList<>();
            List<Integer> list = new ArrayList();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(! stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
            return list;
        }
    }
}
