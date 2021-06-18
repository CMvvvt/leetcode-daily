public class P95_BTInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while(!stack.isEmpty() || curr != null) {
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                TreeNode node = stack.pop();
                list.add(node.val);
                if(node.right != null) {
                    curr = node.right;
                }
            }
            return list;
        }
    }
}
