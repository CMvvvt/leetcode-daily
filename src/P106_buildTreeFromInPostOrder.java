public class P106_buildTreeFromInPostOrder {
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
        private Map<Integer, Integer> index = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int length = inorder.length;
            for(int i = 0; i < length; i++) {
                index.put(inorder[i], i);
            }
            return build(inorder, postorder, 0, length-1, 0, length-1);
        }

        private TreeNode build(int[] inorder, int[] postorder, int post_l, int post_r, int in_l, int in_r) {
            if(in_l > in_r) return null;
            TreeNode root = new TreeNode(postorder[post_r]);
            int root_index = index.get(postorder[post_r]);
            int size = in_r - root_index;
            root.right = build(inorder, postorder, post_r - size, post_r-1, root_index +1, in_r);
            root.left = build(inorder, postorder, post_l, post_r -size -1, in_l, root_index-1);
            return root;
        }
    }
}
