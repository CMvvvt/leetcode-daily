public class P1382_balanceBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        List<Integer> inorderSeq = new ArrayList<>();
        public TreeNode balanceBST(TreeNode root) {
            getInorder(root);
            return build(0, inorderSeq.size() - 1);
        }

        private void getInorder(TreeNode root) {
            if(root.left != null) {
                getInorder(root.left);
            }
            inorderSeq.add(root.val);
            if(root.right != null) {
                getInorder(root.right);
            }
        }

        private TreeNode build(int left, int right) {
            int mid = left + (right-left)/2;
            TreeNode node = new TreeNode(inorderSeq.get(mid));
            if(left <= mid - 1) {
                node.left = build(left, mid-1);
            }
            if(right >= mid + 1) {
                node.right = build(mid + 1, right);
            }
            return node;
        }
    }
}
