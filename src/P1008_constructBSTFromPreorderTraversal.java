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
            int len = preorder.length;
            if(len == 0) {
                return null;
            }
            return dfs(preorder, 0, len-1);
        }

        private TreeNode dfs(int[] preorder, int left, int right) {
            if(left > right) return null;
            TreeNode node = new TreeNode(preorder[left]);
            if(left == right) return node;
            int l = left, r = right;
            while(l < r) {
                int mid = l + (r-l+1) / 2;
                if(preorder[mid] < preorder[left]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            node.left = dfs(preorder, left+1, l);
            node.right = dfs(preorder, l+1, right);
            return node;
        }
    }
}
