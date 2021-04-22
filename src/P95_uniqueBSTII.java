public class P95_uniqueBSTII {
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
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> ans = new ArrayList<TreeNode>();
            if(n == 0) {
                return ans;
            }
            return getAns(1,n);
        }
        private List<TreeNode> getAns(int start, int end) {
            List<TreeNode> ans = new ArrayList<TreeNode>();
            if(start > end) {
                ans.add(null);
                return ans;
            }
            if(start == end) {
                TreeNode tree = new TreeNode(start);
                ans.add(tree);
                return ans;
            }
            for (int i = start; i <= end; i++) {
                //得到所有可能的左子树
                List<TreeNode> leftTrees = getAns(start, i - 1);
                //得到所有可能的右子树
                List<TreeNode> rightTrees = getAns(i + 1, end);
                //左子树右子树两两组合
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        //加入到最终结果中
                        ans.add(root);
                    }
                }
            }
            return ans;

        }
    }
}
