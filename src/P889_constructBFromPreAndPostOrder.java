public class P889_constructBFromPreAndPostOrder {
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
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            if(pre == null || pre.length == 0) return null;
            return dfs(pre, post);
        }

        private TreeNode dfs(int[] pre, int[] post) {
            if(pre == null || pre.length == 0) return null;
            if(pre.length == 1) return new TreeNode(pre[0]);
            TreeNode root = new TreeNode(pre[0]);
            for(int i = 0; i < post.length; i++) {
                if(post[i] == pre[1]) {
                    int size = i + 1;
                    int[] pre_left = Arrays.copyOfRange(pre, 1, size + 1);
                    int[] pre_right = Arrays.copyOfRange(pre, size + 1, pre.length);
                    int[] post_left = Arrays.copyOfRange(post, 0, size);
                    int[] post_right = Arrays.copyOfRange(post, size, post.length-1);
                    root.left = dfs(pre_left, post_left);
                    root.right = dfs(pre_right, post_right);
                    break;
                }
            }
            return root;
        }
    }
}
