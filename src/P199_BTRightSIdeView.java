public class P199_BTRightSIdeView {
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
        public List<Integer> rightSideView(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            deque.addLast(root);
            while(! deque.isEmpty()){
                int size = deque.size();
                for(int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    if(i == size - 1) {
                        res.add(node.val);
                    }
                    if(node.left != null) deque.addLast(node.left);
                    if(node.right != null) deque.addLast(node.right);
                }
            }
            return res;
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> rightMostAtLevel = new HashMap<>();
            Stack<TreeNode> treeStack = new Stack<>();
            Stack<Integer> levelStack = new Stack<>();

            int maxDepth = -1;
            treeStack.push(root);
            levelStack.push(0);
            while(! treeStack.isEmpty()) {
                TreeNode node = treeStack.pop();
                int depth = levelStack.pop();
                if(node != null) {
                    maxDepth = Math.max(maxDepth, depth);
                    if(!rightMostAtLevel.containsKey(depth)) {
                        rightMostAtLevel.put(depth, node.val);
                    }
                    treeStack.push(node.left);
                    treeStack.push(node.right);
                    levelStack.push(depth+1);
                    levelStack.push(depth+1);
                }
            }
            for(int i = 0; i <= maxDepth; i++) {
                list.add(rightMostAtLevel.get(i));
            }
            return list;
        }
    }
}
