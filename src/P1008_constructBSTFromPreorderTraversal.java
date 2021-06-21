public class P1008_constructBSTFromPreorderTraversal {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            int n = preorder.length;
            if(n == 1) return new TreeNode(preorder[0]);
            int[] inorder = Arrays.copyOfRange(preorder, 0, n);
            Arrays.sort(inorder);
            return constructFromPreAndInOrder(preorder, inorder);
        }

        private TreeNode constructFromPreAndInOrder(int[] preorder, int[] inorder) {
            int n = preorder.length;
            if(n == 0) return null;
            TreeNode root = new TreeNode(preorder[0]);
            if(n == 1) return root;
            int value = preorder[0];
            int root_index = 0;
            for(int i = 0; i < n; i++) {
                if(preorder[0] == inorder[i]) {
                    root_index = i;
                    break;
                }
            }
            root.left = constructFromPreAndInOrder(Arrays.copyOfRange(preorder, 1, root_index + 1), Arrays.copyOfRange(inorder, 0, root_index));
            root.right = constructFromPreAndInOrder(Arrays.copyOfRange(preorder, root_index + 1, n), Arrays.copyOfRange(inorder, root_index+1, n));
            return root;
        }
    }
}
