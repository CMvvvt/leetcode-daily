public class P590_NaryTreePostorderTraversal {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    /**
     * recursion
     */
    class Solution1 {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            post(root, list);
            return list;
        }
        private void post(Node node, List<Integer> list) {
            if(node == null) return;
            List<Node> children = node.children;
            for(int i = 0; i < children.size(); i++) {
                post(children.get(i), list);
            }
            list.add(node.val);
            return;
        }
    }

    /**
     * ITERATION APPROACH
     */
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while(!stack1.isEmpty()) {
                Node node = stack1.pop();
                stack2.push(node);
                for(Node child: node.children) {
                    stack1.push(child);
                }
            }
            while(!stack2.isEmpty()) {
                res.add(stack2.pop().val);
            }
            return res;
        }
    }
}
