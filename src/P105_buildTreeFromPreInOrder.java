public class P105_buildTreeFromPreInOrder {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < preorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(preorder, inorder, 0, 0, inorder.length-1, map);
        }

        private TreeNode helper(int[] preorder,
                                int[] inorder,
                                int preStart,
                                int inStart,
                                int inEnd,
                                HashMap<Integer, Integer> map) {
            if(preStart >= preorder.length || inStart > inEnd) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int rootIndex = map.get(preorder[preStart]);

            root.left = helper(preorder, inorder, preStart+1, inStart, rootIndex-1, map);
            root.right = helper(preorder, inorder, preStart+ rootIndex - inStart+1, rootIndex+1, inEnd, map);
            return root;
        }
    }
}
