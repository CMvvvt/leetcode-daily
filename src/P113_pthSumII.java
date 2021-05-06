public class P113_pthSumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            List<Integer> path = new ArrayList<>();
            dfs(res, path, root, targetSum, 0);
            return res;
        }
        private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int targetSum, int sum) {
            sum += root.val;
            path.add(root.val);
            if(root.left == null && root.right == null) {
                if(sum == targetSum) {
                    res.add(new ArrayList(path));
                } else {
                    return;
                }
            }
            if(root.left != null) {
                dfs(res, path, root.left, targetSum, sum);
                path.remove(path.size()-1);
            }
            if(root.right != null) {
                dfs(res, path, root.right, targetSum, sum);
                path.remove(path.size()-1);
            }
            return;
        }
    }

    class Solution2 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> path = new LinkedList<>();
            dfs(res, path, root, targetSum);
            return res;
        }

        private void dfs(List<List<Integer>> res, Deque<Integer> path, TreeNode node, int targetSum) {
            if(node == null) return;
            targetSum -= node.val;
            path.offerLast(node.val);
            if(node.left == null && node.right == null && targetSum == 0) {
                res.add(new LinkedList<Integer>(path));
            }
            dfs(res, path, node.left, targetSum);
            dfs(res, path, node.right, targetSum);
            path.pollLast();
        }
    }
}
